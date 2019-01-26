package gui;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import model.Customer;
import DbController.CustomerDb;

public class UpdateInfoCustomer extends JFrame{

    JLabel userlabel,name,address,phone;
    JTextField userId,nameField,addressField,phonefield;
    JButton updateCustInfo;

    public UpdateInfoCustomer(){

        super("Update Customer");
        this.setSize(500,400);
        Dimension dim  = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);

        userlabel = new JLabel("Insert current user Id");
        userlabel.setBounds(80, 25,300, 30);
        userlabel.setBackground(Color.BLACK);
        userlabel.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(userlabel);

        userId = new JTextField();
        userId.setBounds(80,55,340, 30);
        userId.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(userId);

        name = new JLabel("Name");
        name.setBounds(80, 90,300, 30);
        name.setBackground(Color.BLACK);
        name.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(name);

        nameField = new JTextField();
        nameField.setBounds(80,120,340, 30);
        nameField.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(nameField);

        address = new JLabel("Address");
        address.setBounds(80, 155,300, 30);
        address.setBackground(Color.BLACK);
        address.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(address);

        addressField = new JTextField();
        addressField.setBounds(80,185,340, 30);
        addressField.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(addressField);

        phone = new JLabel("Phone No.");
        phone.setBounds(80, 230,300, 30);
        phone.setBackground(Color.BLACK);
        phone.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(phone);

        phonefield = new JTextField();
        phonefield.setBounds(80,260,340, 30);
        phonefield.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(phonefield);

        updateCustInfo= new JButton("CONFIRM");
        updateCustInfo.setBackground(Color.decode("#566573"));
        updateCustInfo.setForeground(Color.white);
        updateCustInfo.setBounds(170,320,150,30);
        updateCustInfo.setFont(new Font("Arial", Font.BOLD, 15));
        updateCustInfo.setBorderPainted(false);
        updateCustInfo.setFocusable(false);
        updateCustInfo.addActionListener(e->updateCusAll());
        panel.add(updateCustInfo);

        this.add(panel);
    }

    private void updateCusAll(){                                                //update customer info

        Customer customer = new Customer(userId.getText(),nameField.getText(),phonefield.getText(),addressField.getText());
        CustomerDb customerDb = new CustomerDb();

                if(userId.getText().length() == 0 || nameField.getText().length() ==0 || addressField.getText().length()==0 ||phonefield.getText().length()==0){

                    JOptionPane.showMessageDialog(null, "Please insert");
                }
                else{
                        try{
                                boolean success = customerDb.updateCustomer(customer);
                                if(success){
                                JOptionPane.showMessageDialog(null, "Successfully update your account");
                                userId.setText("");
                                nameField.setText("");
                                addressField.setText("");
                                phonefield.setText("");
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "faild");
                                }
                        }
                        catch(SQLException ex){
                            System.out.println(ex);
                        }
                        this.setVisible(false);
                }
    }

}
