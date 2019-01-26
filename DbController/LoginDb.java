package DbController;

import java.sql.*;
import model.Login;

public class LoginDb{
        Connection getConnection() throws SQLException{

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/D3","root","");
            return connection;
        }

    public int loginAction(Login login) throws SQLException{                    //login to app


                Connection connection = getConnection();
                String query = "select * FROM login WHERE user_id = '"+login.getUserId()+"' AND password = '"+login.getPassword()+"'";

                Statement statement =connection.createStatement();
                ResultSet rs=statement.executeQuery(query);

                if(rs.next()){


                    return rs.getInt("status");
                }else{

                    return -1;
                }
    }
    public boolean updatePassword (String id, String newPass) throws SQLException{  //update password for anyone

         Connection conn=getConnection();
         Statement statement=conn.createStatement();

         String query = String.format("update login set password='%s' where user_id='%s'",newPass,id);
         statement.executeUpdate(query);

           if(statement.executeUpdate(query)==1){
                return true;
            }
           else{
                return false;
            }
        }

    public boolean loginActionfd(Login login) throws SQLException{              //not useer in this project

        Connection conn=getConnection();
        Statement statement=conn.createStatement();

         String query = String.format("select * from login where user_id='%s' and password='%s'",login.getUserId(),login.getPassword());
         statement.executeQuery(query);

           if(statement.executeUpdate(query)==1){
                return true;
           }else{
               return false;
           }

    }
    public boolean deleteId(String id) throws SQLException{                     //id delete 
         Connection conn=getConnection();
         Statement statement=conn.createStatement();
         String query="delete from login where user_id='"+id+"'";
         statement.executeUpdate(query);

         if(statement.executeUpdate(query)==1){
                return true;
            }else{
                return false;
            }
    }
}
