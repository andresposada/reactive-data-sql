package com.afp.reactivedatasql.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.afp.reactivedatasql.domains.Reservation;

/**
 * <p>
 *  
 * </p>
 * 
 * @author Andrés Felipe Posada Ramírez.
 * @since Aug 16, 2020 1:41:13 PM
 * @version 1.0
 *
 */
public interface ReservationRepository extends ReactiveCrudRepository<Reservation, Integer> {

}
