package dto;

import java.util.List;
import java.util.Objects;

public class Seller {
    String name;
    List<Auction> auctionList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return name.equals(seller.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

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

    public Seller(String name, List<Auction> auctionList) {
        this.name = name;
        this.auctionList = auctionList;
    }
}
