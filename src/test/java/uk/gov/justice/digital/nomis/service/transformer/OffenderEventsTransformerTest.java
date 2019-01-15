package uk.gov.justice.digital.nomis.service.transformer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import uk.gov.justice.digital.nomis.CustodyApiApplication;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class OffenderEventsTransformerTest {

    @Test
    public void canDeserializeIntoXtagContent() {

        final ObjectMapper objectMapper = new CustodyApiApplication().objectMapper();

        OffenderEventsTransformer transformer = new OffenderEventsTransformer(mock(TypesTransformer.class), objectMapper);

        assertThat(transformer.xtagContentOf(ImmutableMap.of("x", "y"))).isNotNull();
    }

    @Test
    public void xtagEnqueueTimestampIsSeasonallyAdjustedIntoDaylightSavings() {
        LocalDateTime lastSecondOfWinter = LocalDateTime.of(2019,3,31,00,59, 59);
        LocalDateTime firstSecondOfSummer = lastSecondOfWinter.plusSeconds(1L);
        assertThat(OffenderEventsTransformer.xtagFudgedTimestampOf(lastSecondOfWinter)).isEqualTo(lastSecondOfWinter.minusHours(1L));
        assertThat(OffenderEventsTransformer.xtagFudgedTimestampOf(firstSecondOfSummer)).isEqualTo(firstSecondOfSummer);
    }

    @Test
    public void xtagEnqueueTimestampIsSeasonallyAdjustedIntoUTC() {
        LocalDateTime lastSecondOfSummer = LocalDateTime.of(2019,10,27,01,59, 59);
        LocalDateTime firstSecondOfWinter = lastSecondOfSummer.plusSeconds(1L);
        assertThat(OffenderEventsTransformer.xtagFudgedTimestampOf(lastSecondOfSummer)).isEqualTo(lastSecondOfSummer);
        assertThat(OffenderEventsTransformer.xtagFudgedTimestampOf(firstSecondOfWinter)).isEqualTo(firstSecondOfWinter.minusHours(1L));
    }

}