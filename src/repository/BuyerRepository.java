package repository;

import dto.Auction;
import dto.Buyer;
import java.util.*;

public class BuyerRepository {
    static List<Buyer>buyerList;
    static Map<String, Auction>buyerAuctionMap;

    public BuyerRepository(){
        buyerList=new ArrayList<>();
        buyerAuctionMap=new HashMap<>();
    }
    public static List<Buyer> getBuyerList(){
        return buyerList;
    }
    public static Map<String,Auction> getBuyerAuctionMap(){
        return buyerAuctionMap;
    }
}
