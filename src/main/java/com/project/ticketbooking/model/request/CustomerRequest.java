package com.project.ticketbooking.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest {
    String name;
    String surname;
    String username;
    String password;
    Integer age;
    Long customerTicketInformation;
    String email;
}
