package service;

import repository.AuctionRepository;
import repository.BuyerRepository;
import repository.SellerRepository;
import util.SellerUtil;

public class InMemory {
    public static AuctionRepository auctionRepository;
    public static SellerRepository sellerRepository;
    public static BuyerRepository buyerRepository;

    public InMemory(){
        auctionRepository=new AuctionRepository();
        sellerRepository=new SellerRepository();
        buyerRepository=new BuyerRepository();
    }
}
