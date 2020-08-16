package com.afp.reactivedatasql.service;

import com.afp.reactivedatasql.domains.Reservation;

import reactor.core.publisher.Flux;

/**
 * <p>
 *  
 * </p>
 * 
 * @author Andrés Felipe Posada Ramírez.
 * @since Aug 16, 2020 4:04:13 PM
 * @version 1.0
 *
 */
public interface ReservationService {
  
  Flux<Reservation> saveAll(String ...names);

}
