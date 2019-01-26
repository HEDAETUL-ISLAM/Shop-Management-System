package DbController;

import java.sql.*;
import java.util.*;
import model.Customer;

public class CustomerDb{

    Connection getConnection() throws SQLException{

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/D3","root","");
            return connection;
        }

        public boolean insertCustomer(Customer customer) throws SQLException{   //insert new customer by creationg new account

            Connection conn=getConnection();
            Statement statement=conn.createStatement();

            String query=String.format("insert into customer values('%s','%s','%s','%s')",customer.getUserId(),customer.getCustomerName(),customer.getPhoneNumber(),customer.getAddress());

            if(statement.executeUpdate(query)==1){
                return true;
            }else{
                return false;
            }


        }

        public Object[][] getAllCustomer() throws SQLException{                 //2d array to get multiple value return
            List<Customer> customerList=new ArrayList();

            Object customerArray[][]=new Object[1000][1000];

            Connection conn=getConnection();
            Statement statement=conn.createStatement();
            String query="select  *  from customer";
            ResultSet rs=statement.executeQuery(query);


            int j=0;
            while(rs.next()){
                Customer customer=new Customer(rs.getString("user_id"),rs.getString("customer_name"),rs.getString("phone_number"),rs.getString("address"));
                customerList.add(customer);

                    customerArray[j][0]=customer.getUserId();
                    customerArray[j][1]=customer.getCustomerName();
                    customerArray[j][2]=customer.getAddress();
                    customerArray[j][3]=customer.getPhoneNumber();

                    j++;
            }

            return customerArray;
        }

        public Customer getCustomer(String id) throws SQLException{             //search customer
             Connection conn=getConnection();
            Statement statement=conn.createStatement();
            String query="select  *  from customer where user_id='"+id+"'";
            ResultSet rs=statement.executeQuery(query);

            if(rs.next()){
                Customer customer=new Customer(rs.getString("user_id"),rs.getString("customer_name"),rs.getString("phone_number"),rs.getString("address"));
                return customer;
            }else{
                return null;
            }

        }

        List<Customer> getAllCustomersByName(String name) throws SQLException{  //search cuatomer by name
            List<Customer> customerList=new ArrayList();

            Connection conn=getConnection();
            Statement statement=conn.createStatement();
            String query="select  *  from customer where customer_name='"+name+"'";
            ResultSet rs=statement.executeQuery(query);

            while(rs.next()){
                Customer customer=new Customer(rs.getString("user_id"),rs.getString("customer_name"),rs.getString("phoneNumber"),rs.getString("address"));
                customerList.add(customer);
            }

            return customerList;
        }

        public boolean updateCustomer (Customer customer) throws SQLException{  //update customer

         Connection conn=getConnection();
         Statement statement=conn.createStatement();


           String query=String.format("update customer set customer_name='%s',phone_number='%s',address='%s' where user_id='%s'",customer.getCustomerName(),customer.getPhoneNumber(),customer.getAddress(),customer.getUserId());
           statement.executeUpdate(query);
           if(statement.executeUpdate(query)==1){
                return true;
            }else{
                return false;
            }
        }

        public boolean deleteCustomer(String id) throws SQLException{           //delete customer 
         Connection conn=getConnection();
         Statement statement=conn.createStatement();
         String query="delete from customer where user_id='"+id+"'";
         statement.executeUpdate(query);

         if(statement.executeUpdate(query)==1){
                return true;
            }else{
                return false;
            }
     }


}
