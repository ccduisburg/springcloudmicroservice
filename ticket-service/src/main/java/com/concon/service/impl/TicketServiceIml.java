package com.concon.service.impl;

import com.concon.dto.TicketDto;
import com.concon.service.TicketService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class TicketServiceIml implements TicketService {

    @Override
    public TicketDto save(TicketDto ticketDto) {
        return null;
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
