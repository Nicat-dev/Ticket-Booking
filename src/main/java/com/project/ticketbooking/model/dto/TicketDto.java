package com.project.ticketbooking.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketDto {

    Long id;
    String ticketType;
    CustomerDto customerDto;
    EventDto eventDto;

}
