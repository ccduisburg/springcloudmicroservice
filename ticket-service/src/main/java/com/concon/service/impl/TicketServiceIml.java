package com.concon.service.impl;

import com.concon.client.AccountDto;
import com.concon.client.AccountServiceClient;
import com.concon.dto.TicketDto;
import com.concon.entity.PriorityType;
import com.concon.entity.Ticket;
import com.concon.entity.TicketStatus;
import com.concon.entity.es.TicketModel;
import com.concon.repository.TicketRepository;
import com.concon.repository.es.TicketElasticRepository;
import com.concon.service.TicketNotificationService;
import com.concon.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//gerekli dependency ile beraber consructer lar eklemek icin
@RequiredArgsConstructor
public class TicketServiceIml implements TicketService {
//elastiksearch ve mysql e beraber kayit yapmak istiyoruz


    private final TicketElasticRepository ticketElasticRepository;
    private final TicketRepository ticketRepository;
    private final TicketNotificationService ticketNotificationService;
    private final AccountServiceClient accountServiceClient;


    @Override
    @Transactional
    public TicketDto save(TicketDto ticketDto)
    {
        //Ticket #Enttity
        Ticket ticket=new Ticket();
        //TODO Acoount api den dogrula
        //ticket.setAssignee();
        ResponseEntity<AccountDto> accountDtoResponseEntity=accountServiceClient.get(ticketDto.getAssignee());

        if(ticketDto.getDescription()==null) throw new IllegalArgumentException("Description bos olamaz");
        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriortyType(PriorityType.valueOf(ticketDto.getPriortyType()));
        ticket.setAssignee( accountDtoResponseEntity.getBody().getId());
        //mysql kaydet
        ticket=ticketRepository.save(ticket);
        //ticket model nesnesi olustur
        TicketModel model=TicketModel.builder()
                            .description(ticket.getDescription())
                            .notes(ticket.getNotes())
                            .id(ticket.getId())
                            .assignee( accountDtoResponseEntity.getBody().getNameSurname())
                            .priorityType(ticket.getPriortyType().getLabel())
                            .ticketStatus(ticket.getTicketStatus().getLabel())
                            .ticketDate(ticket.getTicketDate()).build();

        // elastik kaydet
        ticketElasticRepository.save(model);
        // olusan nesneyi dönüstür
        ticketDto.setId(ticket.getId());
        //Kuyruga Notification u yaz
        ticketNotificationService.sendToQueue(ticket);
       return ticketDto;
    }

    @Override
    public TicketDto update(String id, TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getByid(String ticketId) {
        return null;
    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        return null;
    }


}
