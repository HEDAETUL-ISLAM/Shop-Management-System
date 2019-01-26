package gui;

import DbController.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import static java.lang.Double.parseDouble;
import model.Employee;
import model.Login;

public class AddEmployee extends JFrame{

    private JLabel userlabel,name,address,phone,password,role,salary;
    private JButton addEmpInfo;
    private JTextField userId, nameField,addressField, phoneField,roleField,salaryField;
    private JPasswordField passwordfield;

    public AddEmployee(){

        super("Add Emloyee");
        this.setSize(500,600);
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

        phone = new JLabel("Phone No");
        phone.setBounds(80, 220,300, 30);
        phone.setBackground(Color.BLACK);
        phone.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(phone);

        phoneField = new JTextField();
        phoneField.setBounds(80,250,340, 30);
        phoneField.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(phoneField);

        role = new JLabel("Role");
        role.setBounds(80, 285,300, 30);
        role.setBackground(Color.BLACK);
        role.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(role);

        roleField = new JTextField();
        roleField.setBounds(80,315,340, 30);
        roleField.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(roleField);

        salary = new JLabel("Salary");
        salary.setBounds(80, 350,300, 30);
        salary.setBackground(Color.BLACK);
        salary.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(salary);

        salaryField = new JTextField();
        salaryField.setBounds(80,380,340, 30);
        salaryField.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(salaryField);

        password =  new JLabel("Password");
        password.setBounds(80, 415,300, 30);
        password.setBackground(Color.BLACK);
        password.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(password);

        passwordfield = new JPasswordField();
        passwordfield.setBounds(80,450,340, 30);
        passwordfield.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(passwordfield);

        addEmpInfo= new JButton("CONFIRM");
        addEmpInfo.setBackground(Color.decode("#566573"));
        addEmpInfo.setForeground(Color.white);
        addEmpInfo.setBounds(170,520,150,30);
        addEmpInfo.setFont(new Font("Arial", Font.BOLD, 15));
        addEmpInfo.setBorderPainted(false);
        addEmpInfo.setFocusable(false);
        addEmpInfo.addActionListener(e->addEmpAll());
        panel.add(addEmpInfo);


        this.add(panel);
    }


    public  void addEmpAll(){                                                   //for manager option to add employee

                CreateAccountDb  createAccount=new CreateAccountDb();
                EmployeeDb employeeDb  = new EmployeeDb();

                if(userId.getText().length() == 0 || nameField.getText().length() ==0 || phoneField.getText().length() == 0 || roleField.getText().length()==0 || salaryField.getText().length()==0){

                    JOptionPane.showMessageDialog(null, "Please insert");
                }
                else{
                        try{
                                Login login=new Login(userId.getText() , passwordfield.getText(), 0);
                                Employee employee = new Employee(userId.getText(), nameField.getText(),phoneField.getText(),roleField.getText(),parseDouble(salaryField.getText()));

                                createAccount.createAccountDB(login);
                                employeeDb.insertEmployee(employee);
                                JOptionPane.showMessageDialog(null, "Successful.. added");
                                userId.setText("");
                                nameField.setText("");
                                phoneField.setText("");
                                addressField.setText("");
                                roleField.setText("");
                                salaryField.setText("");
                                passwordfield.setText("");
                        }
                        catch(SQLException ex){
                                JOptionPane.showMessageDialog(null, "Already exist.");
                                userId.setText("");
                                nameField.setText("");
                                phoneField.setText("");
                                addressField.setText("");
                                roleField.setText("");
                                salaryField.setText("");
                                passwordfield.setText("");
                        }
                }
    }

}
