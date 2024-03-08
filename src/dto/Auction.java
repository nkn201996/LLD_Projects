package dto;
import java.util.*;
public class Auction {
    String name;
    int minValue;
    int maxValue;
    String seller_name;
    boolean isActive;
    Map<String,Integer>buyerBidMap;

    public String getName() {
        return name;
    }

    public Auction(String name, int minValue, int maxValue, String seller_name, boolean isActive) {
        this.name = name;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.seller_name = seller_name;
        this.isActive = isActive;
        this.buyerBidMap = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Map<String,Integer> getBuyerBidMap() {
        return buyerBidMap;
    }

    public void setBuyerBidMap(Map<String,Integer> buyerBidMap) {
        this.buyerBidMap = buyerBidMap;
    }
}
