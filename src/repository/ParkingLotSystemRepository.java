package repository;

import DTO.ParkingFloor;
import DTO.ParkingLotSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotSystemRepository {

    static List<ParkingLotSystem> parkingLotSystemList;
    static Map<String,ParkingLotSystem> parkingLotSystemMap;

    public ParkingLotSystemRepository(){
        parkingLotSystemList=new ArrayList<>();
        parkingLotSystemMap=new HashMap<>();
    }
    public static Map<String, ParkingLotSystem> getParkingLotSystemMap(){
        return parkingLotSystemMap;
    }

    public static List<ParkingLotSystem> getParkingLotSystemList(){
        return parkingLotSystemList;
    }
}
