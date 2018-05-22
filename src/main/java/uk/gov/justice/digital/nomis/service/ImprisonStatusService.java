package uk.gov.justice.digital.nomis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.gov.justice.digital.nomis.api.OffenderImprisonmentStatus;
import uk.gov.justice.digital.nomis.jpa.entity.Offender;
import uk.gov.justice.digital.nomis.jpa.entity.OffenderBooking;
import uk.gov.justice.digital.nomis.jpa.repository.OffenderImprisonStatusesRepository;
import uk.gov.justice.digital.nomis.jpa.repository.OffenderRepository;
import uk.gov.justice.digital.nomis.service.transformer.ImprisonStatusTransformer;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImprisonStatusService {

    private final ImprisonStatusTransformer imprisonStatusTransformer;
    private final OffenderImprisonStatusesRepository offenderImprisonStatusesRepository;
    private final OffenderRepository offenderRepository;

    @Autowired
    public ImprisonStatusService(ImprisonStatusTransformer imprisonStatusTransformer, OffenderImprisonStatusesRepository offenderImprisonStatusesRepository, OffenderRepository offenderRepository) {
        this.imprisonStatusTransformer = imprisonStatusTransformer;
        this.offenderImprisonStatusesRepository = offenderImprisonStatusesRepository;
        this.offenderRepository = offenderRepository;
    }


    @Transactional
    public Page<OffenderImprisonmentStatus> getOffenderImprisonStatuses(Pageable pageable) {
        Page<uk.gov.justice.digital.nomis.jpa.entity.OffenderImprisonStatus> rawImprisonStatusesPage = offenderImprisonStatusesRepository.findAll(pageable);

        List<OffenderImprisonmentStatus> offenderImprisonmentStatuses = rawImprisonStatusesPage.getContent().stream().map(
                imprisonStatusTransformer::offenderImprisonStatusOf
        ).collect(Collectors.toList());

        return new PageImpl<>(offenderImprisonmentStatuses, pageable, rawImprisonStatusesPage.getTotalElements());
    }

    @Transactional
    public Optional<List<OffenderImprisonmentStatus>> offenderImprisonStatusForOffenderId(Long offenderId) {

        Optional<List<uk.gov.justice.digital.nomis.jpa.entity.OffenderImprisonStatus>> maybeImprisonStatuses = Optional.ofNullable(offenderRepository.findOne(offenderId))
                .map(offender ->
                        offender.getOffenderBookings()
                                .stream()
                                .map(OffenderBooking::getOffenderImprisonStatuses)
                                .flatMap(Collection::stream)
                                .collect(Collectors.toList()));

        return maybeImprisonStatuses.map(imprisonStatuses -> imprisonStatuses
                .stream()
                .map(imprisonStatusTransformer::offenderImprisonStatusOf)
                .sorted(byEffectiveStatus())
                .collect(Collectors.toList()));
    }

    public Optional<List<OffenderImprisonmentStatus>> offenderImprisonStatusForOffenderIdAndBookingId(Long offenderId, Long bookingId) {
        Optional<Offender> maybeOffender = Optional.ofNullable(offenderRepository.findOne(offenderId));

        if (!maybeOffender.isPresent()) {
            return Optional.empty();
        }

        Optional<OffenderBooking> maybeOffenderBooking = maybeOffender.get().getOffenderBookings()
                .stream()
                .filter(ob -> ob.getOffenderBookId().equals(bookingId))
                .findFirst();

        return maybeOffenderBooking.map(ob -> ob.getOffenderImprisonStatuses()
                .stream()
                .map(imprisonStatusTransformer::offenderImprisonStatusOf)
                .sorted(byEffectiveStatus())
                .collect(Collectors.toList()));
    }

    private Comparator<OffenderImprisonmentStatus> byEffectiveStatus() {
        return Comparator.comparing(OffenderImprisonmentStatus::getLatestStatus)
                .thenComparing(OffenderImprisonmentStatus::getEffectiveDateTime).reversed()
                .thenComparing(OffenderImprisonmentStatus::getImprisonStatusSeq);
    }

}