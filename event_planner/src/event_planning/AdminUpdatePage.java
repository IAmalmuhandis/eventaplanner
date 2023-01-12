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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usman
 */
public class AdminUpdatePage implements ActionListener {

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
   private JTextField emailTxt;
   private JTextField passwordTxt;
   private JTextField eventAddressTxt;
//   private JTextField PasswordTxt;
   private JTextField eventNoPeopleTxt;

   Object[] row;   
    JTable table;
    DefaultTableModel model;
    
   Object[] rowEvent;   
    DefaultTableModel modelEvent;
   
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

    
    JFrame AdminViewPageFrame;
    JButton logout;
    JButton manageBread;
    JButton order;
    JButton home;
    JTable userTable;
    JTable actionTable;
    JTextField nameTxt;
    JTextField genderTxt;
    JTextField phoneNoTxt;
    JTextField eventPhoneNoTxt;
    JTextField eventNameTxt;
    JTextField eventPriceTxt;
    JButton addInfo;
    JButton updateInfo;
    JButton deleteInfo;
    JButton updateEvent;
    JButton searchEvent;
    JButton searchUser;
    JButton deleteEvent;
    JButton updateUser;
    JButton deleteUser;
    JButton OtherPage;
    Connection connection;
    ResultSet resultSet;
    JPanel infoPanelEvent;
    JPanel infoPanel;
    
    JTextField EventIdTxt;
    JTextField UserIdTxt;
    
    PreparedStatement CutomerPreparedStatement;
    
    public AdminUpdatePage() throws SQLException {
    
    	 //========connection of data base =============
        String url = "jdbc:mysql://localhost:3306/eventplanner";
        connection = DriverManager.getConnection(url, "root", "Abdullahi");
        
        
        backGroundImage1 = new ImageIcon(new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\logo2.jpg").getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));
        backGroundImage2 = new ImageIcon(new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\dining_table5.jpg").getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT));
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
                    AdminViewPageFrame.dispose();
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
     
        
        JLabel welcomeLabel = new JLabel("Welcome to Event page");
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
    
        JLabel action = new JLabel("Please Select the Event center you would like:");
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
        bodyMenu.setBorder(BorderFactory.createLoweredBevelBorder());
        bodyMenu.setBackground(Color.white);
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
        
        DjIcon2 = new ImageIcon (new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\djIcon.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        DjButton = new JButton("Dj Page");
        DjButton.setFocusable(false);
        DjButton.setIcon(DjIcon2);
        DjButton.setFont(new Font("Times new Roman", Font.BOLD,13));
        DjButton.setBackground(new Color(221,167,123));
        DjButton.setPreferredSize(new Dimension(150,50)); 
        DjButton.setForeground(Color.white);
        DjButton.addActionListener(this);
        
         foodIcon2 = new ImageIcon ("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\foodIcon2.png");
        
        foodServiceButton = new JButton("Food Service");
        foodServiceButton.setFocusable(false);
        foodServiceButton.setIcon(foodIcon2);
        foodServiceButton.setFont(new Font("Times new Roman", Font.BOLD,13));
        foodServiceButton.setBackground(new Color(221,167,123));
        foodServiceButton.setPreferredSize(new Dimension(150,50)); 
        foodServiceButton.setForeground(Color.white);
        foodServiceButton.addActionListener(this);
        
         EventIcon2 = new ImageIcon (new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\eventIcon.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        EventButton = new JButton("Event Page");
        EventButton.setFocusable(false);
        EventButton.setIcon(EventIcon2);
        EventButton.setFont(new Font("Times new Roman", Font.BOLD,13));
        EventButton.setBackground(new Color(221,167,123));
        EventButton.setPreferredSize(new Dimension(150,50)); 
        EventButton.setForeground(Color.white);
        EventButton.addActionListener(this);
        
        
        
        bodyMenu.add(HomeButton);
//        bodyMenu.add(DjButton);
//        bodyMenu.add(foodServiceButton);
        bodyMenu.add(EventButton);
  
        
        //========= body events part(center) ==============
        JPanel bodyCenter = new JPanel();
        bodyCenter.setLayout(new GridLayout());
        bodyCenter.setPreferredSize(new Dimension(390,50));
        bodyCenter.setBackground(new Color(221,167,123));
        
        // ========== User panel ===============
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new GridLayout(0,1));
        userPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        userPanel.setBackground(new Color(221,167,123));
        
        // ---------- info lable -----------------
        infoPanel = new JPanel();
        infoPanel.setLayout(null);
        infoPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        infoPanel.setBackground(Color.cyan);
        
        JLabel name = new JLabel("Name:");
        name.setBounds(50, 0, 50, 50);
        name.setFont(new Font("Times new Roman",Font.BOLD,15));
        
        JLabel gender = new JLabel("Gender:");
        gender.setBounds(50, 50, 100, 50);
        gender.setFont(new Font("Times new Roman",Font.BOLD,15));

        
        JLabel phoneNo = new JLabel("Phone Number:");
        phoneNo.setBounds(50, 100, 200, 50);
        phoneNo.setFont(new Font("Times new Roman",Font.BOLD,15));
        
        JLabel email = new JLabel("Email:");
        email.setBounds(320, 0, 200, 50);
        email.setFont(new Font("Times new Roman",Font.BOLD,15));
        
        JLabel Password = new JLabel("Password:");
        Password.setBounds(320, 50, 200, 50);
        Password.setFont(new Font("Times new Roman",Font.BOLD,15));
 
        JLabel UserId = new JLabel("Id:");
        UserId.setBounds(320, 100, 200, 50);
        UserId.setFont(new Font("Times new Roman",Font.BOLD,15));
 
        //------------ text field ----------------
        nameTxt = new JTextField();
        nameTxt.setBounds(160, 10, 150, 25);
        
        genderTxt = new JTextField();
        genderTxt.setBounds(160, 60, 150, 25);
        
        phoneNoTxt = new JTextField();
        phoneNoTxt.setBounds(160, 110, 150, 25);
        
        emailTxt = new JTextField();
        emailTxt.setBounds(390, 10, 150, 25);
        
        passwordTxt = new JTextField();
        passwordTxt.setBounds(390, 65, 150, 25);
        
        UserIdTxt = new JTextField();
        UserIdTxt.setBounds(390, 110, 150, 25);
        
        //----------- buttons -------------
        updateUser = new JButton("Update");
        updateUser.setPreferredSize(new Dimension(200,100));
        updateUser.setBackground(Color.green);
        updateUser.setFocusable(false);
        updateUser.setFont(new Font("Times new Romen", Font.BOLD,20));
        updateUser.setBounds(50, 170, 150, 50);
        updateUser.setForeground(Color.white);
        updateUser.addActionListener(this);
        
        deleteUser = new JButton("Delete");
        deleteUser.setPreferredSize(new Dimension(200,100));
        deleteUser.setBackground(Color.red);
        deleteUser.setForeground(Color.white);
        deleteUser.setFocusable(false);
        deleteUser.setFont(new Font("Times new Romen", Font.BOLD,20));
        deleteUser.setBounds(230, 170, 150, 50);
        deleteUser.addActionListener(this);     
        
        searchUser = new JButton("search");
        searchUser.setPreferredSize(new Dimension(200,100));
        searchUser.setBackground(Color.darkGray);
        searchUser.setForeground(Color.white);
        searchUser.setFocusable(false);
        searchUser.setFont(new Font("Times new Romen", Font.BOLD,20));
        searchUser.setBounds(400, 170, 150, 50);
        searchUser.addActionListener(this);  
        
        infoPanel.add(name);
        infoPanel.add(gender);
        infoPanel.add(phoneNo);
        infoPanel.add(nameTxt);
        infoPanel.add(genderTxt);
        infoPanel.add(phoneNoTxt);
        infoPanel.add(updateUser);
        infoPanel.add(searchUser);
        infoPanel.add(deleteUser);
        infoPanel.add(email);
        infoPanel.add(emailTxt);
        infoPanel.add(Password);
        infoPanel.add(passwordTxt);
        infoPanel.add(UserId);
        infoPanel.add(UserIdTxt);

        
        JPanel userTable = new JPanel();
     userTable.setBorder(BorderFactory.createLoweredSoftBevelBorder());
     userTable.setLayout(new GridLayout());
     userTable.setPreferredSize(new Dimension(700,0));
     
      
     Object [] column = {"S/N","Full Name","Phone Number","Email","Gender","Password"};
     model = new DefaultTableModel();
     model.setColumnIdentifiers(column);
     row = new Object [6];
     
     table = new JTable();
     table.setModel(model);
     table.setBackground(Color.CYAN);   
     
     try {
		String qury = "SELECT * FROM customer_table";
		CutomerPreparedStatement = connection.prepareStatement(qury);
		resultSet = CutomerPreparedStatement.executeQuery();
		DefaultTableModel tm = (DefaultTableModel)table.getModel();
        tm.setRowCount(0);

        while(resultSet.next()){

            Object o[] = {resultSet.getInt("id"),resultSet.getString("FullName"),resultSet.getString("PhoneNumber"),resultSet.getString("Email"),resultSet.getString("Gender"),resultSet.getString("Password")};
            tm.addRow(o);



        }    	 
	} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
	}

      JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
      
       userTable.add(scrollpane);
        userPanel.add(infoPanel);
        userPanel.add(userTable);
        
        //========= Event panel ==================
        JPanel eventPanel = new JPanel();
        eventPanel.setLayout(new GridLayout(0,1));
        eventPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        eventPanel.setBackground(new Color(221,167,123));
      
        infoPanelEvent = new JPanel();
        infoPanelEvent.setLayout(null);
        infoPanelEvent.setBorder(BorderFactory.createLoweredBevelBorder());
        infoPanelEvent.setBackground(Color.cyan);
        
        JLabel eventName = new JLabel("Event Name:");
        eventName.setBounds(50, 0, 100, 50);
        eventName.setFont(new Font("Times new Roman",Font.BOLD,15));
        
        JLabel eventGender = new JLabel("Price:");
        eventGender.setBounds(50, 50, 100, 50);
        eventGender.setFont(new Font("Times new Roman",Font.BOLD,15));

        
        JLabel eventPhoneNo = new JLabel("Phone Number:");
        eventPhoneNo.setBounds(50, 100, 200, 50);
        eventPhoneNo.setFont(new Font("Times new Roman",Font.BOLD,15));
 
        JLabel eventAddress = new JLabel("Address:");
        eventAddress.setBounds(320, 0, 200, 50);
        eventAddress.setFont(new Font("Times new Roman",Font.BOLD,15));
        
        JLabel eventNopeople = new JLabel("Number of people:");
        eventNopeople.setBounds(320, 50, 200, 50);
        eventNopeople.setFont(new Font("Times new Roman",Font.BOLD,15));
        
        JLabel eventId = new JLabel("Id:");
        eventId.setBounds(320, 100, 200, 50);
        eventId.setFont(new Font("Times new Roman",Font.BOLD,15));
 
        
        
        //------------ text field ----------------
        eventNameTxt = new JTextField();
        eventNameTxt.setBounds(160, 10, 150, 25);
        
        eventPriceTxt = new JTextField();
        eventPriceTxt.setBounds(160, 60, 150, 25);
        
        eventPhoneNoTxt = new JTextField();
        eventPhoneNoTxt.setBounds(160, 110, 150, 25);
        
        eventAddressTxt = new JTextField();
        eventAddressTxt.setBounds(390, 10, 150, 25);
        
        eventNoPeopleTxt = new JTextField();
        eventNoPeopleTxt.setBounds(450, 60, 95, 25);
        
        EventIdTxt = new JTextField();
        EventIdTxt.setBounds(390, 110, 150, 25);
        
        //----------- buttons -------------
        updateEvent = new JButton("Update");
        updateEvent.setPreferredSize(new Dimension(200,100));
        updateEvent.setBackground(Color.green);
        updateEvent.setForeground(Color.white);
        updateEvent.setFocusable(false);
        updateEvent.setFont(new Font("Times new Romen", Font.BOLD,17));
        updateEvent.setBounds(50, 170, 100, 50);
        updateEvent.addActionListener(this);
        
        deleteEvent = new JButton("Delete");
        deleteEvent.setPreferredSize(new Dimension(200,100));
        deleteEvent.setBackground(Color.red);
        deleteEvent.setForeground(Color.white);
        deleteEvent.setFocusable(false);
        deleteEvent.setFont(new Font("Times new Romen", Font.BOLD,17));
        deleteEvent.setBounds(180, 170, 100, 50);
        deleteEvent.addActionListener(this);
        
        searchEvent = new JButton("search");
        searchEvent.setPreferredSize(new Dimension(200,100));
        searchEvent.setBackground(Color.DARK_GRAY);
        searchEvent.setForeground(Color.white);
        searchEvent.setFocusable(false);
        searchEvent.setFont(new Font("Times new Romen", Font.BOLD,17));
        searchEvent.setBounds(300, 170, 100, 50);
        searchEvent.addActionListener(this);
        
        OtherPage = new JButton("Other Page");
        OtherPage.setPreferredSize(new Dimension(200,100));
        OtherPage.setForeground(Color.WHITE);
        OtherPage.setBackground(Color.BLUE);
        OtherPage.setFocusable(false);
        OtherPage.setFont(new Font("Times new Romen", Font.BOLD,10));
        OtherPage.setBounds(450, 170, 100, 50);
        OtherPage.addActionListener(this);
              
        
        infoPanelEvent.add(eventName);
        infoPanelEvent.add(eventGender);
        infoPanelEvent.add(eventPhoneNo);
        infoPanelEvent.add(eventNameTxt);
        infoPanelEvent.add(eventPriceTxt);
        infoPanelEvent.add(eventPhoneNoTxt);
        infoPanelEvent.add(updateEvent);
        infoPanelEvent.add(searchEvent);
        infoPanelEvent.add(deleteEvent);
        infoPanelEvent.add(OtherPage);
        infoPanelEvent.add(eventAddress);
        infoPanelEvent.add(eventAddressTxt);
        infoPanelEvent.add(eventNopeople);
        infoPanelEvent.add(eventNoPeopleTxt);
        infoPanelEvent.add(eventId);
        infoPanelEvent.add(EventIdTxt);
       

        
            eventPanel.add(infoPanelEvent);

            JPanel eventTable1 = new JPanel();
            eventTable1.setBorder(BorderFactory.createLoweredSoftBevelBorder());
     eventTable1.setLayout(new GridLayout());
     eventTable1.setPreferredSize(new Dimension(700,0));
            
            
     Object [] columnEvent = {"S/N","Event_Name","Address","No_of_people","Price","Phone_Number"};
     modelEvent = new DefaultTableModel();
     modelEvent.setColumnIdentifiers(columnEvent);
     rowEvent = new Object [4];
     
     
     actionTable = new JTable(modelEvent);
     actionTable.setModel(modelEvent);
     actionTable.setBackground(Color.CYAN);   
     

        JScrollPane scrollpaneEvent = new JScrollPane(actionTable);
        scrollpaneEvent.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpaneEvent.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        try {
    		String qury = "SELECT * FROM event_table";
    		CutomerPreparedStatement = connection.prepareStatement(qury);
    		ResultSet resultSet = CutomerPreparedStatement.executeQuery();
    		DefaultTableModel tm = (DefaultTableModel)actionTable.getModel();
            tm.setRowCount(0);

            while(resultSet.next()){

                Object o[] = {resultSet.getInt("id"),resultSet.getString("Name"),resultSet.getString("Address"),resultSet.getInt("No_of_people"),resultSet.getInt("Price_perhour"),resultSet.getString("Phone_Number"),resultSet.getInt("Total_Price")};
                tm.addRow(o);
                             


            }    	 
    	} catch (Exception ex) {
    			JOptionPane.showMessageDialog(null, ex);
    	}
        
         eventTable1.add(scrollpaneEvent);
//        eventPanel.add(infoPanel);
        eventPanel.add(eventTable1);
        
        
        // --------- adding to body center point --------------
        bodyCenter.add(userPanel);
        bodyCenter.add(eventPanel);
        
        bodyPanel.add(bodyMenu, BorderLayout.WEST);
        bodyPanel.add(bodyCenter, BorderLayout.CENTER);
        
        
         //============ frame of the customer ===============
        AdminViewPageFrame = new JFrame("Admin FoodService page");
        AdminViewPageFrame = new JFrame("Home Page");
        AdminViewPageFrame.setIconImage(backGroundImage1.getImage());
        AdminViewPageFrame.setSize(1200,650);
        AdminViewPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AdminViewPageFrame.setLocationRelativeTo(null);
        AdminViewPageFrame.setLayout(new BorderLayout());       
        AdminViewPageFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        AdminViewPageFrame.add(headerPanel, BorderLayout.NORTH);
        AdminViewPageFrame.add(bodyPanel, BorderLayout.CENTER);
             
        AdminViewPageFrame.setVisible(true);
        
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== HomeButton){
        AdminViewPageFrame.dispose();
        new AdminHomePage();
        }
        if(e.getSource()== EventButton){
        AdminViewPageFrame.dispose();
        try {
			new AdminEventPage();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
        }
//        if(e.getSource()== foodServiceButton){
//        AdminViewPageFrame.dispose();
//        new AdminFoodService();
//        }
//        if(e.getSource()== DjButton){
//        AdminViewPageFrame.dispose();
//        new AdminDjPage();
//        }
        if(e.getSource()== OtherPage){
        AdminViewPageFrame.dispose();
        try {
			new OtherEventsUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        }
        
        //============ user data base part ==================
        if(e.getSource() == updateUser) {
        	 //========= user adding to data base ====================
	    	   String UserName =  nameTxt.getText();
	    	   String gender = genderTxt.getText();
	    	   String phoneNo = phoneNoTxt.getText();
	    	   String email =  emailTxt.getText();
	    	   String password = passwordTxt.getText();
	    	   int id = Integer.parseInt(UserIdTxt.getText());
	    	   

	    	   try {
        	
        	String query = "UPDATE customer_table set FullName=?, PhoneNumber=? , Email=?, Gender=?, Password=? WHERE id = ? ";
        

        	
        	PreparedStatement preparedStatement = connection.prepareStatement(query);
	       	
	       	preparedStatement.setInt(6, id );
	       	preparedStatement.setString(1, UserName );
	       	preparedStatement.setString(2, phoneNo );
	       	preparedStatement.setString(3, email );
	       	preparedStatement.setString(4, gender );
	       	preparedStatement.setString(5, password );
	       	
	       	
	       	
	       	preparedStatement.executeUpdate();
	       	System.out.println(preparedStatement.executeUpdate());
	       	
	       	JOptionPane.showMessageDialog(infoPanel, "Successful Added to Updated");
	       	
	           nameTxt.setText(null);
	    	   genderTxt.setText(null);
	    	   phoneNoTxt.setText(null);
	    	   emailTxt.setText(null);
	    	   passwordTxt.setText(null);
	    	   UserIdTxt.setText(null);
	       	
	    	   }catch (SQLException  ex) {
	   	       	JOptionPane.showMessageDialog(infoPanel, "Erro........"+ex);
	   	       	System.out.println(ex);
			}
	    	   try {
	    			String qury = "SELECT * FROM customer_table";
	    			CutomerPreparedStatement = connection.prepareStatement(qury);
	    			resultSet = CutomerPreparedStatement.executeQuery();
	    			DefaultTableModel tm = (DefaultTableModel)table.getModel();
	    	        tm.setRowCount(0);

	    	        while(resultSet.next()){

	    	            Object o[] = {resultSet.getInt("id"),resultSet.getString("FullName"),resultSet.getString("PhoneNumber"),resultSet.getString("Email"),resultSet.getString("Gender"),resultSet.getString("Password")};
	    	            tm.addRow(o);



	    	        }    	 
	    		} catch (Exception ex) {
	    				JOptionPane.showMessageDialog(null, ex);
	    		}
        	
        }
        
        if(e.getSource() == deleteUser) {
       	 //========= event adding to data base ====================
	    	   String UserName =  nameTxt.getText();
	    	   String gender = genderTxt.getText();
	    	   String phoneNo = phoneNoTxt.getText();
	    	   String email =  emailTxt.getText();
	    	   String password = passwordTxt.getText();
	    	   int id = Integer.parseInt(UserIdTxt.getText());
	    	   

	    	   try {
       	
       	String query = "DELETE FROM customer_table WHERE id = ? ";
       

       	
       	PreparedStatement preparedStatement = connection.prepareStatement(query);
	       	
	       	preparedStatement.setInt(1, id );
	    	
	       	
	       	preparedStatement.executeUpdate();
	       	System.out.println(preparedStatement.executeUpdate());
	       	
	       	JOptionPane.showMessageDialog(infoPanel, "Successful Added to Deleted");
	       	
	           nameTxt.setText(null);
	    	   genderTxt.setText(null);
	    	   phoneNoTxt.setText(null);
	    	   emailTxt.setText(null);
	    	   passwordTxt.setText(null);
	    	   UserIdTxt.setText(null);
	       	
	    	   }catch (SQLException  ex) {
	   	       	JOptionPane.showMessageDialog(infoPanel, "Erro........"+ex);
	   	       	System.out.println(ex);
			}
	    	   try {
	    			String qury = "SELECT * FROM customer_table";
	    			CutomerPreparedStatement = connection.prepareStatement(qury);
	    			resultSet = CutomerPreparedStatement.executeQuery();
	    			DefaultTableModel tm = (DefaultTableModel)table.getModel();
	    	        tm.setRowCount(0);

	    	        while(resultSet.next()){

	    	            Object o[] = {resultSet.getInt("id"),resultSet.getString("FullName"),resultSet.getString("PhoneNumber"),resultSet.getString("Email"),resultSet.getString("Gender"),resultSet.getString("Password")};
	    	            tm.addRow(o);



	    	        }    	 
	    		} catch (Exception ex) {
	    				JOptionPane.showMessageDialog(null, ex);
	    		}
       	
       }
   
        // ========== event data base  ============================
       
        if(e.getSource() == updateEvent) {
       	 //========= event adding to data base ====================
        	 String EventName =  eventNameTxt.getText();
	    	   int price = Integer.parseInt( eventPriceTxt.getText());
	    	   String address = eventAddressTxt.getText();
	    	   int noPeople = Integer.parseInt( eventNoPeopleTxt.getText());
	    	   String phoneNo = eventPhoneNoTxt.getText();
	    	   int id = Integer.parseInt(EventIdTxt.getText());
	    	   

	    	   try {
       	
       	String query = "UPDATE event_table set Name=?, Address=? , No_of_people=?, Price_perhour=?, Phone_Number=? WHERE id = ? ";

       	
       		PreparedStatement preparedStatement = connection.prepareStatement(query);
	       	
	       	preparedStatement.setInt(6, id );
	    	preparedStatement.setString(1, EventName );
	       	preparedStatement.setString(2, address );
	       	preparedStatement.setInt(3, noPeople );
	       	preparedStatement.setInt(4, price );
	       	preparedStatement.setString(5, phoneNo );
	       	
	       	
	       	
	       	preparedStatement.executeUpdate();
	       	System.out.println(preparedStatement.executeUpdate());
	       	
	       	JOptionPane.showMessageDialog(infoPanelEvent, "Successful Added to Updated");
	       	
	       	eventNameTxt.setText(null);
	    	eventPriceTxt.setText(null);
	    	eventAddressTxt.setText(null);
	    	eventNoPeopleTxt.setText(null);
	    	eventPhoneNoTxt.setText(null);
	    	EventIdTxt.setText(null);
	    	   
	       	
	    	   }catch (SQLException  ex) {
	   	       	JOptionPane.showMessageDialog(infoPanelEvent, "Erro........"+ex);
	   	       	System.out.println(ex);
			}
	    	   try {
	       		String qury = "SELECT * FROM event_table";
	       		CutomerPreparedStatement = connection.prepareStatement(qury);
	       		ResultSet resultSet = CutomerPreparedStatement.executeQuery();
	       		DefaultTableModel tm = (DefaultTableModel)actionTable.getModel();
	               tm.setRowCount(0);

	               while(resultSet.next()){

	                   Object o[] = {resultSet.getInt("id"),resultSet.getString("Name"),resultSet.getString("Address"),resultSet.getInt("No_of_people"),resultSet.getInt("Price_perhour"),resultSet.getString("Phone_Number"),resultSet.getInt("Total_Price")};
	                   tm.addRow(o);
	                                


	               }    	 
	       	} catch (Exception ex) {
	       			JOptionPane.showMessageDialog(null, ex);
	       	}
       	
       }
       
       if(e.getSource() == deleteEvent) {
      	 //========= event adding to data base ====================
    	   int id = Integer.parseInt(EventIdTxt.getText());
    	   
	    	   

	    	   try {
      	
      	String query = "DELETE FROM event_table WHERE id = ?";
      

      	
      	PreparedStatement preparedStatement = connection.prepareStatement(query);
	       	
	       	preparedStatement.setInt(1, id );
	    	
	       	
	       	preparedStatement.executeUpdate();
	       	System.out.println(preparedStatement.executeUpdate());
	       	
	       	JOptionPane.showMessageDialog(infoPanelEvent, "Successful Added to Deleted");
	       	
	    	eventNameTxt.setText(null);
	    	eventPriceTxt.setText(null);
	    	eventAddressTxt.setText(null);
	    	eventNoPeopleTxt.setText(null);
	    	eventPhoneNoTxt.setText(null);
	    	EventIdTxt.setText(null);
	       	
	    	   }catch (SQLException  ex) {
	   	       	JOptionPane.showMessageDialog(infoPanelEvent, "Erro........"+ex);
	   	       	System.out.println(ex);
			}
	    	   try {
	       		String qury = "SELECT * FROM event_table";
	       		CutomerPreparedStatement = connection.prepareStatement(qury);
	       		ResultSet resultSet = CutomerPreparedStatement.executeQuery();
	       		DefaultTableModel tm = (DefaultTableModel)actionTable.getModel();
	               tm.setRowCount(0);

	               while(resultSet.next()){

	                   Object o[] = {resultSet.getInt("id"),resultSet.getString("Name"),resultSet.getString("Address"),resultSet.getInt("No_of_people"),resultSet.getInt("Price_perhour"),resultSet.getString("Phone_Number"),resultSet.getInt("Total_Price")};
	                   tm.addRow(o);
	                                


	               }    	 
	       	} catch (Exception ex) {
	       			JOptionPane.showMessageDialog(null, ex);
	       	}
      	
      }
    
       if(e.getSource() == searchEvent) {
     	  //========= event adding to data base ====================
 	    	   int id = Integer.parseInt(EventIdTxt.getText());
 	    	   

 	    	   try {
     	
     	String query = "SELECT * FROM event_table WHERE id = ? ";

     	
     		PreparedStatement preparedStatement = connection.prepareStatement(query);
 	       	
 	       	
// 	    	preparedStatement.setString(2, EventName );
// 	       	preparedStatement.setString(3, address );
// 	       	preparedStatement.setInt(4, price );
// 	       	preparedStatement.setString(5, phoneNo );
     		preparedStatement.setInt(1, id );
 	       	ResultSet rs = preparedStatement.executeQuery();
 	       	
 	       	
 	       	if(rs.next()) {
 	       		

 	       		
 	       		eventNameTxt.setText(rs.getString("Name"));
 		    	eventPriceTxt.setText(rs.getString("Price_perhour"));
 		    	eventAddressTxt.setText(rs.getString("Address"));
 		    	eventNoPeopleTxt.setText(rs.getString("No_of_people"));
 		    	eventPhoneNoTxt.setText(rs.getString("Phone_Number"));
 		    	
 		       	JOptionPane.showMessageDialog(infoPanelEvent, "Record found successful");

 	       	}else {
 		       	JOptionPane.showMessageDialog(infoPanelEvent, "Record Not found");

 	       	}
 	       	
 	    	   }catch (SQLException  ex) {
 	   	       	JOptionPane.showMessageDialog(infoPanelEvent, "Erro........"+ex);
 	   	       	System.out.println(ex);
 			}
       }

       if(e.getSource() == searchUser) {
      	  //========= event adding to data base ====================
  	    	   int id = Integer.parseInt(UserIdTxt.getText());
  	    	   

  	    	   try {
      	
      	String query = "SELECT * FROM customer_table WHERE id = ? ";

      	
      		PreparedStatement preparedStatement = connection.prepareStatement(query);
  	       	
      		preparedStatement.setInt(1, id );
  	       	ResultSet rs = preparedStatement.executeQuery();
  	       	
  	       	
  	       	if(rs.next()) {
     		
  	       		nameTxt.setText(rs.getString("FullName"));
  		    	emailTxt.setText(rs.getString("Email"));
  		    	genderTxt.setText(rs.getString("Gender"));
  		    	passwordTxt.setText(rs.getString("Password"));
  		    	phoneNoTxt.setText(rs.getString("PhoneNumber"));
    

  		    	
  		       	JOptionPane.showMessageDialog(infoPanel, "Record found successful");

  	       	}else {
  		       	JOptionPane.showMessageDialog(infoPanel, "Record Not found");

  	       	}
  	       	
  	    	   }catch (SQLException  ex) {
  	   	       	JOptionPane.showMessageDialog(infoPanel, "Erro........"+ex);
  	   	       	System.out.println(ex);
  			}
        }
       
    }
    
    
    
}
