package com.project.ticketbooking.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminRequest {
    @NotBlank(message = "{validation.name.blank}")
    String name;
    @NotBlank(message = "{validation.surname.blank}")
    String surname;
    String username;
    @Size(min = 6, message = "{validation.password.size}")
    @Pattern(regexp = "[a-zA-Z0-9]*", message = "{validation.password.pattern}")
    String password;
    String email;
    Long adminIdentification;
}
