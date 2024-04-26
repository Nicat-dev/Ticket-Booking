package com.project.ticketbooking.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminDto {
    Long id;
    String name;
    String surname;
    String username;
    String email;
    Integer age;
    Long adminIdentification;
}
