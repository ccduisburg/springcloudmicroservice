package com.concon.dto;

import lombok.Builder;

import java.util.Date;

@Builder
public class TicketDto {
    private String id;

    private String description;

    private String notes;

    private String assignee;

    private Date ticketDate;

    private String priortyType;

    private String ticketStatus;

    public TicketDto(String id, String description, String notes, String assignee, Date ticketDate, String priortyType, String ticketStatus) {
        this.id = id;
        this.description = description;
        this.notes = notes;
        this.assignee = assignee;
        this.ticketDate = ticketDate;
        this.priortyType = priortyType;
        this.ticketStatus = ticketStatus;
    }

    public TicketDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Date getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getPriortyType() {
        return priortyType;
    }

    public void setPriortyType(String priortyType) {
        this.priortyType = priortyType;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
