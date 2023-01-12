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
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author usman
 */
public class AdminEventPage implements ActionListener{
    private ImageIcon backGroundImage1; 
   private ImageIcon backGroundImage2; 
   private JFrame AdminEventPage;
   private JPanel headerPanel;
   private JPanel bodyPanel;
   private JButton logout;
   private JButton eventButton;
   private JButton DjButton;
   private JButton foodServiceButton;
   private JButton updateButton;
   private JButton HomeButton;
   private JButton forwardButton;
   private JButton backwardButton;
   private JButton addButton;
   private JTextField eventHourtext;
   private JTextField eventNametext;
   private JTextField eventPricetext;
   private JTextField eventPerhourtext;
   private JTextField eventAddresstext;
   private JTextField eventPhoneNotext;
   private JTextField eventNoPeople ;
   
   private JTextField djHourtext;
   private JTextField djNametext;
   private JTextField djPricetext;
   private JTextField djPerhourtext;
   private JTextField djAddresstext;
   private JTextField djPhoneNotext;
   private JTextField djNoPeople ;
   private JButton addButtonDj;
   
   private JTextField foodServiceHourtext;
   private JTextField foodServiceNametext;
   private JTextField foodServicePricetext;
   private JTextField foodServicePerhourtext;
   private JTextField foodServiceAddresstext;
   private JTextField foodServicePhoneNotext;
   private JTextField foodServiceNoPeople ;
   private JButton addButtonFood;
   
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
   JPanel eventPanel;
   JPanel djPanel;
   JPanel foodServicePanel;
   Connection connection;
   ResultSet resultSet;


    public AdminEventPage() throws SQLException {
    	
    	 //========connection of data base =============
        String url = "jdbc:mysql://localhost:3306/eventplanner";
        connection = DriverManager.getConnection(url, "root", "Abdullahi");
        
    
        backGroundImage1 = new ImageIcon(new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\logo2.jpg").getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));
        backGroundImage2 = new ImageIcon(new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\dining_table5.jpg").getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT));
        
          //========== LOGO header part==============
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
                    AdminEventPage.dispose();
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
        headerPanel.setPreferredSize(new Dimension(250,190));
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
        bodyMenu.setPreferredSize(new Dimension(190,300));
        
        
        eventIcon2 = new ImageIcon (new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\homeIcon.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        
        HomeButton = new JButton("Home Page");
        HomeButton.setFocusable(false);
        HomeButton.setIcon(eventIcon2);
        HomeButton.setFont(new Font("Times new Roman", Font.BOLD,13));
        HomeButton.setBackground(new Color(221,167,123));
        HomeButton.setPreferredSize(new Dimension(150,50)); 
        HomeButton.setForeground(Color.white);
        HomeButton.addActionListener(this);
        

        viewIcon = new ImageIcon(new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\updateIcon2.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        
        updateButton = new JButton("update");
        updateButton.setFocusable(false);
        updateButton.setIcon(viewIcon);
        updateButton.setFont(new Font("Times new Roman", Font.BOLD,13));
        updateButton.setBackground (new Color(221,167,123));
        updateButton.setPreferredSize(new Dimension(150,50)); 
        updateButton.setForeground(Color.white);
        updateButton.addActionListener(this);
        
        
        
        bodyMenu.add(HomeButton);
        bodyMenu.add(updateButton);
  
        
        //========= body part(center) ==============
        JPanel bodyCenter = new JPanel();
//        bodyCenter.setLayout(new GridLayout(2,0));
        bodyCenter.setLayout(new BorderLayout());
        bodyCenter.setBorder(BorderFactory.createRaisedBevelBorder());
        bodyCenter.setPreferredSize(new Dimension(390,50));
        bodyCenter.setBackground(new Color(221,167,123));
        
        
        picturePanel = new JPanel();
        picturePanel.setLayout(new GridLayout());
        picturePanel.setBackground(Color.white);
        picturePanel.setBounds(170, 70, 300, 300);
        
        ImageIcon pluseIcon = new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\plusIcon.png");
        Pluse = new JLabel();
//        Pluse.setForeground(Color.black);
        Pluse.setHorizontalAlignment(JLabel.CENTER);
        Pluse.setVerticalAlignment(JLabel.CENTER);
        Pluse.setIcon(pluseIcon);
        
        picturePanel.add(Pluse);
        
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        nameLabel.setBounds(10, 0, 200, 200);
        
        JLabel priceLabel = new JLabel("Price: ");
        priceLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        priceLabel.setBounds(10, 70, 200, 200);
        
        
        JLabel addressLabel = new JLabel("Address: ");
        addressLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        addressLabel.setBounds(10, 130, 200, 200);
        
        
        JLabel hourLabel = new JLabel("How many Hours would you like: ");
        hourLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        hourLabel.setBounds(10, 190, 400, 300);
        
        JLabel phoneNoLabel = new JLabel("Phone Number: ");
        phoneNoLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        phoneNoLabel.setBounds(10, 140, 400, 300);
        
        JLabel noPeopleLabel = new JLabel("Number of People: ");
        noPeopleLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        noPeopleLabel.setBounds(10, 190, 400, 300);
        
        
        //========== text fields =================
        eventNametext = new JTextField();
        eventNametext.setBounds(165, 90, 200, 30);
        
        eventPricetext = new JTextField();
        eventPricetext.setBounds(165, 160, 200, 30);
        
        eventAddresstext = new JTextField();
        eventAddresstext.setBounds(165, 220, 200, 30);
        
        eventHourtext = new JTextField();
        eventHourtext.setBounds(165, 330, 35, 20);
        
        eventPhoneNotext = new JTextField();
        eventPhoneNotext.setBounds(165, 275, 200, 30);
        
        eventNoPeople = new JTextField();
        eventNoPeople.setBounds(165, 330, 200, 30);
        
        addButton = new JButton("Add");
        addButton.setFocusable(false);
        addButton.setFont(new Font("Times new Roman", Font.BOLD,13));
        addButton.setPreferredSize(new Dimension(150,50)); 
        addButton.setForeground(Color.white);
        addButton.setBackground(Color.BLUE);
        addButton.setBounds(200, 400, 150, 50);
        addButton.addActionListener(this);
        
        addButtonDj = new JButton("Add");
        addButtonDj.setFocusable(false);
        addButtonDj.setFont(new Font("Times new Roman", Font.BOLD,13));
        addButtonDj.setPreferredSize(new Dimension(150,50)); 
        addButtonDj.setForeground(Color.white);
        addButtonDj.setBackground(Color.BLUE);
        addButtonDj.setBounds(200, 400, 150, 50);
        addButtonDj.addActionListener(this);
       
        addButtonFood = new JButton("Add");
        addButtonFood.setFocusable(false);
        addButtonFood.setFont(new Font("Times new Roman", Font.BOLD,13));
        addButtonFood.setPreferredSize(new Dimension(150,50)); 
        addButtonFood.setForeground(Color.white);
        addButtonFood.setBackground(Color.BLUE);
        addButtonFood.setBounds(200, 400, 150, 50);
        addButtonFood.addActionListener(this);
        
        //========= event panel content =============
        eventPanel = new JPanel();
        eventPanel.setLayout(null);
        eventPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        eventPanel.setBackground(new Color(221,167,123));
        
        JLabel event = new JLabel("<HTML><U>Please Enter new Event Center:<U></HTML>");
        event.setBounds(5,0,500,100);
        event.setFont(new Font("Times new Romen",Font.BOLD,17));

        
        // =============== event panel adding component ==============
          eventPanel.add(event);
	      eventPanel.add(phoneNoLabel);
	      eventPanel.add(eventPhoneNotext);
	      eventPanel.add(nameLabel);
	      eventPanel.add(priceLabel);
	      eventPanel.add(addressLabel);
	      eventPanel.add(eventNametext);
	      eventPanel.add(eventAddresstext);
	      eventPanel.add(eventPricetext);
	      eventPanel.add(noPeopleLabel);
	      eventPanel.add(eventNoPeople);
	      eventPanel.add(addButton);
	      
        
        //========= DJ panel content =============        
        djPanel = new JPanel();
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
        
        JLabel djPriceLabel = new JLabel("Price: ");
        djPriceLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        djPriceLabel.setBounds(10, 70, 200, 200);
        
        
        JLabel djAddressLabel = new JLabel("Address: ");
        djAddressLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        djAddressLabel.setBounds(10, 130, 200, 200);
        
        
        JLabel djHourLabel = new JLabel("How many Hours would you like: ");
        djHourLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        djHourLabel.setBounds(10, 190, 400, 300);
        
        JLabel djPhoneNoLabel = new JLabel("Phone Number: ");
        djPhoneNoLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        djPhoneNoLabel.setBounds(10, 140, 400, 300);
        
        JLabel djNoPeopleLabel = new JLabel("Number of People: ");
        djNoPeopleLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        djNoPeopleLabel.setBounds(10, 230, 400, 300);
        
        
        // ==============DJ label part ==============
        djNametext = new JTextField();
        djNametext.setBounds(145, 90, 200, 30);
        
        djPricetext = new JTextField();
        djPricetext.setBounds(145, 160, 200, 30);
        
        djAddresstext = new JTextField();
        djAddresstext.setBounds(145, 220, 200, 30);
      
        
        djPhoneNotext = new JTextField();
        djPhoneNotext.setBounds(145, 275, 200, 30);
       
        
        //=========DJ adding panel adding component part ======================
          djPanel.add(dj);
	      djPanel.add(djPhoneNoLabel);
	      djPanel.add(djPhoneNotext);
	      djPanel.add(djNameLabel);
	      djPanel.add(djPriceLabel);
	      djPanel.add(djAddressLabel);
	      djPanel.add(djNametext);
	      djPanel.add(djAddresstext);
	      djPanel.add(djPricetext);
	      djPanel.add(addButtonDj);

        
        //========= food service panel content =============        
        foodServicePanel = new JPanel();
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
        
        JLabel foodServicePriceLabel = new JLabel("Price: ");
        foodServicePriceLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        foodServicePriceLabel.setBounds(10, 70, 200, 200);
        
        
        JLabel foodServiceAddressLabel = new JLabel("Address: ");
        foodServiceAddressLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        foodServiceAddressLabel.setBounds(10, 130, 200, 200);
        
        JLabel foodServicePhoneNoLabel = new JLabel("Phone Number: ");
        foodServicePhoneNoLabel.setFont(new Font("Times new Romen", Font.BOLD,17));
        foodServicePhoneNoLabel.setBounds(10, 140, 400, 300);
        
        
        
        
        //========= food service text field part ===============
        foodServiceNametext = new JTextField();
        foodServiceNametext.setBounds(145, 90, 200, 30);
        
        foodServicePricetext = new JTextField();
        foodServicePricetext.setBounds(145, 160, 200, 30);
        
        foodServiceAddresstext = new JTextField();
        foodServiceAddresstext.setBounds(145, 220, 200, 30);
       
        foodServicePhoneNotext = new JTextField();
        foodServicePhoneNotext.setBounds(145, 275, 200, 30);
        
        
        //========== food service adding component part =============
          foodServicePanel.add(foodService);
	      foodServicePanel.add(foodServicePhoneNoLabel);
	      foodServicePanel.add(foodServicePhoneNotext);
	      foodServicePanel.add(foodServiceNameLabel);
	      foodServicePanel.add(foodServicePriceLabel);
	      foodServicePanel.add(foodServiceAddressLabel);
	      foodServicePanel.add(foodServiceNametext);
	      foodServicePanel.add(foodServiceAddresstext);
	      foodServicePanel.add(foodServicePricetext);
	      foodServicePanel.add(addButtonFood);
	      
	      JPanel centerBodyCenter = new JPanel();
	      centerBodyCenter.setLayout(new GridLayout(0,3));
	      centerBodyCenter.setBorder(BorderFactory.createRaisedBevelBorder());
	      centerBodyCenter.setPreferredSize(new Dimension(500,50));
	      centerBodyCenter.setBackground(new Color(221,167,123));
	      
	      centerBodyCenter.add(eventPanel);
	      centerBodyCenter.add(djPanel);
	      centerBodyCenter.add(foodServicePanel);
	      
	      JPanel bottomBodyCenter = new JPanel();
	      bottomBodyCenter.setLayout(new GridLayout());
	      bottomBodyCenter.setBorder(BorderFactory.createRaisedBevelBorder());
	      bottomBodyCenter.setPreferredSize(new Dimension(0,100));
	      bottomBodyCenter.setBackground(new Color(221,167,123));
	      
         bodyCenter.add(centerBodyCenter, BorderLayout.CENTER);
        
         bodyPanel.add(bodyMenu, BorderLayout.WEST);
         bodyPanel.add(bodyCenter, BorderLayout.CENTER);
        
        
         //============ frame of the customer ===============
        AdminEventPage = new JFrame("Admin Event page");
        AdminEventPage = new JFrame("Home Page");
        AdminEventPage.setIconImage(backGroundImage1.getImage());
        AdminEventPage.setSize(1200,650);
        AdminEventPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AdminEventPage.setLocationRelativeTo(null);
        AdminEventPage.setLayout(new BorderLayout());       
        AdminEventPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        AdminEventPage.add(headerPanel, BorderLayout.NORTH);
        AdminEventPage.add(bodyPanel, BorderLayout.CENTER);
        AdminEventPage.setVisible(true);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== HomeButton){
        AdminEventPage.dispose();
        new AdminHomePage();
        }
        if(e.getSource()== updateButton){
        AdminEventPage.dispose();
        try {
			new AdminUpdatePage();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        }
        if(e.getSource() == addButtonDj) {
        	try {
        	
         	//========= DJ adding to data base ================
	        String djName =  djNametext.getText();
	    	int djPrice = Integer.parseInt( djPricetext.getText());
	   	    String djAddress = djAddresstext.getText();
	        String djPhoneNo = djPhoneNotext.getText();
	    	     
	       	String Djquery = "INSERT INTO dj_table(`Name`,`Address`,`Price_perhour`,`Phone_Number`) values (?,?,?,?) ";
	       	
	       	PreparedStatement DjpreparedStatement = connection.prepareStatement(Djquery);
	       	
	       	DjpreparedStatement.setString(1, djName );
	       	DjpreparedStatement.setString(2, djAddress );
	       	DjpreparedStatement.setInt(3, djPrice );
	       	DjpreparedStatement.setString(4, djPhoneNo );
	       	
	       	
	       	
	       	DjpreparedStatement.executeUpdate();
	       	
	       	JOptionPane.showMessageDialog(djPanel, "Successful Added to DJ Table");
	    	djNametext.setText(null);
	    	djPricetext.setText(null);
	    	djAddresstext.setText(null);
	    	djPhoneNotext.setText(null);
        }catch (Exception e2) {
			System.out.println(e2);
			JOptionPane.showMessageDialog(djPanel, "Please full all the Fields");

		}
        }
        
        
        if(e.getSource() == addButtonFood){
        	
        	try {
        		//========= FOOD SERVICE adding to data base ================
		        String foodServiceName =  foodServiceNametext.getText();
		    	int foodServicePrice = Integer.parseInt( foodServicePricetext.getText());
		   	    String foodServiceAddress = foodServiceAddresstext.getText();
		        String foodServicePhoneNo = foodServicePhoneNotext.getText();
		    	     
		       	String foodServicequery = "INSERT INTO food_table(`Name`,`Address`,`Price_perhour`,`Phone_Number`) values (?,?,?,?) ";
		       	
		       	PreparedStatement foodServicepreparedStatement = connection.prepareStatement(foodServicequery);
		       	
		       	foodServicepreparedStatement.setString(1, foodServiceName );
		       	foodServicepreparedStatement.setString(2, foodServiceAddress );
		       	foodServicepreparedStatement.setInt(3, foodServicePrice );
		       	foodServicepreparedStatement.setString(4, foodServicePhoneNo );
		       	
		       	
		       	
		       	foodServicepreparedStatement.executeUpdate();
		       	
		       	JOptionPane.showMessageDialog(foodServicePanel, "Successful Added to food Service Table");
		       	
		       	foodServiceNametext.setText(null);
		    	foodServicePricetext.setText(null);
		    	foodServiceAddresstext.setText(null);
		    	foodServicePhoneNotext.setText(null);
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(foodServicePanel, "Please full all the Fields");
			}
        	
        }
        
        
        if(e.getSource() == addButton) {
        	  try {
        		  
        		  //========= event adding to data base ====================
		    	   String EventName =  eventNametext.getText();
		    	   int price = Integer.parseInt( eventPricetext.getText());
		    	   String address = eventAddresstext.getText();
		    	   int noPeople = Integer.parseInt( eventNoPeople.getText());
		    	   String phoneNo = eventPhoneNotext.getText();
		    	     
		       	String query = "INSERT INTO event_table(`Name`,`Address`,`No_of_people`,`Price_perhour`,`Phone_Number`) values (?,?,?,?,?) ";
		       	
		       	PreparedStatement preparedStatement = connection.prepareStatement(query);
		       	
		       	preparedStatement.setString(1, EventName );
		       	preparedStatement.setString(2, address );
		       	preparedStatement.setInt(3, noPeople );
		       	preparedStatement.setInt(4, price );
		       	preparedStatement.setString(5, phoneNo );
		       	
		       	
		       	
		       	preparedStatement.executeUpdate();
		       	
		       	JOptionPane.showMessageDialog(eventPanel, "Successful Added to Event Table");
		       	
		       	eventNametext.setText(null);
		    	eventPricetext.setText(null);
		    	eventAddresstext.setText(null);
		    	eventNoPeople.setText(null);
		    	eventPhoneNotext.setText(null);
		       
		       	
			} catch (Exception e2) {
//				e2.printStackTrace();
//				System.out.println(e2);
				JOptionPane.showMessageDialog(eventPanel, "Please full all the Fields");

//				JOptionPane.showMessageDialog(null, "Error............."+e2);
			}
        }
    
    }
    
}
