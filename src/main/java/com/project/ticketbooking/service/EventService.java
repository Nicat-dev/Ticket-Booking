package com.project.ticketbooking.service;

import com.project.ticketbooking.model.dto.EventDto;
import com.project.ticketbooking.model.request.EventRequest;

import java.util.List;

public interface EventService {

    EventDto save(EventRequest request);
    List<EventDto> getAll();
    EventDto update(EventRequest request,Long id);
    void deleteById(Long id);
    EventDto get(Long id);

}
