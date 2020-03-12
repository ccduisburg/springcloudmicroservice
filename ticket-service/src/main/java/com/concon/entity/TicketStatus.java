package com.concon.entity;

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("Acik"),
    IN_PROGRESS("Calisiyor"),
    RESOLVED("Cözüldü"),
    CLOSED("Kapandi");
    private String label;
    TicketStatus(String label){
        this.label=label;
    }

}
