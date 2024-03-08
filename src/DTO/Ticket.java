package DTO;

import enums.VehicleType;

public class Ticket {
    String id;
    Vehicle vehicle;
    ParkingSlot parkingSlot;

    public Ticket(String id, Vehicle vehicle, ParkingSlot parkingSlot) {
        this.id = id;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }
}
