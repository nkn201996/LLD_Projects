package util;

import dto.Auction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuctionUtil {
    static public Auction getAuctionByName(String name, List<Auction> auctionList){
        for(int i=0;i<auctionList.size();i++){
            if(auctionList.get(i).getName().equals(name)){
                return auctionList.get(i);
            }
        }
        throw new RuntimeException("AuctionNotFound");
    }

    static public String getAuctionWinner(Auction auction) {
        Map<String, Integer> buyerBidderMap = auction.getBuyerBidMap();
        Map<Integer, Integer> bidFrequency = new HashMap<>();
        for (Map.Entry<String, Integer> entry : buyerBidderMap.entrySet()) {
            if (bidFrequency.containsKey(entry.getValue())) {
                bidFrequency.put(entry.getValue(), bidFrequency.get(entry.getValue() + 1));
            } else {
                bidFrequency.put(entry.getValue(), 1);
            }
        }
        int maxBid = Integer.MIN_VALUE;
        String auctionWinner = "None";
        int f = 0;
        for (Map.Entry<Integer, Integer> entry : bidFrequency.entrySet()) {
            if (entry.getValue() == 1 && entry.getKey() > maxBid) {
                maxBid = entry.getKey();
                f = 1;
            }
        }
        if (f == 0) {
            throw new RuntimeException("No Winner");
        }
        for (Map.Entry<String, Integer> entry : buyerBidderMap.entrySet()) {
            if (entry.getValue() == maxBid) {
                System.out.println(entry.getKey() + " is Winner ");
                auctionWinner = entry.getKey();
                break;
            }
        }
        return auctionWinner;
    }
}
