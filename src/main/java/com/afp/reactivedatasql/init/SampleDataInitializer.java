package com.afp.reactivedatasql.init;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.afp.reactivedatasql.domains.Reservation;
import com.afp.reactivedatasql.repository.ReservationRepository;
import com.afp.reactivedatasql.service.ReservationService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Andrés Felipe Posada Ramírez.
 * @since Aug 16, 2020 1:46:13 PM
 * @version 1.0
 *
 */
@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log4j2
public class SampleDataInitializer {

  
  final ReservationRepository reservationRepository;
  final ReservationService reservationService;

  @EventListener(ApplicationReadyEvent.class)
  public void ready() {
    Flux<Reservation> reservations = reservationService.saveAll("Andrés", "Carlos", "Mauricio", "José", "Juan", "Esteban", "felipe");
    
    this.reservationRepository
    .deleteAll()
    .thenMany(reservations)
    .thenMany(this.reservationRepository.findAll())
    .subscribe(log::info);
    
  }

}
