
package gui;

import java.awt.*;
import javax.swing.*;

public class ShowInvoice  extends JFrame{

    private String header[] ={"Pro. Code","Quantity","Unit Price", "Total Price"};
    private JScrollPane scrollPane ;
    private String data[][]=CustomerPage.buydata;
    private JLabel price;
    private JButton print,cancel;


        public ShowInvoice(){

            super("Purchase Info");
            this.setSize(600,720);
            Dimension dim  = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setResizable(false);

            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setBackground(Color.white);

            JLabel voucher = new JLabel("Voucher");
            voucher.setBounds(250, 10, 100, 25);
            voucher.setFont(new Font("Arial", Font.BOLD, 20));
            voucher.setForeground(Color.decode("#5D6D7E"));
            panel.add(voucher);

            JLabel from =  new JLabel("From:");
            from.setBounds(50, 50, 100, 25);
            from.setFont(new Font("Arial", Font.BOLD, 15));
            from.setForeground(Color.decode("#5D6D7E"));
            panel.add(from);

             JLabel from2 = new JLabel("<html>BIG SHOP<br/>Location: Dhaka<br/>Contact: 017********<br/>");
             from2.setBounds(50, 15, 300, 160);
            from2.setFont(new Font("Arial", Font.PLAIN, 15));
            from2.setForeground(Color.decode("#5D6D7E"));
            panel.add(from2);

            JLabel to =  new JLabel("To:");
            to.setBounds(300, 50, 100, 25);
            to.setFont(new Font("Arial", Font.BOLD, 15));
            to.setForeground(Color.decode("#5D6D7E"));
            panel.add(to);

            JLabel to2 = new JLabel("<html>Name: "+CustomerPage.customer.getCustomerName()
                                                    +"<br/>Address: "+CustomerPage.customer.getAddress()
                                                       +"<br/>Phone No: "+CustomerPage.customer.getPhoneNumber()
                                                           +"</html>");
            to2.setBounds(300, 15, 300, 160);
            to2.setFont(new Font("Arial", Font.PLAIN, 15));
            to2.setForeground(Color.decode("#5D6D7E"));
            panel.add(to2);

            price = new JLabel("ToTal Price: "+CustomerPage.totalprice);
            price.setBounds(330, 570, 300, 50);
            price.setFont(new Font("Arial", Font.PLAIN, 15));
            panel.add(price);


            JTable table = new JTable(data,header);
            table.setRowHeight(20);
            table.setEnabled(false);
            table.setBackground(Color.decode("#CCD1D1"));
            table.setFont(new Font("Arial", Font.PLAIN, 15));
            scrollPane = new JScrollPane(table);
            scrollPane.setBounds(50, 170,  500, 400);
             getContentPane().add(scrollPane);

             JLabel dot = new JLabel("-------------------------------------------");
            dot.setBounds(100, 615, 450, 10);
            dot.setFont(new Font("Arial", Font.ROMAN_BASELINE, 25));
            dot.setForeground(Color.decode("#5B2C6F"));
            panel.add(dot);

             JLabel thank = new JLabel("Thank you for shopping");
             thank.setBounds(145, 630, 400, 30);
             thank.setFont(new Font("Arial", Font.PLAIN, 25));
             thank.setForeground(Color.decode("#5D6D7E"));
             panel.add(thank);

             print = new JButton("Print");
             print.setBackground(Color.lightGray);
             print.setBounds(200, 670, 80, 20);
             print.setForeground(Color.BLACK);
             print.setFont(new Font("Arial", Font.PLAIN, 15));
             print.setBorderPainted(false);
             print.setFocusable(false);
             print.addActionListener(e->successfull());
             panel.add(print);

             cancel = new JButton("cancel");
             cancel.setBackground(Color.lightGray);
             cancel.setBounds(300, 670, 80, 20);
             cancel.setForeground(Color.BLACK);
             cancel.setFont(new Font("Arial", Font.PLAIN, 15));
             cancel.setBorderPainted(false);
             cancel.setFocusable(false);
             cancel.addActionListener(e->unsuccessfull());
             panel.add(cancel);

            this.add(panel);

    }

    private void successfull(){
        JOptionPane.showMessageDialog(null,"Order successfully done");
        this.setVisible(false);
    }

    private void unsuccessfull(){
        JOptionPane.showMessageDialog(null,"Order canceld");
        this.setVisible(false);
    }

}
