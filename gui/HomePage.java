package gui;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.sql.*;
import javax.imageio.*;
import javax.swing.*;
import model.Product;
import DbController.ProductDb;
import java.awt.event.*;

public class HomePage extends JFrame implements MouseListener,KeyListener{

     private JButton login,searchButton,fb;
     private JPanel panel,panel2;
     private JTextField searchField;
     private  JTable table;
     private ImageIcon img;
     private JScrollPane scrollPane;

     public HomePage() throws IOException, SQLException{

        super("Home Page");
        this.setSize(1080,720);
        Dimension dim  = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#D5D8DC"));


        ProductDb productDb=new ProductDb();
        Object data[][]=productDb.getAllProduct();
        String header[] ={ "Product Id", "Product Name", "Price","Quntity" };
        table = new JTable(data,header);
        table.setRowHeight(30);
        table.setEnabled(false);
        table.setBackground(Color.decode("#A2D9CE"));
        table.setFont(new Font("Arial", Font.PLAIN, 15));
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 160, 880, 450);
        getContentPane().add(scrollPane);

         JLabel welcome = new JLabel("Welcome To Big Shop");
         welcome.setBounds(415, 80, 600, 30);
         welcome.setFont(new Font("Arial", Font.ROMAN_BASELINE, 25));
         welcome.setForeground(Color.decode("#5B2C6F"));
         panel.add(welcome);

         JLabel dot = new JLabel("-------------------------------------------");
         dot.setBounds(350, 110, 600, 10);
         dot.setFont(new Font("Arial", Font.ROMAN_BASELINE, 25));
         dot.setForeground(Color.decode("#5B2C6F"));
         panel.add(dot);

         JLabel list = new JLabel("Product list");
         list.setBounds(100, 140, 200, 15);
         list.setFont(new Font("Arial", Font.PLAIN, 17));
         list.setForeground(Color.gray);
         panel.add(list);

         JLabel contact = new JLabel("Connect with  us..");
         contact.setBounds(750, 610, 200, 30);
         contact.setFont(new Font("Arial", Font.PLAIN, 15));
         contact.setForeground(Color.gray);
         panel.add(contact);

        BufferedImage buttonIconfb = ImageIO.read(new File("/home/hedaetul/Hedaetul/my programs/java/Shop Management System/icon/fb.png"));
        fb = new JButton(new ImageIcon(buttonIconfb));
        fb.setBounds(750, 640, 30, 30);
        fb.setBorderPainted(false);
        fb.setFocusPainted(false);
        fb.setContentAreaFilled(false);
        panel.add(fb);

        BufferedImage buttonIcontw = ImageIO.read(new File("/home/hedaetul/Hedaetul/my programs/java/Shop Management System/icon/twit.png"));
        fb = new JButton(new ImageIcon(buttonIcontw));
        fb.setBounds(790, 640, 30, 30);
        fb.setBorderPainted(false);
        fb.setFocusPainted(false);
        fb.setContentAreaFilled(false);
        panel.add(fb);

        BufferedImage buttonIconins = ImageIO.read(new File("/home/hedaetul/Hedaetul/my programs/java/Shop Management System/icon/ins.png"));
        fb = new JButton(new ImageIcon(buttonIconins));
        fb.setBounds(830, 640, 30, 30);
        fb.setBorderPainted(false);
        fb.setFocusPainted(false);
        fb.setContentAreaFilled(false);
        panel.add(fb);

        panel2=new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0,0, 1080, 60);
        panel2.setBackground(Color.decode("#138D75"));
        panel.add(panel2);

        img = new ImageIcon("/home/hedaetul/Hedaetul/my programs/java/Shop Management System/icon/Shop.png");
        JLabel shopIcon = new JLabel(img);
        shopIcon.setBounds(3,5,70, 55);
        panel2.add(shopIcon);

        JLabel name =  new JLabel("BIG SHOP");
        name.setBounds(70, 5,250, 55);
        name.setForeground(Color.decode("#D1F2EB"));
        name.setFont(new Font("Serif", Font.TYPE1_FONT, 30));
        panel2.add(name);


        login = new JButton("Login / Register");
        login.setBackground(Color.decode("#138D75"));
        login.setForeground(Color.WHITE);
        login.setBounds(850,15,200,30);
        login.setFont(new Font("Arial", Font.BOLD, 17));
        login.setBorderPainted(false);
        login.setFocusable(false);
        login.setContentAreaFilled(false);
        login.addActionListener(e->accountOpen());
        panel2.add(login);

        searchField = new JTextField("search product");
        searchField.setBounds(450,15, 150,30);
        searchField.setBackground(Color.white);
        searchField.setForeground(Color.black);
        searchField.setFont(new Font("Arial", Font.PLAIN, 15));
        searchField.addMouseListener(this);
        searchField.addKeyListener(this);
        panel2.add(searchField);

         BufferedImage buttonIcon = ImageIO.read(new File("/home/hedaetul/Hedaetul/my programs/java/Shop Management System/icon/Search.png"));
         searchButton = new JButton(new ImageIcon(buttonIcon));
        searchButton.setBounds(600, 15, 30, 30);
        searchButton.setBorderPainted(false);
        searchButton.setFocusPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.addActionListener(e->set());
        searchButton.addActionListener(e->{
            try{
                searchProduct();
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
        });
        panel2.add(searchButton);



        this.add(panel);
    }
    public static AccountPage accountPage= new AccountPage();
    private void accountOpen(){                                                 //create and login account
        accountPage.setVisible(true);
    }

    public static boolean homePage = false;
    public static Product product = null;
    public static Product productByName = null;

    public  void searchProduct() throws SQLException{                           //search product

        if(!"".equals(searchField.getText())){

            ProductDb productDb= new ProductDb();
            product = productDb.getProduct(searchField.getText());
            productByName = productDb.getProductByName(searchField.getText());
            if(product==null && productByName == null){
                JOptionPane.showMessageDialog(null, "Nothing found");
                return;
            }
            homePage = true;
            ProductInfo productInfo = new ProductInfo();
            productInfo.setVisible(true);
            searchField.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Enter product id");
         }

    }

    public void mouseClicked(MouseEvent e){
        if(searchField.getText().equals("search product")){
            searchField.setText("");
        }
    }

    public void mousePressed(MouseEvent e){}

    public void mouseReleased(MouseEvent e){}

    public void mouseEntered(MouseEvent e){}

    public void mouseExited(MouseEvent e){}

    private void set(){
        if(searchField.getText().equals("")){
            searchField.setText("search product");
        }
    }

    public void keyTyped(KeyEvent e){
        if(searchField.getText().equals("search product")){
            searchField.setText("");
        }
    }

    public void keyPressed(KeyEvent e){}

    public void keyReleased(KeyEvent e){}


}
