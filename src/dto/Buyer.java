package dto;

import java.util.List;

public class Buyer {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Auction> getAuctionList() {
        return auctionList;
    }

    public void setAuctionList(List<Auction> auctionList) {
        this.auctionList = auctionList;
    }

    public Buyer(String name, List<Auction> auctionList) {
        this.name = name;
        this.auctionList = auctionList;
    }

    List<Auction> auctionList;
}
