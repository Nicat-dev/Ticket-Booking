package com.project.ticketbooking.service;

import com.project.ticketbooking.model.dto.TicketDto;
import com.project.ticketbooking.model.request.TicketRequest;

import java.util.List;

public interface TicketService {

    TicketDto save(TicketRequest request);
    TicketDto update(TicketRequest request,Long id);
    TicketDto get(Long id);
    List<TicketDto> getAll();
    void delete(Long id);

}
