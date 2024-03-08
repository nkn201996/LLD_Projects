package service;

import dto.Auction;
import dto.Buyer;
import repository.AuctionRepository;
import repository.BuyerRepository;
import java.util.*;
import static util.AuctionUtil.getAuctionByName;
public class BuyerService {
    List<Buyer> buyerList= BuyerRepository.getBuyerList();
    List<Auction> auctionList= AuctionRepository.getAuctionList();

    Map<String,Auction> buyerAuctionMap=BuyerRepository.getBuyerAuctionMap();

    //Add a buyer
    public void ADD_BUYER(String name){
        Buyer buyer=new Buyer(name,new ArrayList<>());
        buyerList.add(buyer);
    }

    //Create a bid
    public void CREATE_BID(String buyerName, String auctionName, int bidAmount){
        Auction auction=getAuctionByName(auctionName,auctionList);
        if(!auction.isActive()){
            throw new RuntimeException("No Auction Found");
        }
        if(bidAmount<auction.getMinValue() && bidAmount>auction.getMaxValue()){
            throw new RuntimeException("BidAmount Not in Range");
        }
        auction.getBuyerBidMap().put(buyerName,bidAmount);
        buyerAuctionMap.put(buyerName, auction);
    }

    //Withdraw a Bid
    public void WITHDRAW_BID(String buyName, String auctionName){
        Auction auction=getAuctionByName(auctionName,auctionList);
        if(!auction.isActive()){
            throw new RuntimeException("Auction is Closed");
        }
        auction.getBuyerBidMap().remove(buyName);
    }

    //UPDATE_BID
    public void UPDATE_BID(String buyerName, String auctionName, int bidAmount){
        Auction auction=getAuctionByName(auctionName,auctionList);
        if(!auction.isActive()){
            throw new RuntimeException("No Auction Found");
        }
        if(bidAmount<auction.getMinValue() && bidAmount>auction.getMaxValue()){
            throw new RuntimeException("BidAmount Not in Range");
        }
        auction.getBuyerBidMap().put(buyerName,bidAmount);
        buyerAuctionMap.put(buyerName,auction);
    }
}
