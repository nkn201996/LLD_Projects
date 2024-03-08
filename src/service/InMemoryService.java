package service;

import DTO.ParkingSlot;
import repository.*;

public class InMemoryService {
    ParkingSlotRepository parkingSlotRepository=new ParkingSlotRepository();
    ParkingLotSystemRepository parkingLotSystemRepository=new ParkingLotSystemRepository();
    ParkingFloorRepository parkingFloorRepository=new ParkingFloorRepository();
    TicketRepository ticketRepository = new TicketRepository();
    VehicleRepository vehicleRepository=new VehicleRepository();
}
