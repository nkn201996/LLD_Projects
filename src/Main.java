import Constants.Commands;
import enums.DISPLAY_TYPE;
import enums.VehicleType;
import service.InMemoryService;
import service.ParkingLotService;
import service.VehicleService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        Scanner scanner=new Scanner(System.in);
        InMemoryService inMemoryService=new InMemoryService();
        ParkingLotService parkingLotService=new ParkingLotService();
        while(true){
            String inp[]=scanner.nextLine().split(" ");
            try{
                switch (inp[0]){
                    case Commands.CREATE:{
                        parkingLotService.createParkingLot(inp[1],Integer.parseInt(inp[2]), Integer.parseInt(inp[3]));
                        break;
                    }
                    case Commands.DISPLAY:{
                        parkingLotService.display(DISPLAY_TYPE.valueOf(inp[1]), VehicleType.valueOf(inp[2]));
                        break;
                    }
                    case Commands.PARK:{
                        parkingLotService.parkVehicle(VehicleService.generateVehicleDTO(VehicleType.valueOf(inp[1]),inp[2], inp[3]));
                        break;
                    }
                    case Commands.UNPARK:{
                        parkingLotService.unParkVehicle(inp[1]);
                        break;
                    }
                    case Commands.EXIT:{
                        System.exit(0);
                    }
                    default:{
                        System.out.println("Invalid Commands");
                    }
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
