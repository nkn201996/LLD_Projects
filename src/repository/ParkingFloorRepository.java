package repository;

import DTO.ParkingFloor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloorRepository {
    static Map<String,ParkingFloor> ParkingFloorMap;
    
    public ParkingFloorRepository(){
        ParkingFloorMap=new HashMap<>();
    }
    public static Map<String, ParkingFloor> getParkingFloorMap(){
        return ParkingFloorMap;
    }
}
