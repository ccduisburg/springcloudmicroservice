package com.concon.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"id"})
@Table(name="ticket")
public class Ticket extends BaseEntityModel{
    @Getter
    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id")
    private String id;
    @Getter
    @Setter
    @Column(name="description",length = 600)
    private String description;
    @Getter
    @Setter
    @Column(name="notes",length = 4000)
    private String notes;
    @Getter
    @Setter
    @Column(name="assignee",length = 50)
    private String assignee;
    @Getter
    @Setter
    private Date ticketDate;
    @Getter
    @Setter
    @Enumerated(EnumType.ORDINAL)
    private PriorityType priortyType;
    @Getter
    @Setter
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;
}
