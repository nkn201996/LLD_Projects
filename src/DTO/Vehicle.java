package DTO;

import enums.VehicleType;

public class Vehicle {
    String regNumber;
    String color;
    VehicleType vehicleType;

    public Vehicle(String regNumber, String color, VehicleType vehicleType) {
        this.regNumber = regNumber;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
