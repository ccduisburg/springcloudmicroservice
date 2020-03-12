package com.concon.messaging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TicketNotification {
    private String ticketId;
    private String accountId;//bilgiyi kime gönderecimiz bilgisi icin
    private String ticketDescription; //mesajin basligi
}
