package DTO;

import enums.ParkingSlotStatus;
import enums.VehicleType;

public class ParkingSlot {
    String id;
    VehicleType type;
    ParkingSlotStatus parkingSlotStatus;

    String parkingSlotId;

    int parkingFloor;
    Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ParkingSlot(String id, VehicleType type, ParkingSlotStatus parkingSlotStatus, String parkingSlotId, int parkingFloor) {
        this.id = id;
        this.type = type;
        this.parkingSlotStatus = parkingSlotStatus;
        this.parkingSlotId = parkingSlotId;
        this.parkingFloor = parkingFloor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public String getParkingSlotId() {
        return parkingSlotId;
    }

    public void setParkingSlotId(String parkingSlotId) {
        this.parkingSlotId = parkingSlotId;
    }

    public int getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(int parkingFloor) {
        this.parkingFloor = parkingFloor;
    }
}
