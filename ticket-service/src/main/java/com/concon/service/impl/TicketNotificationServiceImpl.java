package com.concon.service.impl;

import com.concon.entity.Ticket;
import com.concon.messaging.TicketNotification;
import com.concon.service.TicketNotificationService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
public class TicketNotificationServiceImpl implements TicketNotificationService {
    private final Source source;

    public TicketNotificationServiceImpl(Source source) {
        this.source = source;
    }

    @Override
    public void sendToQueue(Ticket ticket) {
        TicketNotification ticketNotification=new TicketNotification();
        ticketNotification.setAccountId(ticket.getAssignee());
        ticketNotification.setTicketId(ticket.getId());
        ticketNotification.setTicketDescription(ticket.getDescription());

    source.output().send(MessageBuilder.withPayload(ticketNotification).build());
    }
}
