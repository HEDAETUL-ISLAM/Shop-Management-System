package DbController;

import java.sql.*;
import model.Login;

public class CreateAccountDb{

     Connection getConnection() throws SQLException{

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/D3","root","");
            return connection;
        }

    public void createAccountDB(Login login) throws SQLException{               //create new account and move it to login table


                Connection connection = getConnection();

                String query = "insert into login (user_id, password,status) Values ('"+login.getUserId()+"','"+login.getPassword()+"','"+login.getStatus()+ "')";

                Statement statement =connection.createStatement();
                statement.executeUpdate(query);

        }

}
