package service;

import DTO.ParkingSlot;
import DTO.Ticket;
import DTO.Vehicle;
import enums.ParkingSlotStatus;
import repository.ParkingSlotRepository;
import static service.TicketService.generateTicket;

public class ParkingSlotService {
    ParkingSlot parkingSlot;

    public ParkingSlotService(ParkingSlot parkingSlot){
        this.parkingSlot=parkingSlot;
    }

    public Ticket allotSlot(ParkingSlot parkingSlot, Vehicle vehicle) {
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.UNAVAILABLE);
        Ticket ticket = TicketService.generateTicket(parkingSlot, vehicle);
        parkingSlot.setTicket(ticket);
        return ticket;
    }

    public void unallotSlot(ParkingSlot parkingSlot, Vehicle vehicle){
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.AVAILABLE);
        parkingSlot.setTicket(null);
    }
}
