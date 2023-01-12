/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package event_planning;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.User;

/**
 *
 * @author usman
 */
public class CustomerViewPage implements ActionListener{

   private ImageIcon backGroundImage1; 
   private ImageIcon backGroundImage2; 
   private JPanel headerPanel;
   private JPanel bodyPanel;
   private JButton eventButton;
   private JButton EventButton;
   private JButton foodServiceButton;
   private JButton viewButton;
   private JButton foodServeButton;
   private JButton HomeButton;
   private JButton forwardButton;
   private JButton backwardButton;
   private JButton DjButton;
   private JTextField hourtext;
   private JLabel Nametext;
   private JLabel Pricetext;
   private JLabel perhourtext;
   private JLabel addresstext;

   Object[] row;   
    JTable table;
    DefaultTableModel model;
   
   JPanel picturePanel;
   JLabel Pluse;
   JLabel viewServe;
   JLabel foodServe;
   JLabel event;
   JLabel Event;
   ImageIcon eventIcon ;
   ImageIcon DjIcon;
   ImageIcon foodIcon;
   ImageIcon viewIcon;
   ImageIcon foodIcon2;
   ImageIcon  eventIcon2;
   ImageIcon EventIcon2;
   ImageIcon DjIcon2;
   Connection connection;

    
    JFrame CustomerviewPageFrame;
    JButton logout;
    JButton manageBread;
    JButton order;
    JButton home;
    PreparedStatement preparedStatement;
    public CustomerViewPage() throws SQLException {
        
         backGroundImage1 = new ImageIcon(new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\logo2.jpg").getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));
        backGroundImage2 = new ImageIcon(new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\dining_table5.jpg").getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT));
        
        //========connection of data base =============
        String url = "jdbc:mysql://localhost:3306/eventplanner";
        connection = DriverManager.getConnection(url, "root", "Abdullahi");
        
          //========== logo header part==============
        JLabel logo = new JLabel(backGroundImage1);
        
        JPanel logoPlanel = new JPanel();
        logoPlanel.setLayout(new GridLayout());
        logoPlanel.setBackground(Color.white);
        logoPlanel.add(logo);
        
        //=========sign in header part ==========
        logout = new JButton("Logout");
        logout.setPreferredSize(new Dimension(200,100));
        logout.setBackground(Color.red);
        logout.setFocusable(false);
        logout.setFont(new Font("Times new Romen", Font.BOLD,20));
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == logout){
                    CustomerviewPageFrame.dispose();
                    new HomePage();
                    }
            }
        });
        
         JPanel signInPanel = new JPanel();
        signInPanel.setLayout(new GridLayout());
        signInPanel.add(logout);
        
        //======= header panel ===========
        headerPanel = new JPanel();
        headerPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        headerPanel.setPreferredSize(new Dimension(300,210));
        headerPanel.setBackground(new Color(222,226,255));
        headerPanel.setLayout(new GridLayout(2,1));
        
        //----------- header top part -------------
        JPanel headerTop = new JPanel();
        headerTop.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        headerTop.setLayout(new BorderLayout());
        headerTop.setBackground(new Color(221,167,123));
        headerTop.setPreferredSize(new Dimension(0,200));
        
        //============= welcome header =================
        
        JPanel centerHeader = new JPanel();
        centerHeader.setBorder(BorderFactory.createRaisedBevelBorder());
        centerHeader.setLayout(new GridLayout());     
        centerHeader.setPreferredSize(new Dimension(150,150));
//        centerHeader.setBackground(new Color(64,100,54));
        centerHeader.setBackground(new Color(21,122,110));
     
        
        JLabel welcomeLabel = new JLabel("Welcome to Dj page");
        welcomeLabel.setFont(new Font("Times new Roman", Font.PLAIN,30));
        welcomeLabel.setHorizontalTextPosition(JLabel.CENTER); 
        welcomeLabel.setVerticalTextPosition(JLabel.CENTER);
        welcomeLabel.setVerticalAlignment(JLabel.CENTER);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setForeground(Color.black);
        
        centerHeader.add(welcomeLabel);
     
        //========header botton =============
        JPanel headerBotton = new JPanel();
        headerBotton.setBorder(BorderFactory.createRaisedBevelBorder());
        headerBotton.setLayout(new BorderLayout());
        headerBotton.setBackground(Color.BLACK);
        headerBotton.setPreferredSize(new Dimension(0,200));
    
        JLabel action = new JLabel("This are all the record of your events:");
        action.setFont(new Font("CopperPlate Gothic", Font.ITALIC,30));
        action.setForeground(Color.white);
        action.setHorizontalAlignment(JLabel.CENTER);
       
      JPanel act = new JPanel();
      act.setLayout(new GridLayout());
      act.setBackground(Color.BLACK);
      act.setPreferredSize(new Dimension(0,200));
      act.add(action);  
        
        
        // ========= header adding components=====
        headerTop.add(logoPlanel, BorderLayout.WEST);
        headerTop.add(signInPanel, BorderLayout.EAST);
        headerTop.add(welcomeLabel, BorderLayout.CENTER);
        headerBotton.add(act,BorderLayout.CENTER);

        headerPanel.add(headerTop);
        headerPanel.add(headerBotton);
        
         //----------- body panel------------------
        bodyPanel = new JPanel();
        bodyPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder()); 
        bodyPanel.setLayout(new BorderLayout());
        bodyPanel.setBackground(new Color(221,167,123));
        
        //========= body menu part(left) ==============
        JPanel bodyMenu =new JPanel();
        bodyMenu.setBackground(Color.white);
        bodyMenu.setBorder(BorderFactory.createLoweredBevelBorder());
        bodyMenu.setLayout(new FlowLayout(FlowLayout.CENTER,10,30));
        bodyMenu.setPreferredSize(new Dimension(200,500));
        
        
        eventIcon2 = new ImageIcon (new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\homeIcon.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        
        HomeButton = new JButton("Home Page");
        HomeButton.setFocusable(false);
        HomeButton.setIcon(eventIcon2);
        HomeButton.setFont(new Font("Times new Roman", Font.BOLD,13));
        HomeButton.setBackground(new Color(221,167,123));
        HomeButton.setPreferredSize(new Dimension(150,50)); 
        HomeButton.setForeground(Color.white);
        HomeButton.addActionListener(this);
        
        EventIcon2 = new ImageIcon (new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\eventIcon.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        EventButton = new JButton("Event Page");
        EventButton.setFocusable(false);
        EventButton.setIcon(EventIcon2);
        EventButton.setFont(new Font("Times new Roman", Font.BOLD,13));
        EventButton.setBackground(new Color(221,167,123));
        EventButton.setPreferredSize(new Dimension(150,50)); 
        EventButton.setForeground(Color.white);
        EventButton.addActionListener(this);
        
         foodIcon2 = new ImageIcon ("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\foodIcon2.png");
        
        foodServiceButton = new JButton("Food Service");
        foodServiceButton.setFocusable(false);
        foodServiceButton.setIcon(foodIcon2);
        foodServiceButton.setFont(new Font("Times new Roman", Font.BOLD,13));
        foodServiceButton.setBackground(new Color(221,167,123));
        foodServiceButton.setPreferredSize(new Dimension(150,50)); 
        foodServiceButton.setForeground(Color.white);
        foodServiceButton.addActionListener(this);
        
        DjIcon2 = new ImageIcon (new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\djIcon.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        DjButton = new JButton("Dj Page");
        DjButton.setFocusable(false);
        DjButton.setIcon(DjIcon2);
        DjButton.setFont(new Font("Times new Roman", Font.BOLD,13));
        DjButton.setBackground(new Color(221,167,123));
        DjButton.setPreferredSize(new Dimension(150,50)); 
        DjButton.setForeground(Color.white);
        DjButton.addActionListener(this);
        
        
        
        bodyMenu.add(HomeButton);
        bodyMenu.add(EventButton);

        
        //========= body events part(center) ==============
        JPanel bodyCenter = new JPanel();
        bodyCenter.setLayout(new BorderLayout());
        bodyCenter.setPreferredSize(new Dimension(390,50));
        bodyCenter.setBackground(new Color(221,167,123));
        
        // ============ table part ==============
        JPanel centerPanel = new  JPanel();
     centerPanel.setLayout(new BorderLayout());
     
     JPanel tablePanel = new JPanel();
     tablePanel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
     tablePanel.setLayout(new GridLayout());
     tablePanel.setPreferredSize(new Dimension(700,0));
     
      
     Object [] column = {"Event Center","Dj ","Food Service","Total Pricee"};
     model = new DefaultTableModel();
     model.setColumnIdentifiers(column);
     row = new Object [4];
     
     table = new JTable(model);
     table.setModel(model);
     table.setBackground(Color.CYAN);   
     
     try {
    	 
    	 String getEmail = User.email;
    	 System.out.println(getEmail);
 		String qury = "SELECT * FROM cart where user_email = ?";
 		preparedStatement = connection.prepareStatement(qury);
 		preparedStatement.setString(1, getEmail);
 		
 		ResultSet resultSet = preparedStatement.executeQuery();
 		DefaultTableModel tm = (DefaultTableModel)table.getModel();
         tm.setRowCount(0);

         while(resultSet.next()){

             Object o[] = {resultSet.getString("Event_center_name"),resultSet.getString("DJ_name"),resultSet.getString("Food_name"),resultSet.getInt("Total")};
             tm.addRow(o);
            
         }    	 
 	} catch (Exception ex) {
 			JOptionPane.showMessageDialog(null, ex);
 	}


      JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
      
       tablePanel.add(scrollpane);

    //=======center Panel adder==========
     centerPanel.add(tablePanel,BorderLayout.CENTER);
        bodyCenter.add(centerPanel,BorderLayout.CENTER);
        
        bodyPanel.add(bodyMenu, BorderLayout.WEST);
        bodyPanel.add(bodyCenter, BorderLayout.CENTER);
        
        
         //============ frame of the customer ===============
        CustomerviewPageFrame = new JFrame("Customer ViewPage page");
        CustomerviewPageFrame = new JFrame("Home Page");
        CustomerviewPageFrame.setIconImage(backGroundImage1.getImage());
        CustomerviewPageFrame.setSize(1200,650);
        CustomerviewPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CustomerviewPageFrame.setLocationRelativeTo(null);
        CustomerviewPageFrame.setLayout(new BorderLayout());       
        CustomerviewPageFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        CustomerviewPageFrame.add(headerPanel, BorderLayout.NORTH);
        CustomerviewPageFrame.add(bodyPanel, BorderLayout.CENTER);
             
        CustomerviewPageFrame.setVisible(true);
        
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==HomeButton){
        CustomerviewPageFrame.dispose();
        new CustomerHomePage();
        }
        if(e.getSource()==EventButton){
        CustomerviewPageFrame.dispose();
        try {
			new CutomerEventPage();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        }
       
        
        }
    
}
