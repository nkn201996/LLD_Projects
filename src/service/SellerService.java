package service;

import dto.Auction;
import dto.Seller;
import repository.AuctionRepository;
import repository.SellerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static util.AuctionUtil.getAuctionByName;
import static util.AuctionUtil.getAuctionWinner;
import static util.SellerUtil.getSellerByName;
public class SellerService {
    List<Seller> sellerList= SellerRepository.getSellerList();
    List<Auction> auctionList= AuctionRepository.getAuctionList();
    Map<String,Auction> sellerAuctionMap=SellerRepository.getSellerAuctionMap();

    //Add_SELELR
    public void ADD_SELLER(String sellerName){
        Seller seller=new Seller(sellerName, new ArrayList<>());
        sellerList.add(seller);
    }

    //CREATE_AUCTION
    public void CREATE_AUCTION(String auctionName, int minBid, int maxBid, String sellerName){
        Seller seller=getSellerByName(sellerName);
        if(!sellerList.contains(seller)){
            throw new RuntimeException("Invalid Seller");
        }
        Auction auction=new Auction(auctionName, minBid, maxBid, sellerName, true);
        auctionList.add(auction);
        sellerAuctionMap.put(sellerName, auction);
        seller.getAuctionList().add(auction);
    }

    public void CLOSE_AUCTION(String auctionName){
        Auction auction=getAuctionByName(auctionName, auctionList);
        if(!auctionList.contains(auction)){
            throw new RuntimeException("InValid Auction");
        }
        String winner=getAuctionWinner(auction);
        auctionList.remove(auction);
    }
}
