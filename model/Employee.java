package model;

public class Employee{

    private String userId;
    private String employeeName;
    private String phoneNumber;
    private String role;
    private Double salary;

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getEmployeeName(){
        return employeeName;
    }

    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }

    public Double getSalary(){
        return salary;
    }

    public void setSalary(Double salary){
        this.salary = salary;
    }

    public Employee(String userId, String employeeName, String phoneNumber, String role, Double salary){
        this.userId = userId;
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.salary = salary;
    }

    public Employee(){
    }

    public String toString(){
        return "Employee{" + "userId=" + userId + ", employeeName=" + employeeName + ", phoneNumber=" + phoneNumber + ", role=" + role + ", salary=" + salary + '}';
    }

}
