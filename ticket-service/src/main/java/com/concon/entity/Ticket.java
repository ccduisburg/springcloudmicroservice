package com.concon.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@EqualsAndHashCode(of={"id"})
@Getter
@Setter
@Table(name="ticket")
public class Ticket extends BaseEntityModel{
    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id")
    private String id;

    @Column(name="description",length = 600)
    private String description;

    @Column(name="notes",length = 4000)
    private String notes;

    @Column(name="assignee",length = 50)
    private String assignee;

    private Date ticketDate;

    @Enumerated(EnumType.ORDINAL)
    private PriorityType priortyType;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;

    public Ticket(String id, String description, String notes, String assignee, Date ticketDate, PriorityType priortyType, TicketStatus ticketStatus) {
        this.id = id;
        this.description = description;
        this.notes = notes;
        this.assignee = assignee;
        this.ticketDate = ticketDate;
        this.priortyType = priortyType;
        this.ticketStatus = ticketStatus;
    }

    public Ticket() {

    }
}
