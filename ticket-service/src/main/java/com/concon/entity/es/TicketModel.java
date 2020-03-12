package com.concon.entity.es;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;
@Data
@Builder
@EqualsAndHashCode(of = { "id" } )
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "ticket")
public class TicketModel implements Serializable {
//elastiksearch icin her bir kaydi tutan veriy yapisi index tir
    @Id
    private String id;

    private String description;

    private String notes;

    private String assignee;

    private Date ticketDate;

    private String priorityType;

    private String ticketStatus;
}
