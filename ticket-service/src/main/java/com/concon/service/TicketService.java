package com.concon.service;

import com.concon.dto.TicketDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {
    TicketDto save(TicketDto ticketDto);
    TicketDto update(String id,TicketDto ticketDto);
    TicketDto getByid(String ticketId);
    Page<TicketDto> getPagination(Pageable pageable);
}
