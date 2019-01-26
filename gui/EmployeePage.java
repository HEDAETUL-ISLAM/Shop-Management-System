package gui;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
import model.Employee;
import model.Product;
import DbController.CustomerDb;
import DbController.EmployeeDb;
import DbController.ProductDb;
import static gui.AccountPage.employeeId;
import java.awt.event.MouseEvent;

public class EmployeePage extends JFrame implements MouseListener,KeyListener{

   private  JPanel panel,panel2;
   private  JButton logout,addProduct,deleteProduct,updateProduct,updateInfo,searchButton;
   private ImageIcon img,img2;
   private JTextField searchField;
   private JPanel laftPanel;
   private JButton infoButton;

    public EmployeePage() throws IOException, SQLException{


    super("Employee");
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

        laftPanel = new JPanel();
        laftPanel.setLayout(null);
        laftPanel.setBounds(0,60, 150, 640);
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
                empinfo();
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
        });
        laftPanel.add(infoButton);

        addProduct =  new JButton("Add Product");
        addProduct.setBounds(0, 100, 150, 50);
        addProduct.setBackground(Color.decode("#1B4F72"));
        addProduct.setForeground(Color.white);
        addProduct.setFont(new Font("Serif", Font.PLAIN, 12));
        addProduct.setFocusable(false);
        addProduct.addActionListener(e->addProduct());
        laftPanel.add(addProduct);

        updateInfo =  new JButton("Change Info");
        updateInfo.setBounds(0, 50, 150, 50);
        updateInfo.setBackground(Color.decode("#1B4F72"));
        updateInfo.setForeground(Color.white);
        updateInfo.setFont(new Font("Serif", Font.PLAIN, 12));
        updateInfo.setFocusable(false);
        updateInfo.addActionListener(e->{
            try{
                updateEmp();
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
        });
        laftPanel.add(updateInfo);

        deleteProduct =  new JButton("Delete Product");
        deleteProduct.setBounds(0, 150, 150, 50);
        deleteProduct.setBackground(Color.decode("#1B4F72"));
        deleteProduct.setForeground(Color.white);
        deleteProduct.setFont(new Font("Serif", Font.PLAIN, 12));
        deleteProduct.setFocusable(false);
        deleteProduct.addActionListener(e->deltProduct());
        laftPanel.add(deleteProduct);

        updateProduct =  new JButton("Update Product");
        updateProduct.setBounds(0, 200, 150, 50);
        updateProduct.setBackground(Color.decode("#1B4F72"));
        updateProduct.setForeground(Color.white);
        updateProduct.setFont(new Font("Serif", Font.PLAIN, 12));
        updateProduct.setFocusable(false);
        updateProduct.addActionListener(e->updProduct());
        laftPanel.add(updateProduct);

        img = new ImageIcon("/home/hedaetul/Hedaetul/my programs/java/Shop Management System/icon/Shop.png");
        JLabel shopIcon = new JLabel(img);
        shopIcon.setBounds(3,5,70, 55);
        panel2.add(shopIcon);

        img2 = new ImageIcon("/home/hedaetul/Hedaetul/my programs/java/Shop Management System/icon/employee.png");
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

         JLabel clist = new JLabel("Customer list");
         clist.setBounds(630, 105, 200, 15);
         clist.setFont(new Font("Arial", Font.PLAIN, 17));
         clist.setForeground(Color.gray);
         panel.add(clist);

        ProductDb productDb=new ProductDb();                                    //product table
        Object data[][]=productDb.getAllProduct();
        String header[] ={"Product Id", "Product Name", "Price","Quntity" };
        JTable table = new JTable(data,header);
        table.setRowHeight(30);
        table.setEnabled(false);
        table.setBackground(Color.decode("#A2D9CE"));
        table.setFont(new Font("Arial", Font.PLAIN, 15));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(170, 130, 430, 560);
        getContentPane().add(scrollPane);

        CustomerDb customerDb=new CustomerDb();                                 //customer table
        Object data2[][]=customerDb.getAllCustomer();
        String header2[] ={"Customer Id", "Name", "Address","Phone" };
        JTable table2 = new JTable(data2,header2);
        table2.setRowHeight(30);
        table2.setEnabled(false);
        table2.setBackground(Color.decode("#A2D9CE"));
        table2.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane2 = new JScrollPane(table2);
        scrollPane2.setBounds(630, 130, 435, 560);
        getContentPane().add(scrollPane2);

        this.add(panel);

    }

    public void logoutDone(){                                                   //logout
        AccountPage accountPage =  new AccountPage();
        this.setVisible(false);
        accountPage.setVisible(true);
    }

    public static Employee employee=null;
    public  void empinfo() throws SQLException{                                  //employee info
        EmployeeDb employeeDb =  new EmployeeDb();
        employee=employeeDb.getEmployee(employeeId);
        EmployeeInfo employeeinfo = new EmployeeInfo();
        employeeinfo.setVisible(true);
    }

    public static  boolean employeePage = false;
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
            employeePage = true;
            ProductInfo productInfo = new ProductInfo();
            productInfo.setVisible(true);
            searchField.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Enter product id");
         }
    }

    private void addProduct(){                                                  //add product
        AddProduct addProd = new AddProduct();
        addProd.setVisible(true);
    }

    private void deltProduct(){                                                 //delete product
        DeleteProduct deletePro = new DeleteProduct();
        deletePro.setVisible(true);
    }

    private void updProduct(){                                                  //update product
        UpdateProduct updateProd = new UpdateProduct();
        updateProd.setVisible(true);
    }

    private void updateEmp() throws SQLException{                               //update emoloyee selaf info
        EmployeeDb employeeDb =  new EmployeeDb();
        employee=employeeDb.getEmployee(employeeId);
        UpdateInfoOnlyEmployee updateInfoOnlyEmp = new UpdateInfoOnlyEmployee();
        updateInfoOnlyEmp.setVisible(true);
    }

    public void mouseClicked(MouseEvent e){
        if(searchField.getText().equals("search product")){
            searchField.setText("");
        }
    }

    private void reloadPage() throws IOException, SQLException {
        EmployeePage empPage = new EmployeePage();
        empPage.setVisible(true);
        this.setVisible(false);
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
