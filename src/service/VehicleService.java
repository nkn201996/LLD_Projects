package service;

import DTO.Vehicle;
import enums.VehicleType;

public class VehicleService {
    public static Vehicle generateVehicleDTO(VehicleType vehicleType, String regNo, String color){
        Vehicle vehicle=new Vehicle(regNo,color, vehicleType);
        return vehicle;
    }
}
