package com.project.ticketbooking.mapper;

import com.project.ticketbooking.model.dto.EventDto;
import com.project.ticketbooking.model.entity.Event;
import com.project.ticketbooking.model.request.EventRequest;
import org.mapstruct.Mapper;

import java.util.List;

import static com.project.ticketbooking.constant.Constant.MAPPER_COMPONENT;

@Mapper(componentModel = MAPPER_COMPONENT)
public interface EventMapper {

    List<EventDto> entityListToDtoList(List<Event> events);
    EventDto entityToDto(Event event);
    Event requestToEntity(EventRequest request);

}
