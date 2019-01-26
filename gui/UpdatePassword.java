package gui;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import model.Login;
import DbController.LoginDb;

public class UpdatePassword extends JFrame{

    private JLabel userlabel, newPassword;
    private JPasswordField newPasswordfild;
    private JTextField userId;

    public UpdatePassword(){

        super("Update Password");
        this.setSize(500,300);
        Dimension dim  = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);

        userlabel = new JLabel("User Id");
        userlabel.setBounds(80, 25,300, 30);
        userlabel.setBackground(Color.BLACK);
        userlabel.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(userlabel);

        userId = new JTextField();
        userId.setBounds(80,55,340, 30);
        userId.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(userId);

        newPassword = new JLabel("Enter Your New Password");
        newPassword.setBounds(80, 95,350, 30);
        newPassword.setBackground(Color.BLACK);
        newPassword.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(newPassword);

        newPasswordfild = new JPasswordField();
        newPasswordfild.setBounds(80,125,340, 30);
        panel.add(newPasswordfild);

        JButton updatePasswordButton= new JButton("CONFIRM");
        updatePasswordButton.setBackground(Color.decode("#566573"));
        updatePasswordButton.setForeground(Color.white);
        updatePasswordButton.setBounds(170,200,150,30);
        updatePasswordButton.setFont(new Font("Arial", Font.BOLD, 15));
        updatePasswordButton.setBorderPainted(false);
        updatePasswordButton.setFocusable(false);
        updatePasswordButton.addActionListener(e->updatePassword());
        panel.add(updatePasswordButton);

        this.add(panel);
    }

    private void updatePassword(){                                              //update passwoord for all

        Login login=new Login(userId.getText() , newPasswordfild.getText(), 1);
        LoginDb loginDb = new LoginDb();

                if(userId.getText().length() == 0 || newPasswordfild.getPassword().length ==0){

                    JOptionPane.showMessageDialog(null, "Please insert");
                }
                else{
                        try{
                                boolean success = loginDb.updatePassword(login.getUserId(),newPasswordfild.getText());
                                if(success){
                                  JOptionPane.showMessageDialog(null, "Successful.. now login");
                                  userId.setText("");
                                  newPasswordfild.setText("");
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
