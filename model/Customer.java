package model;

public class Customer{

    private String userId;
    private String customerName;
    private String phoneNumber;
    private String address;

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public Customer(String userId, String customerName, String phoneNumber, String address){
        this.userId = userId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Customer(){
    }

    public String toString(){
        return "Customer{" + "userId=" + userId + ", customerName=" + customerName + ", phoneNumber=" + phoneNumber + ", address=" + address + '}';
    }
}
