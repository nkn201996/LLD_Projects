import service.BuyerService;
import service.InMemory;
import service.SellerService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        InMemory inMemory=new InMemory();
        BuyerService buyerService=new BuyerService();
        SellerService sellerService=new SellerService();
        while(true){
            String input=scanner.nextLine();
            input=input.trim();
            String []inputArr=input.split(" ");
            try{
                switch (inputArr[0]){
                    case "ADD_BUYER":{
                        buyerService.ADD_BUYER(inputArr[1]);
                        break;
                    }
                    case "ADD_SELLER":{
                        sellerService.ADD_SELLER(inputArr[1]);
                        break;
                    }
                    case "CREATE_AUCTION":{
                        sellerService.CREATE_AUCTION(inputArr[1], Integer.parseInt(inputArr[2]), Integer.parseInt(inputArr[3]), inputArr[4]);
                        break;
                    }
                    case "CREATE_BID":{
                        buyerService.CREATE_BID(inputArr[1], inputArr[2], Integer.parseInt(inputArr[3]));
                        break;
                    }
                    case "WITHDRAW_BID":{
                        buyerService.WITHDRAW_BID(inputArr[1], inputArr[2]);
                        break;
                    }
                    case "UPDATE_BID":{
                        buyerService.UPDATE_BID(inputArr[1], inputArr[2], Integer.parseInt(inputArr[3]));
                        break;
                    }
                    case "CLOSE_AUCTION":{
                        sellerService.CLOSE_AUCTION(inputArr[1]);
                        break;
                    }
                    default:
                        System.out.println("Invalid Commands");
                }
            }catch (RuntimeException runtimeException){
                System.out.println(runtimeException);
            }
        }
    }
}