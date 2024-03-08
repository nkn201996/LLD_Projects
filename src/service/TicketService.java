package service;

import DTO.ParkingSlot;
import DTO.Ticket;
import DTO.Vehicle;
import repository.TicketRepository;

public class TicketService {
    public static Ticket generateTicket(ParkingSlot parkingSlot, Vehicle vehicle){
        String ticket_id=generateTicketId(parkingSlot);
        Ticket ticket=new Ticket(ticket_id,vehicle,parkingSlot);
        TicketRepository.getTicketMap().put(ticket_id,ticket);
        return ticket;
    }
    public static String generateTicketId(ParkingSlot parkingSlot){
        return String.valueOf(parkingSlot.getParkingSlotId()+"_"+parkingSlot.getParkingFloor()+"_"+parkingSlot.getId());
    }
    public static Ticket getTicketByTicketId(String ticketId){
        if(!TicketRepository.getTicketMap().containsKey(ticketId)){
            throw new RuntimeException("INVALID TICKET");
        }
        return TicketRepository.getTicketMap().get(ticketId);
    }

    public static void deleteTicket(String ticketId){
        TicketRepository.getTicketMap().remove(ticketId);
    }
}
