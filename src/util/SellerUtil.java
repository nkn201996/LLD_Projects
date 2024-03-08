package util;

import dto.Auction;
import dto.Seller;
import repository.AuctionRepository;
import repository.SellerRepository;

import java.util.List;

public class SellerUtil {
    static public Seller getSellerByName(String sellerName){
        List<Seller> sellerList= SellerRepository.getSellerList();
        for(int i=0;i<sellerList.size();i++){
            if(sellerList.get(i).getName().equals(sellerName)){
                return sellerList.get(i);
            }
        }
        throw new RuntimeException("No Seller Found");
    }

}
