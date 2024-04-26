package com.project.ticketbooking.model.request;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminRequest {
    String name;
    String surname;
    String username;
    String password;
    String email;
    Long adminIdentification;
}
