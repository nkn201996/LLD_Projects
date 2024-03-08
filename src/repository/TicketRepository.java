package repository;

import DTO.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    static Map<String,Ticket> ticketMap;
    public TicketRepository(){
        ticketMap=new HashMap<>();
    }
    public static Map<String, Ticket>  getTicketMap(){
        return ticketMap;
    }
}
