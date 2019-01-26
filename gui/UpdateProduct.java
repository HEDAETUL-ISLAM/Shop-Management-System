package gui;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import model.Product;
import DbController.ProductDb;

public class UpdateProduct extends JFrame{

    private JLabel userlabel,name,price,quantity;
    private JTextField userId, nameField,priceField, quantityField;
    public UpdateProduct(){

        super("Update Product");
        this.setSize(500,400);
        Dimension dim  = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);

        userlabel = new JLabel("Insert Selected Product Id");
        userlabel.setBounds(80, 25,300, 30);
        userlabel.setBackground(Color.BLACK);
        userlabel.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(userlabel);

        userId = new JTextField();
        userId.setBounds(80,55,340, 30);
        userId.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(userId);

        name = new JLabel("Product Name");
        name.setBounds(80, 90,300, 30);
        name.setBackground(Color.BLACK);
        name.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(name);

        nameField = new JTextField();
        nameField.setBounds(80,120,340, 30);
        nameField.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(nameField);

        price = new JLabel("Price");
        price.setBounds(80, 155,300, 30);
        price.setBackground(Color.BLACK);
        price.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(price);

        priceField = new JTextField();
        priceField.setBounds(80,185,340, 30);
        priceField.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(priceField);

        quantity = new JLabel("Quantity");
        quantity.setBounds(80, 220,300, 30);
        quantity.setBackground(Color.BLACK);
        quantity.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(quantity);

        quantityField = new JTextField();
        quantityField.setBounds(80,250,340, 30);
        quantityField.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(quantityField);




        JButton updatePasswordButton= new JButton("CONFIRM");
        updatePasswordButton.setBackground(Color.decode("#566573"));
        updatePasswordButton.setForeground(Color.white);
        updatePasswordButton.setBounds(170,330,150,30);
        updatePasswordButton.setFont(new Font("Arial", Font.BOLD, 15));
        updatePasswordButton.setBorderPainted(false);
        updatePasswordButton.setFocusable(false);
        updatePasswordButton.addActionListener(e->{
            try{
                updateProduct();
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
        });
        panel.add(updatePasswordButton);

        this.add(panel);
    }

    private void updateProduct() throws SQLException{

        if(userId.getText().length()==0||nameField.getText().length()==0||priceField.getText().length()==0||quantityField.getText().length()==0){

            JOptionPane.showMessageDialog(null, "Please insert");
        }

        else{

            Product product = new Product(userId.getText(),nameField.getText(),Double.parseDouble(priceField.getText()),Integer.parseInt(quantityField.getText()));
            ProductDb productDb = new ProductDb();
            try{
                boolean success = productDb.updateProduct(product);
                 if(success){
                    JOptionPane.showMessageDialog(null, "Successfully update your product");
                    userId.setText("");
                    nameField.setText("");
                    priceField.setText("");
                    quantityField.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(null, "faild");
                }
            }
            catch(SQLException ex){
                  System.out.println(ex);
             }
        }

    }

}
