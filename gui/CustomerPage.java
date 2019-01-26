package gui;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.sql.*;
import java.time.*;
import java.util.*;
import java.util.List;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
import model.Customer;
import model.Product;
import model.PurchaseInfo;
import model.PurchaseProduct;
import DbController.CustomerDb;
import DbController.LoginDb;
import DbController.ProductDb;
import DbController.PurchaseInfoDb;
import static gui.AccountPage.customerId;

public class CustomerPage extends JFrame implements MouseListener,KeyListener{

   private  JPanel panel,panel2;
   private  JButton logout,addButton,searchButton;
   private ImageIcon img,img2;
   private JTextField searchField;
   private JLabel productCode,quantity;
   private JTextField quantityField,productIdFild;
   private JPanel laftPanel;
   private JButton infoButton,deleteAccount,updateInfo;
   private JScrollPane scrollPane;
   private JButton order;
   private JScrollPane buyscrollPane;
   private String buyheader[] ={"Pro. Code","Quantity","Unit Price", "Total Price"};
   public static JTable buytable;
   int i=0;

    public CustomerPage() throws IOException, SQLException{
        super("Customer");
        this.setSize(1080,720);
        Dimension dim  = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#D5D8DC"));

        panel2=new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0,0, 1080, 60);
        panel2.setBackground(Color.decode("#138D75"));
        panel.add(panel2);

        img = new ImageIcon("/home/hedaetul/Hedaetul/my programs/java/Shop Management System/icon/Shop.png");
        JLabel shopIcon = new JLabel(img);
        shopIcon.setBounds(3,5,70, 55);
        panel2.add(shopIcon);

        img2 = new ImageIcon("/home/hedaetul/Hedaetul/my programs/java/Shop Management System/icon/customer.png");
        JLabel shopIcon2 = new JLabel(img2);
        shopIcon2.setBounds(1000,5,70, 55);
        panel2.add(shopIcon2);

        JLabel name =  new JLabel("BIG SHOP");
        name.setBounds(70, 5,250, 55);
        name.setForeground(Color.decode("#D1F2EB"));
        name.setFont(new Font("Serif", Font.TYPE1_FONT, 30));
        panel2.add(name);


        logout = new JButton("Log Out");
        logout.setBackground(Color.decode("#138D75"));
        logout.setForeground(Color.WHITE);
        logout.setBounds(880,15,150,30);
        logout.setFont(new Font("Arial", Font.BOLD, 17));
        logout.setBorderPainted(false);
        logout.setFocusable(false);
        logout.setContentAreaFilled(false);
        logout.addActionListener(e->logoutDone());
        panel2.add(logout);

         searchField = new JTextField("search product");
        searchField.setBounds(450,15, 150,30);
        searchField.setBackground(Color.white);
        searchField.setForeground(Color.black);
        searchField.setFont(new Font("Arial", Font.PLAIN, 15));
        searchField.addMouseListener(this);
        searchField.addKeyListener(this);
        panel2.add(searchField);

         BufferedImage buttonIcon = ImageIO.read(new File("//home/hedaetul/Hedaetul/my programs/java/Shop Management System/icon/Search.png"));
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
        BufferedImage reloadIcon = ImageIO.read(new File("/home/hedaetul/Hedaetul/my programs/java/Shop Management System/icon/reload.png"));
        JButton reload = new JButton(new ImageIcon(reloadIcon));
       reload.setBounds(1000, 75, 35, 35);
       reload.setBorderPainted(false);
       reload.setFocusPainted(false);
       reload.setContentAreaFilled(false);
       reload.addActionListener(e->set());
       reload.addActionListener(e->{
           try {
               reloadPage();
           }
           catch (IOException ex) {
               System.out.println(ex);
           }
           catch (SQLException ex) {
               System.out.println(ex);
           }
       });
       panel.add(reload);

        JLabel list = new JLabel("Product list");
         list.setBounds(170, 105, 200, 15);
         list.setFont(new Font("Arial", Font.PLAIN, 17));
         list.setForeground(Color.gray);
         panel.add(list);

        ProductDb productDb=new ProductDb();
        Object data[][]=productDb.getAllProduct();
        String header[] ={"Product Id", "Product Name", "Price","Quntity" };
        JTable table = new JTable(data,header);
        table.setRowHeight(30);
        table.setEnabled(false);
        table.setBackground(Color.decode("#A2D9CE"));
        table.setFont(new Font("Arial", Font.PLAIN, 15));
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(170, 130, 550, 560);
        getContentPane().add(scrollPane);

        laftPanel = new JPanel();
        laftPanel.setLayout(null);
        laftPanel.setBounds(0,60, 150, 635);
        laftPanel.setBackground(Color.decode("#19263A"));
        panel.add(laftPanel);

        infoButton = new JButton("Your Info");
        infoButton.setBounds(0, 0, 150, 50);
        infoButton.setBackground(Color.decode("#1B4F72"));
        infoButton.setForeground(Color.white);
        infoButton.setFont(new Font("Serif", Font.PLAIN, 12));
        infoButton.setFocusable(false);
        infoButton.addActionListener(e->{
            try{
                custinfo();
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
        });
        laftPanel.add(infoButton);

        updateInfo =  new JButton("Update Info");
        updateInfo.setBounds(0, 50, 150, 50);
        updateInfo.setBackground(Color.decode("#1B4F72"));
        updateInfo.setForeground(Color.white);
        updateInfo.setFont(new Font("Serif", Font.PLAIN, 12));
        updateInfo.setFocusable(false);
        updateInfo.addActionListener(e->updateCustomer());
        laftPanel.add(updateInfo);

        deleteAccount = new JButton("Delete Account");
        deleteAccount.setBounds(0, 100, 150, 50);
        deleteAccount.setBackground(Color.decode("#1B4F72"));
        deleteAccount.setForeground(Color.white);
        deleteAccount.setFont(new Font("Serif", Font.PLAIN, 12));
        deleteAccount.setFocusable(false);
        deleteAccount.addActionListener(e->{
            try{
                deleteAcc();
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
        });
        laftPanel.add(deleteAccount);

        productCode =  new JLabel("Enter product id");
        productCode.setBounds(800, 130, 200,30);
        productCode.setBackground(Color.BLACK);
        productCode.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(productCode);

        productIdFild = new JTextField();
        productIdFild.setBounds(800,160,200, 30);
        productIdFild.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(productIdFild);

        quantity =  new JLabel("Quantity");
        quantity.setBounds(800, 200, 200,30);
        quantity.setBackground(Color.BLACK);
        quantity.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(quantity);

        quantityField = new JTextField();
        quantityField.setBounds(800,230,200, 30);
        quantityField.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(quantityField);

        addButton = new JButton("Add");
        addButton.setBounds(800, 280,80,30);
        addButton.setBackground(Color.decode("#1B4F72"));
        addButton.setForeground(Color.white);
        addButton.setFont(new Font("Serif", Font.PLAIN, 12));
        addButton.setFocusable(false);
        addButton.addActionListener(e->{
            try{
                buyMore();

            }
            catch(SQLException ex){
                System.out.println(ex);
            }
        });

        panel.add(addButton);

         order = new JButton("Order");
         order.setBounds(915, 280,80, 30);
         order.setBackground(Color.decode("#1B4F72"));
         order.setForeground(Color.white);
         order.setFont(new Font("Serif", Font.PLAIN, 12));
         order.setFocusable(false);
         order.addActionListener(e->{
            try{
                orderButon();
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
         });
         order.addActionListener(e->{
             try {
                 reloadPage();
             }
             catch (IOException ex) {
                 System.out.println(ex);
             }
             catch (SQLException ex) {
                 System.out.println(ex);
             }
         });
        panel.add(order);

        this.add(panel);


        buytable = new JTable(buydata,buyheader);
        buytable.setRowHeight(25);
        buytable.setBackground(Color.decode("#D2B4DE"));
        buytable.setEnabled(false);
        buyscrollPane = new JScrollPane(buytable);

    }
    PurchaseInfo purchaseInfo=null;
    public static List<PurchaseProduct> purchaseProductList = new ArrayList();  //create list to selected product to buy

    public static  boolean customerPage = false;
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
            customerPage = true;
            ProductInfo productInfo = new ProductInfo();
            productInfo.setVisible(true);
            searchField.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Enter product id");
         }
    }
    public static String buydata[][]=new String[100][100];
    public static double totalprice =0;

    public void buyMore() throws SQLException{                                  //selesct product
        ProductDb productDb=new ProductDb();
        Product product=productDb.getProduct(productIdFild.getText());
        if(product==null){
            JOptionPane.showMessageDialog(null, "No product matched");
            return;
        }
        else if(product.getAvailableQuantity()<Integer.parseInt(quantityField.getText())){    //chake available quantity
           JOptionPane.showMessageDialog(null, "Not enough quantity");
           productIdFild.setText("");
           quantityField.setText("");
           return;
        }
        else{
            if(product.getAvailableQuantity()-Integer.parseInt(quantityField.getText())>=0){
              buydata[i][0]=product.getProductId();
              buydata[i][1]=quantityField.getText();
              buydata[i][2]=product.getPrice().toString();
              buydata[i][3]=(Integer.parseInt(quantityField.getText()) * product.getPrice())+"";    //current select product price with quantity
              buytable=new JTable(buydata,buyheader);
              buyscrollPane.setBounds(730, 350, 340, 250);
              totalprice+=Double.parseDouble(buydata[i][3]);                      //count selected product all price store it total price
              i++;

              PurchaseInfoDb purchaseInfodb =  new PurchaseInfoDb();
              int lastId=purchaseInfodb.GetLastRow();

              PurchaseProduct purchaseProduct=new PurchaseProduct(lastId+1,product.getProductId(),Integer.parseInt(quantityField.getText()));
              purchaseProductList.add(purchaseProduct);

              getContentPane().add(buyscrollPane);
              productIdFild.setText("");
              quantityField.setText("");
            }
            else{
              JOptionPane.showMessageDialog(null, "Not enough");
              productIdFild.setText("");
              quantityField.setText("");
              return;
            }

        }


    }

    private void orderButon() throws SQLException{                              //order button to order product
        if(purchaseProductList.size()<1){
            JOptionPane.showMessageDialog(null, "Please insert product");
            return;
        }
        else{
            CustomerDb customerDb =  new CustomerDb();
            customer=customerDb.getCustomer(customerId);

            purchaseInfo=new PurchaseInfo(customer.getUserId(),totalprice,LocalDate.now().toString(),purchaseProductList);

            PurchaseInfoDb purchaseInfodb = new PurchaseInfoDb();
            purchaseInfodb.insertPurchase(purchaseInfo, purchaseProductList);
        }

        ShowInvoice showInvoice = new ShowInvoice();
        showInvoice.setVisible(true);
        productIdFild.setText("");
        quantityField.setText("");

    }

    public void logoutDone(){                                                   //logout
        AccountPage accountPage =  new AccountPage();
        this.setVisible(false);
        accountPage.setVisible(true);
    }

    public static Customer customer=null;
    public void custinfo() throws SQLException{                                 //customer info
        CustomerDb customerDb =  new CustomerDb();
        customer=customerDb.getCustomer(customerId);
        CustomerInfo cuatomerInfo = new CustomerInfo();
        cuatomerInfo.setVisible(true);
    }

    public void deleteAcc() throws SQLException{                                 //delete customer account
                CustomerDb customerDb = new CustomerDb();
                LoginDb loginDb =  new LoginDb();
                customerDb.deleteCustomer(customerId);
                loginDb.deleteId(customerId);
                JOptionPane.showMessageDialog(null, "Your account has deleted");
                this.dispose();
    }

    private void updateCustomer(){                                              //update customer info
        UpdateInfoCustomer updateInfoCustomer = new UpdateInfoCustomer();
        updateInfoCustomer.setVisible(true);
    }

    private void reloadPage() throws IOException, SQLException {
        CustomerPage cpPage = new CustomerPage();
        cpPage.setVisible(true);
        this.setVisible(false);
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
