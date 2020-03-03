package com.dxc.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A FlightDetails.
 */
@Entity
@Table(name = "flight_details")
public class FlightDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull
    @Column(name = "country", nullable = false)
    private String country;

    @NotNull
    @Column(name = "iata", nullable = false)
    private String iata;

    @NotNull
    @Column(name = "latitude", precision = 21, scale = 2, nullable = false)
    private BigDecimal latitude;

    @NotNull
    @Column(name = "longitude", precision = 21, scale = 2, nullable = false)
    private BigDecimal longitude;

    @Column(name = "altitude", precision = 21, scale = 2)
    @JsonIgnore
    private BigDecimal altitude;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public FlightDetails name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public FlightDetails city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public FlightDetails country(String country) {
        this.country = country;
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIata() {
        return iata;
    }

    public FlightDetails iata(String iata) {
        this.iata = iata;
        return this;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public FlightDetails latitude(BigDecimal latitude) {
        this.latitude = latitude;
        return this;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public FlightDetails longitude(BigDecimal longitude) {
        this.longitude = longitude;
        return this;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getAltitude() {
        return altitude;
    }

    public FlightDetails altitude(BigDecimal altitude) {
        this.altitude = altitude;
        return this;
    }

    public void setAltitude(BigDecimal altitude) {
        this.altitude = altitude;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FlightDetails)) {
            return false;
        }
        return id != null && id.equals(((FlightDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "FlightDetails{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", city='" + getCity() + "'" +
            ", country='" + getCountry() + "'" +
            ", iata='" + getIata() + "'" +
            ", latitude=" + getLatitude() +
            ", longitude=" + getLongitude() +
            ", altitude=" + getAltitude() +
            "}";
    }
}
