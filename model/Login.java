package model;

public class Login{
    private String userId;
    private String password;
    private int status;

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public int getStatus(){
        return status;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public Login(String userId, String password, int status){
        this.userId = userId;
        this.password = password;
        this.status = status;
    }

    public Login(){
    }

    public String toString(){
        return "Login{" + "userId=" + userId + ", password=" + password + ", status=" + status + '}';
    }

}
