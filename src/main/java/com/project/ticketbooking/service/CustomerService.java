package com.project.ticketbooking.service;

import com.project.ticketbooking.model.entity.Customer;
import com.project.ticketbooking.model.dto.CustomerDto;
import com.project.ticketbooking.model.request.CustomerRequest;

import java.util.List;

public interface CustomerService {

    CustomerDto save(CustomerRequest request);
    CustomerDto update(CustomerRequest request,Long id);
    CustomerDto getById(Long id);
    CustomerDto getByUsername(String username);
    List<CustomerDto> getList();
    void delete(Long id);
    Customer find(Long id);


}
