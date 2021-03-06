package uk.gov.justice.digital.nomis.jpa.filters;

import com.google.common.collect.ImmutableList;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import uk.gov.justice.digital.nomis.jpa.entity.OffenderProgramProfile;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Builder
@EqualsAndHashCode
public class OffenderProgramProfilesFilter implements Specification<OffenderProgramProfile> {

    @Builder.Default
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime from = null;

    @Builder.Default
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime to = null;

    private Long bookingId;

    @Override
    public Predicate toPredicate(Root<OffenderProgramProfile> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        ImmutableList.Builder<Predicate> predicateBuilder = ImmutableList.builder();

        Timestamp tsFrom = Timestamp.valueOf(from);
        Timestamp tsTo = Timestamp.valueOf(to);

        if (tsFrom.after(tsTo)) {
            Timestamp tsTemp = tsFrom;
            tsFrom = tsTo;
            tsTo = tsTemp;
        }

        Root offenderProgramProfileTable = root;
        Join courseActivityTable = offenderProgramProfileTable.join("courseActivity");
        Join courseSchedulesTable = courseActivityTable.join("courseSchedules");

        predicateBuilder.add(cb.equal(offenderProgramProfileTable.get("offenderBookId"), bookingId))
                .add(cb.or(cb.lessThanOrEqualTo(offenderProgramProfileTable.get("offenderStartDate"), tsTo), offenderProgramProfileTable.get("offenderStartDate").isNull()))
                .add(cb.or(cb.lessThanOrEqualTo(courseActivityTable.get("scheduleStartDate"), tsTo), courseActivityTable.get("scheduleStartDate").isNull()))
                .add(cb.or(cb.lessThanOrEqualTo(courseSchedulesTable.get("scheduleDate"), tsTo), courseSchedulesTable.get("scheduleDate").isNull()))

                .add(cb.or(cb.greaterThanOrEqualTo(offenderProgramProfileTable.get("offenderEndDate"), tsFrom), offenderProgramProfileTable.get("offenderEndDate").isNull()))
                .add(cb.or(cb.greaterThanOrEqualTo(courseActivityTable.get("scheduleEndDate"), tsFrom), courseActivityTable.get("scheduleEndDate").isNull()))
                .add(cb.or(cb.greaterThanOrEqualTo(courseSchedulesTable.get("scheduleDate"), tsFrom), courseSchedulesTable.get("scheduleDate").isNull()));

        ImmutableList<Predicate> predicates = predicateBuilder.build();

        return cb.and(predicates.toArray(new Predicate[predicates.size()]));
    }

}

