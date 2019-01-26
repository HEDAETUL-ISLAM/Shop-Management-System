package model;

public class PurchaseProduct{
    private int purchaseId;
    private String productId;
    private int quantity;



    public String getProductId(){
        return productId;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public PurchaseProduct(int purchaseId, String productId, int quantity){
        this.purchaseId = purchaseId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getPurchaseId(){
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId){
        this.purchaseId = purchaseId;
    }

    public PurchaseProduct(){
    }

    public String toString(){
        return "PurchaseProduct{" + "purchaseId=" + purchaseId + ", productId=" + productId + ", quantity=" + quantity + '}';
    }

}
