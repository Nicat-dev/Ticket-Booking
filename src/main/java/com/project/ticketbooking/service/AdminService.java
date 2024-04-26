package com.project.ticketbooking.service;

import com.project.ticketbooking.model.dto.AdminDto;
import com.project.ticketbooking.model.entity.Admin;
import com.project.ticketbooking.model.request.AdminRequest;

import java.util.List;

public interface AdminService {

    AdminDto save(AdminRequest request);
    AdminDto update(AdminRequest request,Long id);
    List<AdminDto> getList();
    AdminDto getById(Long id);
    AdminDto getByUsername(String username);
    void delete(Long id);
    Admin find(Long id);

}
