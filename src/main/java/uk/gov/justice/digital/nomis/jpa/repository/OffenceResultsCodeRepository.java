package uk.gov.justice.digital.nomis.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.gov.justice.digital.nomis.jpa.entity.OffenceResultsCode;

@Repository
public interface OffenceResultsCodeRepository extends JpaRepository<OffenceResultsCode, String> {
}
