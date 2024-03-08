package DTO;

import java.util.List;

public class ParkingFloor {
    int parkingFloorNumber;
    String parkingLotID;

    List<ParkingSlot> parkingSlotList;

    public ParkingFloor(int parkingFloorNumber, String parkingLotID, List<ParkingSlot> parkingSlotList) {
        this.parkingFloorNumber = parkingFloorNumber;
        this.parkingLotID = parkingLotID;
        this.parkingSlotList = parkingSlotList;
    }

    public int getParkingFloorNumber() {
        return parkingFloorNumber;
    }

    public void setParkingFloorNumber(int parkingFloorNumber) {
        this.parkingFloorNumber = parkingFloorNumber;
    }

    public String getParkingLotID() {
        return parkingLotID;
    }

    public void setParkingLotID(String parkingLotID) {
        this.parkingLotID = parkingLotID;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }
}
