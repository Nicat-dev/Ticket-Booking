package com.project.ticketbooking.mapper;

import com.project.ticketbooking.model.dto.AdminDto;
import com.project.ticketbooking.model.entity.Admin;
import com.project.ticketbooking.model.request.AdminRequest;
import org.mapstruct.Mapper;

import java.util.List;

import static com.project.ticketbooking.constant.Constant.MAPPER_COMPONENT;

@Mapper(componentModel = MAPPER_COMPONENT)
public interface AdminMapper {

    List<AdminDto> entityListToDtoList(List<Admin> admins);
    AdminDto entityToDto(Admin admin);
    Admin requestToEntity(AdminRequest request);

}
