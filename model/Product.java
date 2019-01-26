package model;

public class Product{

    private String productId;
    private String productName;
    private Double price;
    private int availableQuantity;

    public String getProductId(){
        return productId;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public int getAvailableQuantity(){
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity){
        this.availableQuantity = availableQuantity;
    }

    public Product(String productId, String productName, Double price, int availableQuantity){
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }

    public Product(){
    }

    public String toString(){
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", price=" + price + ", availableQuantity=" + availableQuantity + '}';
    }

}
