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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.User;

/**
 *
 * @author usman
 */
public class CutomerEventPage implements ActionListener {
    
     private ImageIcon backGroundImage1; 
   private ImageIcon backGroundImage2; 
   private JFrame CustomerEventPage;
   private JPanel headerPanel;
   private JPanel bodyPanel;
   private JButton logout;
   private JButton eventButton;
   private JButton DjButton;
   private JButton foodServiceButton;
   private JButton viewButton;
   private JButton foodServeButton;
   private JButton HomeButton;
   private JButton forwardButton;
   private JButton backwardButton;
   private JButton cardButton;
   private JTextField hourtext;
   private JLabel Nametext;
   private JLabel Pricetext;
   private JLabel perhourtext;
   private JLabel addresstext;
   
   private JComboBox eventName;
   private JLabel eventPrice;
   private JLabel eventAddress;
   private JLabel eventPhoneNO;
   private JLabel eventNoPeople;
   private JTextField eventPerHour;
   
   private JComboBox djName;
   private JLabel djPrice;
   private JLabel djAddress;
   private JLabel djPhoneNO;
   private JLabel djNoPeople;
   private JLabel djPerHour;
   
   private JComboBox foodServiceName;
   private JLabel foodServicePrice;
   private JLabel foodServiceAddress;
   private JLabel foodServicePhoneNO;
   private JLabel foodServiceNoPeople;
   private JLabel foodServicePerHour;


   
   JPanel picturePanel;
   JLabel Pluse;
   JLabel viewServe;
   JLabel foodServe;
   JLabel event;
   JLabel Dj;
   ImageIcon eventIcon ;
   ImageIcon DjIcon;
   ImageIcon foodIcon;
   ImageIcon viewIcon;
   ImageIcon foodIcon2;
   ImageIcon  eventIcon2;
   ImageIcon DjIcon2;
   int djPrices;
   int eventPrices;
   int foodPrices;
   int EventPrice = 0;
   
   Connection connection;

    public CutomerEventPage() throws SQLException {
        
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
                    CustomerEventPage.dispose();
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
     
        //========header bottom =============
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
        
        ImageIcon cartIcon = new ImageIcon ("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\cartIcon2.png");
        
        viewButton = new JButton("View cart");
        viewButton.setFocusable(false);
        viewButton.setIcon(cartIcon);
        viewButton.setFont(new Font("Times new Roman", Font.BOLD,13));
        viewButton.setBackground (new Color(221,167,123));
        viewButton.setPreferredSize(new Dimension(150,50)); 
        viewButton.setForeground(Color.white);
        viewButton.addActionListener(this);
        
        
        
        bodyMenu.add(HomeButton);
        bodyMenu.add(viewButton);
  
        
        //========= body events part(center) ==============
        JPanel bodyCenter = new JPanel();
        bodyCenter.setLayout(new BorderLayout());
        bodyCenter.setPreferredSize(new Dimension(390,50));
        bodyCenter.setBackground(new Color(221,167,123));
        
      
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        nameLabel.setBounds(10, 0, 200, 200);
        
        String types[] = {"Select Event center"};
        eventName = new JComboBox(types);
        eventName.setBounds(100, 85, 210, 30);
        
     // ========== for data base connect of comboBox ===================
        
        String eventQuery = "SELECT Name FROM event_table  ";

       
    	
		PreparedStatement eventPreparedStatement = connection.prepareStatement(eventQuery);
       	ResultSet eventRs = eventPreparedStatement.executeQuery();
       	String name = null;
       	while(eventRs.next()) {
       		 name = eventRs.getString("Name");
       		eventName.addItem(name);
       				
       	}
       	eventName.addActionListener((e)-> {
       		System.out.println(eventName.getSelectedItem());
       		try {
				
       			String query = "SELECT * FROM event_table WHERE Name LIKE '"+eventName.getSelectedItem()+"'LIMIT 0,1";
       			PreparedStatement preparedStatement = connection.prepareStatement(query);
       			ResultSet rs = preparedStatement.executeQuery();
       			
       			
       			
       			while(rs.next()) {   	        

       	        eventPrice.setText(rs.getString("Price_perhour"));
       	        eventAddress.setText(rs.getString("Address"));
       	        eventPhoneNO.setText(rs.getString("Phone_Number"));
       	        eventNoPeople.setText(rs.getString("No_of_people"));  
       	        
       	        EventPrice = rs.getInt("Price_perhour");
       	        	}
       			
			} catch (Exception e2) {
				System.out.println(e2);
			}
       	});
       	
        
        JLabel priceLabel = new JLabel("Price: ");
        priceLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        priceLabel.setBounds(10, 50, 200, 200);
        
        eventPrice = new JLabel("0");
        eventPrice.setFont(new Font("Times new Romen", Font.BOLD,17));
        eventPrice.setBounds(100, 50, 200, 200);
        eventPrice.setForeground(Color.red);
        
        
        JLabel addressLabel = new JLabel("Address: ");
        addressLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        addressLabel.setBounds(10, 95, 200, 200);
        
		eventAddress = new JLabel("0");
		eventAddress.setFont(new Font("Times new Romen", Font.BOLD,17));
		eventAddress.setBounds(100, 95, 200, 200);
		eventAddress.setForeground(Color.red);      
        
        JLabel hourLabel = new JLabel("How many Hours would you like: ");
        hourLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        hourLabel.setBounds(10, 100, 400, 300);
        
		eventPerHour = new JTextField();
		eventPerHour.setFont(new Font("Times new Romen", Font.BOLD,17));
		eventPerHour.setBounds(275, 240, 100, 25);
		eventPerHour.setForeground(Color.red);
		        
        
        JLabel phoneNoLabel = new JLabel("Phone Number: ");
        phoneNoLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        phoneNoLabel.setBounds(10, 150, 400, 300);
        
        eventPhoneNO = new JLabel("0");
        eventPhoneNO.setFont(new Font("Times new Romen", Font.BOLD,17));
        eventPhoneNO.setBounds(150, 200, 200, 200);
        eventPhoneNO.setForeground(Color.RED);
        
        JLabel noPeopleLabel = new JLabel("Number of People: ");
        noPeopleLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        noPeopleLabel.setBounds(10, 190, 400, 300);
        
        eventNoPeople = new JLabel("0");
        eventNoPeople.setFont(new Font("Times new Romen", Font.BOLD,17));
        eventNoPeople.setBounds(170, 240, 200, 200);
        eventNoPeople.setForeground(Color.red);
       
       
        

        cardButton = new JButton("Add to cart");
        cardButton.setFocusable(false);
        cardButton.setFont(new Font("Times new Roman", Font.BOLD,20));
        cardButton.setBackground(new Color(221,167,123));
        cardButton.setPreferredSize(new Dimension(150,50)); 
        cardButton.setForeground(Color.white);
        cardButton.setBackground(Color.BLUE);
        cardButton.setBounds(950, 400, 150, 50);
        cardButton.addActionListener(this);

        
        //========= event panel content =============
        JPanel eventPanel = new JPanel();
        eventPanel.setLayout(null);
        eventPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        eventPanel.setBackground(new Color(221,167,123));
        
        JLabel event = new JLabel("<HTML><U>Please Enter new Event Center:<U></HTML>");
        event.setBounds(5,0,500,100);
        event.setFont(new Font("Times new Romen",Font.BOLD,17));

        // =============== event panel adding component ==============
         eventPanel.add(event);
	      eventPanel.add(phoneNoLabel);
	      eventPanel.add(nameLabel);
	      eventPanel.add(priceLabel);
	      eventPanel.add(addressLabel);
	      eventPanel.add(hourLabel);
	      eventPanel.add(hourLabel);
	      eventPanel.add(noPeopleLabel);
	      eventPanel.add(eventName);
	      eventPanel.add(eventPrice);
	      eventPanel.add(eventAddress);
	      eventPanel.add(eventPhoneNO);
	      eventPanel.add(eventPerHour);
	      eventPanel.add(eventNoPeople);
	      
	      //========= DJ panel content =============        
	        JPanel djPanel = new JPanel();
	        djPanel.setLayout(null);
	        djPanel.setBorder(BorderFactory.createLoweredBevelBorder());
	        djPanel.setBackground(new Color(221,167,123));
	        
	        //==========DJ text field part ================
	        JLabel dj = new JLabel("<HTML><U>Please Enter new Dj Service:</U></HTML>");
	        dj.setBounds(5,0,500,100);
	        dj.setFont(new Font("Times new Romen",Font.BOLD,17));
	        
	        JLabel djNameLabel = new JLabel("Name: ");
	        djNameLabel.setFont(new Font("Times djNew RomedjN", Font.BOLD,17));
	        djNameLabel.setBounds(10, 0, 200, 200);
	        
	        
	        // ========== for data base connect of comboBox ===================
	        
	        String djQuery = "SELECT Name FROM dj_table";

	        String djTypes[] = {"Select DJ"};
	        djName = new JComboBox(djTypes);
	        djName.setBounds(100, 85, 210, 30);
	    	
    		PreparedStatement djPreparedStatement = connection.prepareStatement(djQuery);
	       	ResultSet DjRs = djPreparedStatement.executeQuery();
	       	
	       	 
	    	while(DjRs.next()) {
	       		String DjName = DjRs.getString("Name");
	       		djName.addItem(DjName);
	       				
	       	}
	       	
	       	djName.addActionListener((e)-> {
	       		System.out.println(djName.getSelectedItem());
	       		try {
					
	       			String query = "SELECT * FROM dj_table WHERE Name LIKE '"+djName.getSelectedItem()+"'LIMIT 0,1";
	       			PreparedStatement preparedStatement = connection.prepareStatement(query);
	       			ResultSet rs = preparedStatement.executeQuery();
	       			
	       			while(rs.next()) {   	        

	       				djPrices = Integer.parseInt( rs.getString("Price_perhour"));
	       				
	       				
	       	        djPrice.setText(rs.getString("Price_perhour"));
	       	        djAddress.setText(rs.getString("Address"));
	       	        djPhoneNO.setText(rs.getString("Phone_Number"));
	       	        
	       			}
	       			
				} catch (Exception e2) {
					System.out.println(e2);
				}
	       	});


    		
	        
	        
	        JLabel djPriceLabel = new JLabel("Price: ");
	        djPriceLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
	        djPriceLabel.setBounds(10, 70, 200, 200);
	        
	        djPrice = new JLabel("0");
	        djPrice.setFont(new Font("Times new Romen", Font.BOLD,17));
	        djPrice.setBounds(100, 70, 200, 200);
	        djPrice.setForeground(Color.RED);
	        
	        JLabel djAddressLabel = new JLabel("Address: ");
	        djAddressLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
	        djAddressLabel.setBounds(10, 130, 200, 200);
	       
	        
			djAddress = new JLabel("0");
			djAddress.setFont(new Font("Times new Romen", Font.BOLD,17));
			djAddress.setBounds(100, 130, 200, 200);
			djAddress.setForeground(Color.red);     
	        
	        
	        JLabel djPhoneNoLabel = new JLabel("Phone Number: ");
	        djPhoneNoLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
	        djPhoneNoLabel.setBounds(10, 150, 400, 300);
	        
	        djPhoneNO = new JLabel("0");
	        djPhoneNO.setFont(new Font("Times new Romen", Font.BOLD,17));
	        djPhoneNO.setBounds(150, 200, 200, 200);
	        djPhoneNO.setForeground(Color.red);
	        
	        
	        
	        
	        
	      
	        
	        //=========DJ adding panel adding component part ======================
	          djPanel.add(dj);
		      djPanel.add(djPhoneNoLabel);
		      djPanel.add(djNameLabel);
		      djPanel.add(djPriceLabel);
		      djPanel.add(djAddressLabel);
		      djPanel.add(djName);
		      djPanel.add(djPrice);
		      djPanel.add(djName);
		      djPanel.add(djAddress);
		      djPanel.add(djPhoneNO);
		      
		     
	        
	        //========= food service panel content =============        
	        JPanel foodServicePanel = new JPanel();
	        foodServicePanel.setLayout(null);
	        foodServicePanel.setBorder(BorderFactory.createLoweredBevelBorder());
	        foodServicePanel.setBackground(new Color(221,167,123));
	        
	        //========= food service label part ==================
	        JLabel foodService = new JLabel("<HTML><U>Please Enter new Food Service:</U></HTML>");
	        foodService.setBounds(5,0,500,100);
	        foodService.setFont(new Font("Times new Romen",Font.BOLD,17));

	        
	        JLabel foodServiceNameLabel = new JLabel("Name: ");
	        foodServiceNameLabel.setFont(new Font("Times foodServiceNew RomefoodServiceN", Font.BOLD,17));
	        foodServiceNameLabel.setBounds(10, 0, 200, 200);
	        
 // ========== for data base connect of comboBox ===================
	        
	        String foodQuery = "SELECT Name FROM food_table";

	        String foodServiceTypes[] = {"Select Food Service"};
	        foodServiceName = new JComboBox(foodServiceTypes);
	        foodServiceName.setBounds(100, 85, 210, 30);
	    	
    		PreparedStatement foodPreparedStatement = connection.prepareStatement(foodQuery);
	       	ResultSet foodRs = foodPreparedStatement.executeQuery();
	       	
	       	String foodName;
	       	while(foodRs.next()) {
	       		foodName = foodRs.getString("Name");
	       		foodServiceName.addItem(foodName);
	       				
	       	}
	       	foodServiceName.addActionListener((e)-> {
	       		System.out.println(foodServiceName.getSelectedItem());
	       		try {
					
	       			String query = "SELECT * FROM food_table WHERE Name LIKE '"+foodServiceName.getSelectedItem()+"'LIMIT 0,1";
	       			PreparedStatement preparedStatement = connection.prepareStatement(query);
	       			ResultSet rs = preparedStatement.executeQuery();
	       			
	       			while(rs.next()) {   	        

	       				foodPrices = rs.getInt("Price_perhour");
	       	        
	       	        foodServicePrice.setText(rs.getString("Price_perhour"));
	       	        foodServiceAddress.setText(rs.getString("Address"));
	       	        foodServicePhoneNO.setText(rs.getString("Phone_Number"));
//	       	        foodServiceNoPeople.setText(rs.getString("No_of_people"));  
	       	        
	       			}
	       			
				} catch (Exception e2) {
					System.out.println(e2);
				}
	       	});

	       	
	       
	        
	        
	        JLabel foodServicePriceLabel = new JLabel("Price: ");
	        foodServicePriceLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
	        foodServicePriceLabel.setBounds(10, 70, 200, 200);
	        
	        foodServicePrice = new JLabel("0");
	        foodServicePrice.setFont(new Font("Times new Romen", Font.BOLD,17));
	        foodServicePrice.setBounds(100, 70, 200, 200);
	        foodServicePrice.setForeground(Color.red);
	        
	        JLabel foodServiceAddressLabel = new JLabel("Address: ");
	        foodServiceAddressLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
	        foodServiceAddressLabel.setBounds(10, 130, 200, 200);
	        
	        foodServiceAddress = new JLabel("0");
	        foodServiceAddress.setFont(new Font("Times new Romen", Font.BOLD,17));
	        foodServiceAddress.setBounds(100, 130, 200, 200);
	        foodServiceAddress.setForeground(Color.red);
	        
	        
	        JLabel foodServicePhoneNoLabel = new JLabel("Phone Number: ");
	        foodServicePhoneNoLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
	        foodServicePhoneNoLabel.setBounds(10, 150, 400, 300);
	        
	        foodServicePhoneNO = new JLabel("0");
	        foodServicePhoneNO.setFont(new Font("Times new Romen", Font.BOLD,17));
	        foodServicePhoneNO.setBounds(150, 200, 200, 200);
	        foodServicePhoneNO.setForeground(Color.red);
	      
	       
	        
	        
	       
	        
	        //========== food service adding component part =============
	          foodServicePanel.add(foodService);
		      foodServicePanel.add(foodServicePhoneNoLabel);
		      foodServicePanel.add(foodServiceNameLabel);
		      foodServicePanel.add(foodServicePriceLabel);
		      foodServicePanel.add(foodServiceAddressLabel);
		      
		      foodServicePanel.add(foodServiceName);
		      foodServicePanel.add(foodServicePrice);
		      foodServicePanel.add(foodServiceAddress);

		      foodServicePanel.add(foodServicePhoneNO);
		      
		      JPanel centerBodyCenter = new JPanel();
		      centerBodyCenter.setLayout(new GridLayout(0,3));
		      centerBodyCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		      centerBodyCenter.setPreferredSize(new Dimension(700,50));
		      centerBodyCenter.setBackground(new Color(221,167,123));
		      
		      centerBodyCenter.add(eventPanel);
		      centerBodyCenter.add(djPanel);
		      centerBodyCenter.add(foodServicePanel);
		      
		      JPanel bottomBodyCenter = new JPanel();
		      bottomBodyCenter.setLayout(new GridLayout());
		      bottomBodyCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		      bottomBodyCenter.setPreferredSize(new Dimension(0,100));
		      bottomBodyCenter.setBackground(new Color(221,167,123));
		      
		      bottomBodyCenter.add(cardButton);
		      
		      bodyCenter.add(centerBodyCenter, BorderLayout.CENTER);
		      bodyCenter.add(bottomBodyCenter, BorderLayout.SOUTH);
        
        bodyPanel.add(bodyMenu, BorderLayout.WEST);
        bodyPanel.add(bodyCenter, BorderLayout.CENTER);
        
        
         //============ frame of the customer ===============
        CustomerEventPage = new JFrame("Customer Event page");
        CustomerEventPage = new JFrame("Home Page");
        CustomerEventPage.setIconImage(backGroundImage1.getImage());
        CustomerEventPage.setSize(1200,650);
        CustomerEventPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CustomerEventPage.setLocationRelativeTo(null);
//        CustomerEventPage.setResizable(false);
        CustomerEventPage.setLayout(new BorderLayout());       
        CustomerEventPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        CustomerEventPage.add(headerPanel, BorderLayout.NORTH);
        CustomerEventPage.add(bodyPanel, BorderLayout.CENTER);
             
        CustomerEventPage.setVisible(true);
        
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource()==HomeButton){
        CustomerEventPage.dispose();
        new CustomerHomePage();
        }
        if(e.getSource()==viewButton){
        CustomerEventPage.dispose();
        try {
			new CustomerViewPage();
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
        }
       
    
        if(e.getSource() == cardButton) {
        	try {
        		
        		
        		
        	eventPrices =  Integer.parseInt( eventPerHour.getText());
        	int totalCart = (eventPrices*EventPrice) + djPrices + foodPrices;
        	System.out.println(eventPrices*EventPrice +" total");
        	System.out.println(totalCart +" that the total price");
        	
        	String query = "INSERT INTO cart (user_email,Event_center_name,Dj_name,Food_name,Total) values (?,?,?,?,?) ";
	       	
	       	PreparedStatement preparedStatement = connection.prepareStatement(query);
	       	
	       	 String getEmail = User.email;
	    	 System.out.println(getEmail);
	       	
	       	preparedStatement.setString(1, getEmail);
	       	preparedStatement.setString(2, (String) eventName.getSelectedItem() );
	       	preparedStatement.setString(3,(String) djName.getSelectedItem());
	       	preparedStatement.setString(4, (String) foodServiceName.getSelectedItem());
	       	preparedStatement.setInt(5, totalCart);
	       
	       	preparedStatement.executeUpdate();
	       	JOptionPane.showMessageDialog(null, "Added to cart !!!");
        		}catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
				System.out.println(ex);
			}
        	}
    
    }
}
