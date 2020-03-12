package com.concon.notification;

import com.concon.messaging.TicketNotification;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class NotificationDistributionService {
    @StreamListener(Sink.INPUT)
    public void onNotification(TicketNotification ticketNotification){
        System.out.println("----------********- Notification-********-----------");
        System.out.println("Notification alindi Kullanicilara gönderiliyor");
        System.out.println("Notification-> "+ticketNotification.toString());
    }
}
