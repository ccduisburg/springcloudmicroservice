package com.concon.service;

import com.concon.entity.Ticket;

public interface TicketNotificationService {
   void  sendToQueue(Ticket ticket);


}
