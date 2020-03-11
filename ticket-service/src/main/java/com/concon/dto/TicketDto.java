package com.concon.dto;

import com.concon.entity.PriorityType;
import com.concon.entity.TicketStatus;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
    private String id;

    private String description;

    private String notes;

    private String assignee;

    private Date ticketDate;

    private String priortyType;

    private String ticketStatus;
}
