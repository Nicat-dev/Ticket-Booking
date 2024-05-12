package com.project.ticketbooking.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketRequest {

    Long id;
    String ticketType;
    Long customerId;
    Long eventId;

}
