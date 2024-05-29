package com.project.ticketbooking.mapper;

import com.project.ticketbooking.model.dto.TicketDto;
import com.project.ticketbooking.model.entity.Ticket;
import com.project.ticketbooking.model.request.TicketRequest;
import org.mapstruct.Mapper;

import java.util.List;

import static com.project.ticketbooking.constant.Constant.MAPPER_COMPONENT;

@Mapper(componentModel = MAPPER_COMPONENT)
public interface TicketMapper {

    Ticket requestToEntity(TicketRequest request);
    List<TicketDto> entityListToDtoList(List<Ticket> ticketList);
    TicketDto entityToDto(Ticket ticket);

}
