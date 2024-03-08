package repository;

import DTO.ParkingFloor;
import DTO.ParkingSlot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingSlotRepository {
    List<ParkingSlot> parkingSlotList;
    static Map<String,ParkingSlot> parkingSlotMap;

    public ParkingSlotRepository(){
        parkingSlotList=new ArrayList<>();
    }
    public static Map<String, ParkingSlot> getParkingSlotMap(){
        return parkingSlotMap;
    }
}
