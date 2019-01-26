package gui;

import java.awt.*;
import javax.swing.*;

public class ManagerInfo extends JFrame{

    public ManagerInfo(){

        super("Info");
        this.setSize(400,300);
        Dimension dim  = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#AEB6BF"));

        JLabel label = new JLabel("<html>Name: "+ManagerPage.employee.getEmployeeName()
                                                    +"<br/>Phone: "+ManagerPage.employee.getPhoneNumber()
                                                       +"<br/>Role: "+ManagerPage.employee.getRole()
                                                        +"<br/>Salary: "+ManagerPage.employee.getSalary()
                                                           +"</html>",SwingConstants.CENTER);
        label.setBounds(50,0, 300,290);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(label);


        this.add(panel);
    }

}
