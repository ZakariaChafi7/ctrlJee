package com.match.matchticket.controller;
import com.match.matchticket.dto.MatchResponseDto;
import com.match.matchticket.dto.TicketResponseDto;
import com.match.matchticket.service.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketControllerGraphQl {
    @Autowired
    TicketServiceImpl TicketService;
    @QueryMapping
    public List<TicketResponseDto> getTickets(){
        return TicketService.findAll();
    }
    @QueryMapping
    public TicketResponseDto getTicketById(@Argument Long id){
        return  TicketService.findById(id);
    }
    @MutationMapping
    public void deleteTicket( @Argument Long id){
        TicketService.deleteTicket(id);
    }
}

