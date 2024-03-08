package service;

import DTO.*;
import enums.DISPLAY_TYPE;
import enums.ParkingSlotStatus;
import enums.VehicleType;
import repository.ParkingLotSystemRepository;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {
    List<ParkingLotSystem>parkingLotSystemList= ParkingLotSystemRepository.getParkingLotSystemList();

    public void createParkingLot(String parkingLotid, int noOfFloors, int noOfSlotsPerFloor){
        List<ParkingFloor> parkingFloorList = new ArrayList<>(noOfFloors);
        for(int i=0;i<noOfFloors;i++){
            List<ParkingSlot> parkingSlotList = new ArrayList<>(noOfSlotsPerFloor);
            for(int j=0;j<noOfSlotsPerFloor;j++){
                ParkingSlot parkingSlot = new ParkingSlot(String.valueOf(j+1), VehicleType.CAR, ParkingSlotStatus.AVAILABLE, parkingLotid, i+1);
                if(j==0){
                    parkingSlot.setType(VehicleType.TRUCK);
                }else if(j==1 || j==2){
                    parkingSlot.setType(VehicleType.BIKE);
                }
                parkingSlotList.add(parkingSlot);
            }
            ParkingFloor parkingFloor=new ParkingFloor(i+1, parkingLotid, parkingSlotList);
            parkingFloorList.add(parkingFloor);
        }
        ParkingLotSystem parkingLotSystem=new ParkingLotSystem(parkingLotid, noOfFloors, noOfSlotsPerFloor,parkingFloorList);
        ParkingLotSystemRepository.getParkingLotSystemMap().put(parkingLotid, parkingLotSystem);
        ParkingLotSystemRepository.getParkingLotSystemList().add(parkingLotSystem);
        System.out.println("Created Parking lot with "+noOfFloors +" and "+ noOfSlotsPerFloor+" slots per floor");
    }

    public void parkVehicle(Vehicle vehicle){
        ParkingLotSystem parkingLotSystem=parkingLotSystemList.get(0);
        List<ParkingFloor> parkingFloorList=parkingLotSystem.getParkingFloorList();
        int parkingFloorIndex=0;
        int floorFullCount=0;
        for(ParkingFloor parkingFloor:parkingFloorList){
            parkingFloorIndex++;
            if(ParkingFloorService.getFreeSlotsCount(parkingFloor,vehicle.getVehicleType())>0){
                Ticket allotmentTicket=ParkingFloorService.allotSlot(parkingFloor,vehicle);
                if(allotmentTicket!=null){
                    System.out.println("parked Vehicle. Ticket ID: "+allotmentTicket.getId());
                    break;
                }
            }else{
                floorFullCount++;
            }
        }
        if(floorFullCount==parkingFloorList.size()){
            System.out.println("Parking Lot Full");
        }
    }

    public void unParkVehicle(String ticketId){
        Ticket ticket=TicketService.getTicketByTicketId(ticketId);
        ParkingSlot parkingSlot=ticket.getParkingSlot();
        Vehicle vehicle=ticket.getVehicle();
        ParkingSlotService parkingSlotService=new ParkingSlotService(parkingSlot);
        parkingSlotService.unallotSlot(parkingSlot, vehicle);
        TicketService.deleteTicket(ticketId);
        System.out.println("Unparked Vehicle with no: " + vehicle.getRegNumber()+" "+vehicle.getColor());
    }

    public void display(DISPLAY_TYPE displayType, VehicleType vehicleType){
        ParkingLotSystem parkingLotSystem=parkingLotSystemList.get(0);
        List<ParkingFloor> parkingFloorList=parkingLotSystem.getParkingFloorList();
        int parkingFloorIndex=0;
        for(ParkingFloor parkingFloor:parkingFloorList){
            parkingFloorIndex++;
            if(displayType.equals(DISPLAY_TYPE.free_count)){
                int freeSlotsCount=ParkingFloorService.getFreeSlotsCount(parkingFloor, vehicleType);
                System.out.println("No of free slots for "+ vehicleType+" on Floor "+ parkingFloor.getParkingFloorNumber()+" : "+freeSlotsCount);
            }else if(displayType.equals(DISPLAY_TYPE.free_slots)){
                System.out.println("No of free slots for "+ vehicleType+" on Floor "+ parkingFloor.getParkingFloorNumber()+" : ");
                ParkingFloorService.getFreeSlots(parkingFloor, vehicleType);
                System.out.println();
            }else if(displayType.equals(DISPLAY_TYPE.occupied_slots)){
                System.out.println("No of free slots for "+ vehicleType+" on Floor "+ parkingFloor.getParkingFloorNumber()+" : ");
                ParkingFloorService.getOccupiedSlots(parkingFloor, vehicleType);
                System.out.println();
            }
        }
    }
}
