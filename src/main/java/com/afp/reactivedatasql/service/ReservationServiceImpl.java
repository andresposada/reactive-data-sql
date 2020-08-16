package com.afp.reactivedatasql.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.reactive.TransactionalOperator;
import org.springframework.util.Assert;

import com.afp.reactivedatasql.domains.Reservation;
import com.afp.reactivedatasql.repository.ReservationRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Andrés Felipe Posada Ramírez.
 * @since Aug 16, 2020 3:59:28 PM
 * @version 1.0
 *
 */
@Service
@Transactional
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

  final ReservationRepository reservationRepository;
  final TransactionalOperator transactionalOperator;

  @Override
  public Flux<Reservation> saveAll(String... names) {
    Flux<Reservation> reservations = Flux.fromArray(names)
        .map(name -> new Reservation(null, name))
        .flatMap(this.reservationRepository::save)
        .doOnNext(this::assertValid);
    
    return reservations;
//    return transactionalOperator.transactional(reservations);
  }

  private void assertValid(Reservation reservation) {
    Assert.isTrue(reservation.getName() != null && reservation.getName().length() > 0
        && Character.isUpperCase(reservation.getName().charAt(0)), "The name must start with a capital letter");
  }

}
