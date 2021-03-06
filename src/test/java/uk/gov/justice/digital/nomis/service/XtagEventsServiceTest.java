package uk.gov.justice.digital.nomis.service;


import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class XtagEventsServiceTest {

    @Test
    public void appliesFudgeWhenNotCurrentlyInDaylightSavingsTime() {

        final LocalDateTime aWinterDate = LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0);

        final LocalDateTime actual = XtagEventsService.asUtcPlusOne(aWinterDate);

        assertThat(actual).isEqualTo(aWinterDate.plusHours(1L));
    }

    @Test
    public void doesNotApplyFudgeWhenCurrentlyInDaylightSavingsTime() {

        final LocalDateTime aSummerDate = LocalDateTime.of(2020, 7, 1, 0, 0, 0, 0);

        final LocalDateTime actual = XtagEventsService.asUtcPlusOne(aSummerDate);

        assertThat(actual).isEqualTo(aSummerDate);
    }

}