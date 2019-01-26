package DbController;

import java.sql.*;
import java.util.*;
import model.Product;
import model.PurchaseInfo;
import model.PurchaseProduct;

public class PurchaseInfoDb{
         Connection getConnection() throws SQLException{

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/D3","root","");
            return connection;
        }

                                        //insert purchesed product from buy table from customer page
        public  boolean insertPurchase(PurchaseInfo purchaseInfo,List<PurchaseProduct> purchaseProductList) throws SQLException{

            Connection conn=getConnection();
            Statement statement=conn.createStatement();


                double totalPrice=0;
                PurchaseProductDb purchaseProductDb=new PurchaseProductDb();
                for(PurchaseProduct purchaseProduct:purchaseProductList){
                    purchaseProductDb.insertPurchaseProduct(purchaseProduct);   //update PurchaseProductDb

                    Product product=new Product();
                    ProductDb productDb=new ProductDb();
                    product=productDb.getProduct(purchaseProduct.getProductId());

                    if(product.getAvailableQuantity()>0){
                      product.setAvailableQuantity(product.getAvailableQuantity()-purchaseProduct.getQuantity());
                    }
                    else{
                      product.setAvailableQuantity(0);
                    }
                      productDb.updateProduct(product);


                    //count total price
                    totalPrice+=(product.getPrice() * purchaseProduct.getQuantity());
                }

                purchaseInfo.setAmount(totalPrice);

                    String query=String.format("insert into purchase_info (amount,purchase_date,user_id) values (%f,'%s','%s')",   purchaseInfo.getAmount(),purchaseInfo.getPurchaseDate(),purchaseInfo.getUserId());


                    if(statement.executeUpdate(query) >0){
                        return true;
                    }else{
                        return false;
                    }

         }
         public int  GetLastRow() throws SQLException{                          //get last row for count new line

             Connection conn=getConnection();
            Statement statement=conn.createStatement();

            String query = "select * from  purchase_info ORDER BY purchase_id DESC LIMIT 1";
            ResultSet rs = statement.executeQuery(query);

            if(rs.next()){

                return rs.getInt("purchase_id");
            }
             return -1;
         }

         }
