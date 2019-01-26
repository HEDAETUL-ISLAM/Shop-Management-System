package gui;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import model.Employee;
import DbController.EmployeeDb;

public class UpdateInfoOnlyEmployee extends JFrame{

    private JLabel userlabel,name,phone;
    private JTextField userId,nameField,phonefield;
    private JButton updateCustInfo;

    public UpdateInfoOnlyEmployee(){

        super("Update Only Employee");
        this.setSize(500,340);
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

        phone = new JLabel("Phone No.");
        phone.setBounds(80, 155,300, 30);
        phone.setBackground(Color.BLACK);
        phone.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(phone);

        phonefield = new JTextField();
        phonefield.setBounds(80,185,340, 30);
        phonefield.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(phonefield);

         updateCustInfo= new JButton("CONFIRM");
        updateCustInfo.setBackground(Color.decode("#566573"));
        updateCustInfo.setForeground(Color.white);
        updateCustInfo.setBounds(170,240,150,30);
        updateCustInfo.setFont(new Font("Arial", Font.BOLD, 15));
        updateCustInfo.setBorderPainted(false);
        updateCustInfo.setFocusable(false);
        updateCustInfo.addActionListener(e->updateEmpAll());
        panel.add(updateCustInfo);

        this.add(panel);
    }

    private void updateEmpAll(){                                                //update info only for employee

        if(userId.getText().length()==0||nameField.getText().length()==0||phonefield.getText().length()==0){

            JOptionPane.showMessageDialog(null, "Please insert");
        }
        else{

            Employee employee = new Employee(userId.getText(),nameField.getText(),phonefield.getText(),EmployeePage.employee.getRole(),EmployeePage.employee.getSalary());
            EmployeeDb employeeDb = new EmployeeDb();

            try{
                boolean success = employeeDb.updateEmployee(employee);
                if(success){
                  JOptionPane.showMessageDialog(null, "Successfully update your account");
                  userId.setText("");
                  nameField.setText("");
                  phonefield.setText("");
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
