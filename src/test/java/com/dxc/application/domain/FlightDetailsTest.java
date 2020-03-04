package com.dxc.application.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.dxc.application.web.rest.TestUtil;

public class FlightDetailsTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FlightDetails.class);
        FlightDetails flightDetails1 = new FlightDetails();
        flightDetails1.setId(1L);
        FlightDetails flightDetails2 = new FlightDetails();
        flightDetails2.setId(flightDetails1.getId());
        assertThat(flightDetails1).isEqualTo(flightDetails2);
        flightDetails2.setId(2L);
        assertThat(flightDetails1).isNotEqualTo(flightDetails2);
        flightDetails1.setId(null);
        assertThat(flightDetails1).isNotEqualTo(flightDetails2);
    }
}
