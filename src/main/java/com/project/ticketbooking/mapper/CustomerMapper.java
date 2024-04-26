package com.project.ticketbooking.mapper;

import com.project.ticketbooking.model.entity.Customer;
import com.project.ticketbooking.model.dto.CustomerDto;
import com.project.ticketbooking.model.request.CustomerRequest;
import org.mapstruct.Mapper;

import java.util.List;

import static com.project.ticketbooking.constant.Constant.MAPPER_COMPONENT;

@Mapper(componentModel = MAPPER_COMPONENT)
public interface CustomerMapper {

    List<CustomerDto> entityListToDtoList(List<Customer> customerList);

    CustomerDto entityToDto(Customer customer);

    Customer requestToEntity(CustomerRequest request);
}
