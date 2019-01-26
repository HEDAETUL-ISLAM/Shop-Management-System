package model;

import java.util.List;

public class PurchaseInfo{

    private int purchaseId;
    private String userId;
    private Double amount;
    private String purchaseDate;
    private List<PurchaseProduct> purchaseProductList;



    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public Double getAmount(){
        return amount;
    }

    public void setAmount(Double amount){
        this.amount = amount;
    }

    public String getPurchaseDate(){
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    public int getPurchaseId(){
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId){
        this.purchaseId = purchaseId;
    }

    public PurchaseInfo (String userId, Double amount, String purchaseDate, List<PurchaseProduct> purchaseProductList){

        this.userId = userId;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.purchaseProductList = purchaseProductList;
    }



    public List<PurchaseProduct> getPurchaseProductList(){
        return purchaseProductList;
    }

    public void setPurchaseProductList(List<PurchaseProduct> purchaseProductList){
        this.purchaseProductList = purchaseProductList;
    }
    public PurchaseInfo(){
    }

    public String toString(){
        return "PurchaseInfo{" + "purchaseId=" + purchaseId + ", userId=" + userId + ", amount=" + amount + ", purchaseDate=" + purchaseDate + ", purchaseProductList=" + purchaseProductList + '}';
    }
}
