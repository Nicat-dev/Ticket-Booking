package com.project.ticketbooking.service.impl;

import com.project.ticketbooking.error.ApplicationException;
import com.project.ticketbooking.mapper.CustomerMapper;
import com.project.ticketbooking.model.dto.CustomerDto;
import com.project.ticketbooking.model.entity.Customer;
import com.project.ticketbooking.model.enums.Errors;
import com.project.ticketbooking.model.request.CustomerRequest;
import com.project.ticketbooking.repository.CustomerRepository;
import com.project.ticketbooking.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;


    @Override
    public CustomerDto save(CustomerRequest request) {
        return mapper.entityToDto(repository.save(mapper.requestToEntity(request)));
    }

    @Override
    public CustomerDto update(CustomerRequest request, Long id) {
        return repository.findById(id)
                .map(customer-> {
                    Customer updateCustomer = mapper.requestToEntity(request);
                    updateCustomer.setId(id);
                    return mapper.entityToDto(repository.save(updateCustomer));
                }).orElseThrow(()-> new ApplicationException(Errors.CUSTOMER_NOT_FOUND));
    }

    @Override
    public CustomerDto getById(Long id) {
        return mapper.entityToDto(find(id));
    }

    @Override
    public CustomerDto getByUsername(String username) {
        return mapper.entityToDto(repository.findByUsername(username)
                .orElseThrow(() -> new ApplicationException(Errors.CUSTOMER_NOT_FOUND)));
    }

    @Override
    public List<CustomerDto> getList() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public void delete(Long id) {
        repository.delete(find(id));
    }

    @Override
    public Customer find(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new ApplicationException(Errors.CUSTOMER_NOT_FOUND));
    }
}
