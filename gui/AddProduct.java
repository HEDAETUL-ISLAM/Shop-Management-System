package gui;

import DbController.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import static java.lang.Double.*;
import static java.lang.Integer.*;
import model.Product;

public class AddProduct extends JFrame{

    private JLabel userlabel,name,price,quantity;
    private JButton  addProInfo;
    private JTextField userId, nameField,priceField, quantityField;

    public AddProduct(){

        super("Add Product");
        this.setSize(500,400);
        Dimension dim  = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);

        userlabel = new JLabel("Product Id");
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

         addProInfo= new JButton("CONFIRM");
         addProInfo.setBackground(Color.decode("#566573"));
         addProInfo.setForeground(Color.white);
         addProInfo.setBounds(170,330,150,30);
         addProInfo.setFont(new Font("Arial", Font.BOLD, 15));
         addProInfo.setBorderPainted(false);
         addProInfo.setFocusable(false);
         addProInfo.addActionListener(e->addPro());
        panel.add( addProInfo);

        this.add(panel);
    }

    public  void addPro(){                                                      //add product in db

        ProductDb productDb = new ProductDb();

        if(userId.getText().length()==0 || nameField.getText().length()==0||priceField.getText().length()==0||quantityField.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Please Insert");
        }
        else{
            try{
                Product product = new Product(userId.getText(),nameField.getText(),parseDouble(priceField.getText()),parseInt(quantityField.getText()));
                productDb.insertProduct(product);
                 JOptionPane.showMessageDialog(null, "Successfully.. added product");
                                userId.setText("");
                                nameField.setText("");
                                priceField.setText("");
                                quantityField.setText("");
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Already exist.");
                                userId.setText("");
                                nameField.setText("");
                                priceField.setText("");
                                quantityField.setText("");
            }
        }
    }
}
