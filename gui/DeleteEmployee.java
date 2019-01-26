package gui;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import DbController.EmployeeDb;
import DbController.LoginDb;

public class DeleteEmployee extends JFrame{

    private  JLabel userlabel;
    private JTextField userId;
    private JButton deletePro;
    public DeleteEmployee(){

        super("Remove Employee");
        this.setSize(500,200);
        Dimension dim  = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);

        userlabel = new JLabel("Enter employee Id");
        userlabel.setBounds(80, 25,300, 30);
        userlabel.setBackground(Color.BLACK);
        userlabel.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(userlabel);

        userId = new JTextField();
        userId.setBounds(80,55,340, 30);
        userId.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(userId);

        deletePro= new JButton("CONFIRM");
         deletePro.setBackground(Color.decode("#566573"));
         deletePro.setForeground(Color.white);
         deletePro.setBounds(170,130,150,30);
         deletePro.setFont(new Font("Arial", Font.BOLD, 15));
         deletePro.setBorderPainted(false);
         deletePro.setFocusable(false);
         deletePro.addActionListener(e->{
             try{
                 deleteEmployee();
             }
             catch(SQLException ex){
                 System.out.println(ex);
             }
        });
        panel.add( deletePro);

        this.add(panel);
    }

    private void deleteEmployee() throws SQLException{                          //remove employeee by manager
        EmployeeDb employeeDb = new EmployeeDb();
        LoginDb loginDb = new LoginDb();
        employeeDb.deleteEmployee(userId.getText());
        loginDb.deleteId(userId.getText());
        JOptionPane.showMessageDialog(null, "Employee Removed");
        this.dispose();
    }

}
