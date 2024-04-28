package com.project.ticketbooking.service.impl;

import com.project.ticketbooking.error.ApplicationException;
import com.project.ticketbooking.mapper.EventMapper;
import com.project.ticketbooking.model.dto.EventDto;
import com.project.ticketbooking.model.entity.Event;
import com.project.ticketbooking.model.enums.Errors;
import com.project.ticketbooking.model.request.EventRequest;
import com.project.ticketbooking.repository.EventRepository;
import com.project.ticketbooking.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository repository;
    private final EventMapper mapper;


    @Override
    public EventDto save(EventRequest request) {
        return mapper.entityToDto(repository.save(mapper.requestToEntity(request)));
    }

    @Override
    public List<EventDto> getAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public EventDto update(EventRequest request, Long id) {
        return repository.findById(id)
                .map(event ->{
                    Event updateEvent = mapper.requestToEntity(request);
                    updateEvent.setId(id);
                    return mapper.entityToDto(repository.save(updateEvent));
                }).orElseThrow(()-> new ApplicationException(Errors.EVENT_NOT_FOUND));
    }

    @Override
    public void deleteById(Long id) {
        repository.delete(getById(id));
    }

    @Override
    public EventDto get(Long id) {
        return mapper.entityToDto(getById(id));
    }

    private Event getById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new ApplicationException(Errors.EVENT_NOT_FOUND));
    }
}
