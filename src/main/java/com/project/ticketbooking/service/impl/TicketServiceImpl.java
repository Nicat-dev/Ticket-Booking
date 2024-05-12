package com.project.ticketbooking.service.impl;

import com.project.ticketbooking.error.ApplicationException;
import com.project.ticketbooking.mapper.TicketMapper;
import com.project.ticketbooking.model.dto.TicketDto;
import com.project.ticketbooking.model.entity.Ticket;
import com.project.ticketbooking.model.enums.Errors;
import com.project.ticketbooking.model.request.TicketRequest;
import com.project.ticketbooking.repository.TicketRepository;
import com.project.ticketbooking.service.CustomerService;
import com.project.ticketbooking.service.EventService;
import com.project.ticketbooking.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository repository;
    private final EventService eventService;
    private final CustomerService customerService;
    private final TicketMapper mapper;

    @Override
    public TicketDto save(TicketRequest request) {
        return mapper.entityToDto(repository.save(mapper.requestToEntity(request)));
    }

    @Override
    public TicketDto update(TicketRequest request, Long id) {
        return repository.findById(id)
                .map(ticket -> {
                    Ticket updateTicket = mapper.requestToEntity(request);
                    updateTicket.setId(id);
                    updateTicket.setCustomer(customerService.find(id));
                    updateTicket.setEvent(eventService.find(id));
                    return mapper.entityToDto(repository.save(updateTicket));
                }).orElseThrow(()-> new ApplicationException(Errors.TICKET_NOT_FOUND));
    }

    @Override
    public TicketDto get(Long id) {
        return mapper.entityToDto(repository.findById(id)
                .orElseThrow(()-> new ApplicationException(Errors.TICKET_NOT_FOUND)));
    }

    @Override
    public List<TicketDto> getAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(()-> new ApplicationException(Errors.TICKET_NOT_FOUND)));
    }


}
