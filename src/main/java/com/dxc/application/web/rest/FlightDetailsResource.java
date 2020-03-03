package com.dxc.application.web.rest;

import com.dxc.application.domain.FlightDetails;
import com.dxc.application.repository.FlightDetailsRepository;
import com.dxc.application.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional; 
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.dxc.application.domain.FlightDetails}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class FlightDetailsResource {

    private final Logger log = LoggerFactory.getLogger(FlightDetailsResource.class);

    private static final String ENTITY_NAME = "flightservicesFlightDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FlightDetailsRepository flightDetailsRepository;

    public FlightDetailsResource(FlightDetailsRepository flightDetailsRepository) {
        this.flightDetailsRepository = flightDetailsRepository;
    }

    /**
     * {@code POST  /flight-details} : Create a new flightDetails.
     *
     * @param flightDetails the flightDetails to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new flightDetails, or with status {@code 400 (Bad Request)} if the flightDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/flight-details")
    public ResponseEntity<FlightDetails> createFlightDetails(@Valid @RequestBody FlightDetails flightDetails) throws URISyntaxException {
        log.debug("REST request to save FlightDetails : {}", flightDetails);
        if (flightDetails.getId() != null) {
            throw new BadRequestAlertException("A new flightDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FlightDetails result = flightDetailsRepository.save(flightDetails);
        return ResponseEntity.created(new URI("/api/flight-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /flight-details} : Updates an existing flightDetails.
     *
     * @param flightDetails the flightDetails to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated flightDetails,
     * or with status {@code 400 (Bad Request)} if the flightDetails is not valid,
     * or with status {@code 500 (Internal Server Error)} if the flightDetails couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/flight-details")
    public ResponseEntity<FlightDetails> updateFlightDetails(@Valid @RequestBody FlightDetails flightDetails) throws URISyntaxException {
        log.debug("REST request to update FlightDetails : {}", flightDetails);
        if (flightDetails.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        FlightDetails result = flightDetailsRepository.save(flightDetails);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, flightDetails.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /flight-details} : get all the flightDetails.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of flightDetails in body.
     */
    @GetMapping("/flight-details")
    public List<FlightDetails> getAllFlightDetails() {
        log.debug("REST request to get all FlightDetails");
        return flightDetailsRepository.findAll();
    }

    /**
     * {@code GET  /flight-details/:id} : get the "id" flightDetails.
     *
     * @param id the id of the flightDetails to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the flightDetails, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/flight-details/{id}")
    public ResponseEntity<FlightDetails> getFlightDetails(@PathVariable Long id) {
        log.debug("REST request to get FlightDetails : {}", id);
        Optional<FlightDetails> flightDetails = flightDetailsRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(flightDetails);
    }

    /**
     * {@code DELETE  /flight-details/:id} : delete the "id" flightDetails.
     *
     * @param id the id of the flightDetails to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/flight-details/{id}")
    public ResponseEntity<Void> deleteFlightDetails(@PathVariable Long id) {
        log.debug("REST request to delete FlightDetails : {}", id);
        flightDetailsRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
