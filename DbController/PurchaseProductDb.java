package DbController;

import java.sql.*;
import model.PurchaseProduct;
public class PurchaseProductDb{

    Connection getConnection() throws SQLException{

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/D3","root","");
            return connection;
        }
        //insert new purchae product to db PurchaseProductDb table
    public  boolean insertPurchaseProduct(PurchaseProduct purchaseProduct) throws SQLException{

            Connection conn=getConnection();
            Statement statement=conn.createStatement();

            String query=String.format("insert into purchase_product values(%d,'%s',%d)",purchaseProduct.getPurchaseId(),
                                                                                              purchaseProduct.getProductId(),purchaseProduct.getQuantity());

            if(statement.executeUpdate(query)==1){
                return true;
            }else{
                System.out.println("failed here");
                return false;
            }
        }
}
