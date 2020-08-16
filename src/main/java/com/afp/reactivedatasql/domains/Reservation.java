package com.afp.reactivedatasql.domains;

import org.springframework.data.annotation.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * <p>
 *  
 * </p>
 * @author Andrés Felipe Posada Ramírez
 * @since Aug 16, 2020 1:36:44 PM
 * @version 1.0
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {

  @Id
  Integer id;
  String name;
  
}
