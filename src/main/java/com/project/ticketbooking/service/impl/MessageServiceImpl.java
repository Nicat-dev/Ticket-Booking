package com.project.ticketbooking.service.impl;

import com.project.ticketbooking.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageSource messageSource;

    @Override
    public String getPasswordValidationMessage(Locale locale) {
        return messageSource.getMessage("validation.password.size", null, locale);
    }
}
