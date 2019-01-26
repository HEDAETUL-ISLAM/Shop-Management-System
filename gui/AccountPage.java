package gui;

import DbController.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import model.Customer;
import model.Login;

public class AccountPage extends JFrame{

    JPanel panel,panel2;
    JTextField loginUserName1 ,registerUserName2,addressField,phoneField,nameField;
    JPasswordField loginPasswordField1 , registerPasswordField2;

    public AccountPage(){

        super("Account Page");
        this.setSize(1080,720);
        Dimension dim  = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#D5D8DC"));

        JLabel label1 = new JLabel("Login");
        label1.setBounds(100, 150,100, 30);
        label1.setBackground(Color.BLACK);
        label1.setFont(new Font("Arial", Font.ROMAN_BASELINE, 25));
        panel.add(label1);

        JLabel label4 = new JLabel("Register");
        label4.setBounds(590, 150,180, 30);
        label4.setBackground(Color.BLACK);
        label4.setFont(new Font("Arial", Font.ROMAN_BASELINE, 25));
        panel.add(label4);

        JLabel label2 = new JLabel("User Id");
        label2.setBounds(100, 190,100, 30);
        label2.setBackground(Color.BLACK);
        label2.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(label2);

        JLabel label5 = new JLabel("User Id");
        label5.setBounds(590, 190,300, 30);
        label5.setBackground(Color.BLACK);
        label5.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(label5);

        loginUserName1 = new JTextField();
        loginUserName1.setBounds(100,220,390, 30);
        loginUserName1.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(loginUserName1);

        registerUserName2 = new JTextField();
        registerUserName2.setBounds(590,220,390, 30);
        registerUserName2.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(registerUserName2);

        JLabel label3 = new JLabel("Password");
        label3.setBounds(100, 260,100, 30);
        label3.setBackground(Color.BLACK);
        label3.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(label3);

        JLabel label6 = new JLabel("Password");
        label6.setBounds(590, 260,100, 30);
        label6.setBackground(Color.BLACK);
        label6.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(label6);

        JLabel label7 =  new JLabel("Full Name");
        label7.setBounds(590, 325,100, 30);
        label7.setBackground(Color.BLACK);
        label7.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(label7);

        JLabel label8 =  new JLabel("Phone");
        label8.setBounds(590, 395,100, 30);
        label8.setBackground(Color.BLACK);
        label8.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(label8);

        JLabel label9 =  new JLabel("Address");
        label9.setBounds(590, 465,100, 30);
        label9.setBackground(Color.BLACK);
        label9.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(label9);


        loginPasswordField1 = new JPasswordField();
        loginPasswordField1.setBounds(100,290,390, 30);
        panel.add(loginPasswordField1);

        registerPasswordField2 = new JPasswordField();
        registerPasswordField2.setBounds(590,290,390, 30);
        panel.add(registerPasswordField2);

        addressField = new JTextField();
        addressField.setBounds(590,355,390, 30);
        addressField.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(addressField);

        phoneField = new JTextField();
        phoneField.setBounds(590,425,390, 30);
        phoneField.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(phoneField);

        nameField = new JTextField();
        nameField.setBounds(590,495,390, 30);
        nameField.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(nameField);

        JButton loginButton = new JButton("LOG IN");
        loginButton.setBounds(100,330,100, 35);
        loginButton.setBackground(Color.decode("#566573"));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 15));
        loginButton.setBorderPainted(false);
        loginButton.setFocusable(false);
        loginButton.addActionListener(e->{
            try{
                try{
                    log();
                }
                catch(IOException ex){
                    System.out.println(ex);
                }
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
        });
        panel.add(loginButton);

        JButton registerButton = new JButton("REGISTER");
        registerButton.setBounds(590,535,130, 35);
        registerButton.setBackground(Color.decode("#566573"));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Arial", Font.BOLD, 15));
        registerButton.setBorderPainted(false);
        registerButton.setFocusable(false);
        registerButton.addActionListener(e->registerAccount());
        panel.add(registerButton);

        JButton updatePasswordButton= new JButton("Lost your password?");
        updatePasswordButton.setBackground(Color.decode("#D5D8DC"));
        updatePasswordButton.setForeground(Color.black);
        updatePasswordButton.setBounds(20,375,350,30);
        updatePasswordButton.setFont(new Font("Arial", Font.BOLD, 15));
        updatePasswordButton.setBorderPainted(false);
        updatePasswordButton.setFocusable(false);
        updatePasswordButton.setContentAreaFilled(false);
        updatePasswordButton.addActionListener(e->updatePassword());
        panel.add(updatePasswordButton);

        this.add(panel);
    }

    private void updatePassword(){                                              //for update password
        UpdatePassword updatePass = new UpdatePassword();
        updatePass.setVisible(true);
    }

    public void registerAccount(){                                              //create new account

         Login login=new Login(registerUserName2.getText() , registerPasswordField2.getText(), 1);
         Customer customer = new Customer(registerUserName2.getText(),addressField.getText(),nameField.getText(),phoneField.getText());

                CreateAccountDb  createAccount=new CreateAccountDb();
                CustomerDb addCustomer  = new CustomerDb();

                if(registerUserName2.getText().length() == 0 || registerPasswordField2.getPassword().length ==0){

                    JOptionPane.showMessageDialog(null, "Please insert");
                }
                else{
                        try{
                                createAccount.createAccountDB(login);
                                addCustomer.insertCustomer(customer);
                                JOptionPane.showMessageDialog(null, "Successful.. now login");
                                registerUserName2.setText("");
                                registerPasswordField2.setText("");
                                addressField.setText("");
                                phoneField.setText("");
                                nameField.setText("");
                        }
                        catch(SQLException ex){
                                JOptionPane.showMessageDialog(null, "Already exist.");
                                registerUserName2.setText("");
                                registerPasswordField2.setText("");
                                addressField.setText("");
                                phoneField.setText("");
                                nameField.setText("");
                        }
                }
    }

    public static String customerId;
    public static String managerId;
    public static String employeeId;
    public void log() throws SQLException, IOException{                         //login account

        LoginDb loginDb = new LoginDb();

        if(loginUserName1.getText().length() == 0 || loginPasswordField1.getPassword().length ==0){
             JOptionPane.showMessageDialog(null, "Please insert");
         }
        else{

            CustomerPage customerPage = new CustomerPage();
                      ManagerPage managerPage = new ManagerPage();
                              EmployeePage employeePage = new EmployeePage();
            Login login = new Login(loginUserName1.getText(),loginPasswordField1.getText(),9);

            if(loginDb.loginAction(login)>-1){

                 if(loginDb.loginAction(login) ==1){
                     customerId = loginUserName1.getText();
                     customerPage.setVisible(true);
                     this.setVisible(false);
                     loginUserName1.setText("");
                     loginPasswordField1.setText("");
                 }
                 else if(loginDb.loginAction(login) ==2){
                     managerId = loginUserName1.getText();
                     managerPage.setVisible(true);
                     this.setVisible(false);
                     loginUserName1.setText("");
                     loginPasswordField1.setText("");
                 }
                 else if(loginDb.loginAction(login)==0){
                     employeeId= loginUserName1.getText();
                     employeePage.setVisible(true);
                     this.setVisible(false);
                     loginUserName1.setText("");
                     loginPasswordField1.setText("");
                 }
            }
            else{
                 JOptionPane.showMessageDialog(null, "Failed...Try Again");
                 loginUserName1.setText("");
                 loginPasswordField1.setText("");
            }
        }
    }
}
