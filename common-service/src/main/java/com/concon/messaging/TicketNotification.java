package com.concon.messaging;

public class TicketNotification {
    private String ticketId;
    private String accountId;//bilgiyi kime gönderecimiz bilgisi icin
    private String ticketDescription; //mesajin basligi

    public TicketNotification(String ticketId, String accountId, String ticketDescription) {
        this.ticketId = ticketId;
        this.accountId = accountId;
        this.ticketDescription = ticketDescription;
    }

    public TicketNotification() {
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    @Override
    public String toString() {
        return "TicketNotification{" +
                "ticketId='" + ticketId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", ticketDescription='" + ticketDescription + '\'' +
                '}';
    }
}
