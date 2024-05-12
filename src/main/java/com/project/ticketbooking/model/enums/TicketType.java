package com.project.ticketbooking.model.enums;

public enum TicketType {
    PREMIUM("Premium")
    ,GUEST("Guest")
    ,CLASSIC("Classic");

    private final String displayValue;

    TicketType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
