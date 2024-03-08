package repository;

import DTO.Ticket;
import DTO.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    static Map<String, Vehicle> vehicleMap;
    public VehicleRepository(){
        vehicleMap=new HashMap<>();
    }
    public static Map<String, Vehicle>  getTicketMap(){
        return vehicleMap;
    }
}
