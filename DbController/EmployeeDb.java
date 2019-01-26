package DbController;

import java.sql.*;
import java.util.*;
import model.Employee;

public class EmployeeDb{

    Connection getConnection() throws SQLException{

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/D3","root","");
            return connection;
        }

       public  boolean insertEmployee(Employee employee) throws SQLException{   //insert employee

            Connection conn=getConnection();
            Statement statement=conn.createStatement();

            String query=String.format("insert into employee values('%s','%s','%s','%s','%f')",employee.getUserId(),employee.getEmployeeName(),employee.getPhoneNumber(),employee.getRole(),employee.getSalary());

            if(statement.executeUpdate(query)==1){
                return true;
            }else{
                return false;
            }
        }

       public Object[][] getAllEmployee() throws SQLException{                  //2d array to gel all employee list in table
            List<Employee> employeeList=new ArrayList();

            Object employeeArray[][]=new Object[1000][1000];

            Connection conn=getConnection();
            Statement statement=conn.createStatement();
            String query="select  *  from employee";
            ResultSet rs=statement.executeQuery(query);

            int j=0;
            while(rs.next()){
                Employee employee=new Employee(rs.getString("user_id"),rs.getString("employee_name"),rs.getString("phone_number"),rs.getString("role"),rs.getDouble("salary"));
                employeeList.add(employee);

                employeeArray[j][0]=employee.getUserId();
                employeeArray[j][1]=employee.getEmployeeName();
                employeeArray[j][2]=employee.getPhoneNumber();
                employeeArray[j][3]=employee.getRole();
                employeeArray[j][4]=employee.getSalary();

                j++;
            }

            return employeeArray;
        }

        public Employee getEmployee(String id) throws SQLException{             //search employee
             Connection conn=getConnection();
            Statement statement=conn.createStatement();
            String query="select  *  from employee where user_id='"+id+"'";
            ResultSet rs=statement.executeQuery(query);

            if(rs.next()){
                Employee employee=new Employee(rs.getString("user_id"),rs.getString("employee_name"),rs.getString("phone_number"),rs.getString("role"),rs.getDouble("salary"));
                return employee;
            }else{
                return null;
            }

        }

       public  List<Employee> getAllEmployeeByName(String name) throws SQLException{  //search employee by name
            List<Employee> employeeList=new ArrayList();

            Connection conn=getConnection();
            Statement statement=conn.createStatement();
            String query="select  *  from employee where employee_name='"+name+"'";
            ResultSet rs=statement.executeQuery(query);

            while(rs.next()){
                Employee employee=new Employee(rs.getString("user_id"),rs.getString("employee_name"),rs.getString("phone_number"),rs.getString("role"),rs.getDouble("salary"));
                employeeList.add(employee);
            }

            return employeeList;
        }

        public boolean updateEmployee(Employee employee) throws SQLException{   //update employee info

            Connection conn=getConnection();
         Statement statement=conn.createStatement();
           String query=String.format("update employee set employee_name='%s',phone_number='%s',role='%s' ,salary='%f' where user_id='%s'",employee.getEmployeeName(),employee.getPhoneNumber(),employee.getRole(),employee.getSalary(),employee.getUserId());
           statement.executeUpdate(query);
           if(statement.executeUpdate(query)==1){
                return true;
            }else{
                return false;
            }
        }
        public boolean deleteEmployee(String id) throws SQLException{           //delete only employee
         Connection conn=getConnection();
         Statement statement=conn.createStatement();
         String query="delete from employee where user_id='"+id+"'";
         statement.executeUpdate(query);
         if(statement.executeUpdate(query)==1){
                return true;
            }else{
                return false;
            }
        }

}
