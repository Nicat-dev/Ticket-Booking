package com.project.ticketbooking.service.impl;

import com.project.ticketbooking.error.ApplicationException;
import com.project.ticketbooking.mapper.AdminMapper;
import com.project.ticketbooking.model.dto.AdminDto;
import com.project.ticketbooking.model.entity.Admin;
import com.project.ticketbooking.model.enums.Errors;
import com.project.ticketbooking.model.request.AdminRequest;
import com.project.ticketbooking.repository.AdminRepository;
import com.project.ticketbooking.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository repository;
    private final AdminMapper mapper;

    @Override
    public AdminDto save(AdminRequest request) {
        return mapper.entityToDto(repository.save(mapper.requestToEntity(request)));
    }

    @Override
    public AdminDto update(AdminRequest request, Long id) {
       return repository.findById(id)
                .map(admin -> {
                    Admin updatedAdmin = mapper.requestToEntity(request);
                    updatedAdmin.setId(id);
                    return mapper.entityToDto(repository.save(updatedAdmin));
                })
                .orElseThrow(() -> new ApplicationException(Errors.ADMIN_NOT_FOUND));
    }

    @Override
    public List<AdminDto> getList() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public AdminDto getById(Long id) {
        return mapper.entityToDto(find(id));
    }

    @Override
    public AdminDto getByUsername(String username) {
        return mapper.entityToDto(repository.findByUsername(username)
                .orElseThrow(() -> new ApplicationException(Errors.ADMIN_NOT_FOUND)));
    }

    @Override
    public void delete(Long id) {
        repository.delete(find(id));
    }

    @Override
    public Admin find(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApplicationException(Errors.ADMIN_NOT_FOUND));
    }


}
