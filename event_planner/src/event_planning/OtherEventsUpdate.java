/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package event_planning;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
public class OtherEventsUpdate implements ActionListener{

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

   Object[] Djrow;   
    JTable DjTable;
    DefaultTableModel Djmodel;

    Object[] foodrow;   
    JTable foodTable;
    DefaultTableModel foodmodel;
   
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

    
    JFrame AdminOtherEventFrame;
    JButton logout;
    JButton manageBread;
    JButton order;
    JButton home;
    JTable userTable;
    JTable actionTable;
    JTextField djNameTxt;
    JTextField djPriceTxt;
    JTextField djPhoneNoTxt;
    JTextField djAddressTxt;
    JTextField foodNameTxt;
    JTextField foodPriceTxt;
    JTextField foodPhoneNoTxt;
    JTextField foodAddressTxt;
    JButton addInfo;
    JButton updateInfo;
    JButton deleteInfo;
    JButton updateEvent;
    JButton deleteEvent;
    JButton updateInfoFood;
    JButton searchInfoFood;
    JButton searchDj;
    JButton deleteInfoFood;
    JButton updateDj;
    JButton deleteDj;
    JButton backBtn;
    
    JTextField EventIdTxt;
    JTextField djIdTxt;
    JTextField foodIdTxt;
    JPanel infoPanelFood;
    JPanel infoPanel;
    
    Connection connection;
    
    
    public OtherEventsUpdate() throws SQLException {
    	
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
                    AdminOtherEventFrame.dispose();
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
        
      backBtn = new JButton("Back");
      backBtn.setPreferredSize(new Dimension(200,100));
      backBtn.setBackground(Color.pink);
      backBtn.setFocusable(false);
      backBtn.setFont(new Font("Times new Romen", Font.BOLD,20));
//      backBtn.setBounds(0, 0, 50, 40);
      backBtn.addActionListener(this);
      
        
        // ========= header adding components=====
        headerTop.add(logoPlanel, BorderLayout.WEST);
        headerTop.add(signInPanel, BorderLayout.EAST);
        headerTop.add(welcomeLabel, BorderLayout.CENTER);
        headerBotton.add(act,BorderLayout.CENTER);
        headerBotton.add(backBtn,BorderLayout.WEST);


        headerPanel.add(headerTop);
        headerPanel.add(headerBotton);
        
         //----------- body panel------------------
        bodyPanel = new JPanel();
        bodyPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder()); 
        bodyPanel.setLayout(new BorderLayout());
        bodyPanel.setBackground(new Color(221,167,123));
        
        
         //========= body events part(center) ==============
        JPanel bodyCenter = new JPanel();
        bodyCenter.setLayout(new GridLayout());
        bodyCenter.setPreferredSize(new Dimension(390,50));
        bodyCenter.setBackground(new Color(221,167,123));
        
        
        //--------- DJ update part -------------
        JPanel djInfo = new JPanel();
        djInfo.setBackground(new Color(221,167,123));
        djInfo.setBorder(BorderFactory.createRaisedBevelBorder());
        djInfo.setLayout(new GridLayout(0,1));
        
        infoPanel = new JPanel();
        infoPanel.setLayout(null);
        infoPanel.setBackground(Color.cyan);
        infoPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        
        JLabel djName = new JLabel("Dj Name:");
        djName.setBounds(50, 0, 100, 50);
        djName.setFont(new Font("Times new Roman",Font.BOLD,15));
        
        JLabel djGender = new JLabel("Price:");
        djGender.setBounds(50, 50, 100, 50);
        djGender.setFont(new Font("Times new Roman",Font.BOLD,15));

        
        JLabel djPhoneNo = new JLabel("Phone Number:");
        djPhoneNo.setBounds(50, 100, 200, 50);
        djPhoneNo.setFont(new Font("Times new Roman",Font.BOLD,15));
        
        JLabel djAddress = new JLabel("Address:");
        djAddress.setBounds(320, 0, 200, 50);
        djAddress.setFont(new Font("Times new Roman",Font.BOLD,15));
        
        JLabel djId = new JLabel("Id:");
        djId.setBounds(320, 50, 200, 50);
        djId.setFont(new Font("Times new Roman",Font.BOLD,15));
 
        //------------ text field ----------------
        djNameTxt = new JTextField();
        djNameTxt.setBounds(160, 10, 150, 25);
        
        djPriceTxt = new JTextField();
        djPriceTxt.setBounds(160, 60, 150, 25);
        
        djPhoneNoTxt = new JTextField();
        djPhoneNoTxt.setBounds(160, 110, 150, 25);
        
        djAddressTxt = new JTextField();
        djAddressTxt.setBounds(390, 10, 150, 25);
        
        djIdTxt = new JTextField();
        djIdTxt.setBounds(390, 60, 150, 25);
        
        //----------- buttons -------------
        updateDj = new JButton("Update");
        updateDj.setPreferredSize(new Dimension(200,100));
        updateDj.setBackground(Color.green);
        updateDj.setForeground(Color.white);
        updateDj.setFocusable(false);
        updateDj.setFont(new Font("Times new Romen", Font.BOLD,20));
        updateDj.setBounds(50, 170, 150, 50);
        updateDj.addActionListener(this);
        
        deleteDj = new JButton("Delete");
        deleteDj.setPreferredSize(new Dimension(200,100));
        deleteDj.setBackground(Color.red);
        deleteDj.setFocusable(false);
        deleteDj.setFont(new Font("Times new Romen", Font.BOLD,20));
        deleteDj.setForeground(Color.white);
        deleteDj.setBounds(300, 170, 150, 50);
        deleteDj.addActionListener(this);
        
        searchDj = new JButton("search");
        searchDj.setPreferredSize(new Dimension(200,100));
        searchDj.setBackground(Color.darkGray);
        searchDj.setFocusable(false);
        searchDj.setFont(new Font("Times new Romen", Font.BOLD,20));
        searchDj.setForeground(Color.white);
        searchDj.setBounds(500, 170, 150, 50);
        searchDj.addActionListener(this);
        
        
       
       infoPanel.add(djName);
        infoPanel.add(djGender);
        infoPanel.add(djPhoneNo);
        infoPanel.add(djNameTxt);
        infoPanel.add(djPriceTxt);
        infoPanel.add(djAddress);
        infoPanel.add(djAddressTxt);
        infoPanel.add(djPhoneNoTxt);
        infoPanel.add(updateDj);
        infoPanel.add(deleteDj);
        infoPanel.add(searchDj);
        infoPanel.add(djId);
        infoPanel.add(djIdTxt);
//        infoPanel.add(backBtn);

        
            djInfo.add(infoPanel);
            
//          --------- Dj table part----------
        JPanel DjTable1 = new JPanel();
        DjTable1.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        DjTable1.setLayout(new GridLayout());
        DjTable1.setPreferredSize(new Dimension(700,0));
            
            
     Object [] columnDj = {"S/N","Dj_Name","Address","Price","Phone_Number"};
     
     Djmodel = new DefaultTableModel();
     Djmodel.setColumnIdentifiers(columnDj);
     Djrow = new Object [6];
     
    DjTable = new JTable(Djmodel);
    DjTable.setModel(Djmodel);
    DjTable.setBackground(Color.CYAN);   

      JScrollPane scrollpaneDj = new JScrollPane(DjTable);
        scrollpaneDj.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpaneDj.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        try {
        	PreparedStatement DjPreparedStatement;
        	
    		String qury = "SELECT * FROM Dj_table";
    		DjPreparedStatement = connection.prepareStatement(qury);
    		ResultSet resultSet = DjPreparedStatement.executeQuery();
    		DefaultTableModel tm = (DefaultTableModel)DjTable.getModel();
            tm.setRowCount(0);

            while(resultSet.next()){

                Object o[] = {resultSet.getInt("id"),resultSet.getString("Name"),resultSet.getString("Address"),resultSet.getInt("Price_perhour"),resultSet.getString("Phone_Number"),resultSet.getInt("Total_Price")};
                tm.addRow(o);
                             

            }    	 
    	} catch (Exception ex) {
    			JOptionPane.showMessageDialog(null, ex);
    	}
        
         DjTable1.add(scrollpaneDj);
        djInfo.add(DjTable1);

        //------------ food supply ------------
        JPanel foodInfo = new JPanel();
        foodInfo.setLayout(new GridLayout(0,1));
        foodInfo.setBorder(BorderFactory.createRaisedBevelBorder());
        foodInfo.setBackground(new Color(221,167,123));
        
        infoPanelFood = new JPanel();
        infoPanelFood.setLayout(null);
        infoPanelFood.setBorder(BorderFactory.createLoweredBevelBorder());
        infoPanelFood.setBackground(Color.cyan);
        
        JLabel FoodName = new JLabel("Food Name:");
        FoodName.setBounds(50, 0, 100, 50);
        FoodName.setFont(new Font("Times new Roman",Font.BOLD,15));
        
        JLabel foodPrice = new JLabel("Price:");
        foodPrice.setBounds(50, 50, 100, 50);
        foodPrice.setFont(new Font("Times new Roman",Font.BOLD,15));

        
        JLabel foodPhoneNo = new JLabel("Phone Number:");
        foodPhoneNo.setBounds(50, 100, 200, 50);
        foodPhoneNo.setFont(new Font("Times new Roman",Font.BOLD,15));
        
        JLabel foodAddress = new JLabel("Address:");
        foodAddress.setBounds(320, 0, 200, 50);
        foodAddress.setFont(new Font("Times new Roman",Font.BOLD,15));
        
        JLabel foodId = new JLabel("Id:");
        foodId.setBounds(320, 50, 200, 50);
        foodId.setFont(new Font("Times new Roman",Font.BOLD,15));
 
 
        //------------ text field ----------------
        foodNameTxt = new JTextField();
        foodNameTxt.setBounds(160, 10, 150, 25);
        
        foodPriceTxt = new JTextField();
        foodPriceTxt.setBounds(160, 60, 150, 25);
        
        foodPhoneNoTxt = new JTextField();
        foodPhoneNoTxt.setBounds(160, 110, 150, 25);
        
        foodAddressTxt = new JTextField();
        foodAddressTxt.setBounds(390, 10, 150, 25);
        
        foodIdTxt = new JTextField();
        foodIdTxt.setBounds(390, 60, 150, 25);
          //----------- food buttons -------------
        updateInfoFood = new JButton("Update");
        updateInfoFood.setPreferredSize(new Dimension(200,100));
        updateInfoFood.setBackground(Color.green);
        updateInfoFood.setForeground(Color.white);
        updateInfoFood.setFocusable(false);
        updateInfoFood.setFont(new Font("Times new RoFoodmen", Font.BOLD,20));
        updateInfoFood.setBounds(50, 170, 150, 50);
        updateInfoFood.addActionListener(this);
        
        deleteInfoFood = new JButton("Delete");
        deleteInfoFood.setPreferredSize(new Dimension(200,100));
        deleteInfoFood.setBackground(Color.red);
        deleteInfoFood.setForeground(Color.white);
        deleteInfoFood.setFocusable(false);
        deleteInfoFood.setFont(new Font("Times new RoFoodmen", Font.BOLD,20));
        deleteInfoFood.setBounds(300, 170, 150, 50);
        deleteInfoFood.addActionListener(this);
        
        searchInfoFood = new JButton("Search");
        searchInfoFood.setPreferredSize(new Dimension(200,100));
        searchInfoFood.setBackground(Color.darkGray);
        searchInfoFood.setForeground(Color.white);
        searchInfoFood.setFocusable(false);
        searchInfoFood.setFont(new Font("Times new RoFoodmen", Font.BOLD,20));
        searchInfoFood.setBounds(500, 170, 150, 50);
        searchInfoFood.addActionListener(this);
        
         
         infoPanelFood.add(FoodName);
        infoPanelFood.add(foodPrice);
        infoPanelFood.add(foodPhoneNo);
        infoPanelFood.add(foodNameTxt);
        infoPanelFood.add(foodPriceTxt);
        infoPanelFood.add(foodPhoneNoTxt);
        infoPanelFood.add(updateInfoFood);
        infoPanelFood.add(deleteInfoFood);
        infoPanelFood.add(searchInfoFood);
        infoPanelFood.add(foodAddressTxt);
        infoPanelFood.add(foodAddress);
        infoPanelFood.add(foodId);
        infoPanelFood.add(foodIdTxt);

        
        
        foodInfo.add(infoPanelFood);
        

//         --------- food table part---------------
        JPanel foodTable1 = new JPanel();
        foodTable1.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        foodTable1.setLayout(new GridLayout());
        foodTable1.setPreferredSize(new Dimension(700,0));
            
            
     Object [] columnFood ={"S/N","Food_service_Name","Address","Price","Phone_Number"};
     foodmodel = new DefaultTableModel();
     foodmodel.setColumnIdentifiers(columnFood);
     foodrow = new Object [5];
     
    foodTable = new JTable(foodmodel);
    foodTable.setModel(foodmodel);
    foodTable.setBackground(Color.CYAN);   

      JScrollPane scrollpaneFood = new JScrollPane(foodTable);
        scrollpaneFood.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpaneFood.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        try {
        	PreparedStatement foodPreparedStatement;
        	
    		String qury = "SELECT * FROM food_table";
    		foodPreparedStatement = connection.prepareStatement(qury);
    		ResultSet resultSet = foodPreparedStatement.executeQuery();
    		DefaultTableModel tm = (DefaultTableModel)foodTable.getModel();
            tm.setRowCount(0);

            while(resultSet.next()){

                Object o[] = {resultSet.getInt("id"),resultSet.getString("Name"),resultSet.getString("Address"),resultSet.getInt("Price_perhour"),resultSet.getString("Phone_Number"),resultSet.getInt("Total_Price")};
                tm.addRow(o);
                             

            }    	 
    	} catch (Exception ex) {
    			JOptionPane.showMessageDialog(null, ex);
    	}
        
         foodTable1.add(scrollpaneFood);
        foodInfo.add(foodTable1);
        
        //---------- body center adding point-------------
        bodyCenter.add(djInfo);
        bodyCenter.add(foodInfo);
        bodyPanel.add(bodyCenter, BorderLayout.CENTER);
        
        
         //============ frame of the customer ===============
        AdminOtherEventFrame = new JFrame("Admin FoodService page");
        AdminOtherEventFrame = new JFrame("Home Page");
        AdminOtherEventFrame.setIconImage(backGroundImage1.getImage());
        AdminOtherEventFrame.setSize(1200,650);
        AdminOtherEventFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AdminOtherEventFrame.setLocationRelativeTo(null);
        AdminOtherEventFrame.setLayout(new BorderLayout());       
        AdminOtherEventFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        AdminOtherEventFrame.add(headerPanel, BorderLayout.NORTH);
        AdminOtherEventFrame.add(bodyPanel, BorderLayout.CENTER);
             
        AdminOtherEventFrame.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == backBtn) {
    		AdminOtherEventFrame.dispose();
    		try {
				new AdminUpdatePage();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
    	}
    	
    	 // ========== DJ data base  ============================
        
        if(e.getSource() == updateDj) {
       	 //========= event adding to data base ====================
        	 String EventName =  djNameTxt.getText();
	    	   int price = Integer.parseInt( djPriceTxt.getText());
	    	   String address = djAddressTxt.getText();
	    	   String phoneNo = djPhoneNoTxt.getText();
	    	   int id = Integer.parseInt(djIdTxt.getText());
	    	   

	    	   try {
       	
       	String query = "UPDATE dj_table set Name=?, Address=?, Price_perhour=?, Phone_Number=? WHERE id = ? ";

       	
       		PreparedStatement preparedStatement = connection.prepareStatement(query);
	       	
	       	preparedStatement.setInt(5, id );
	    	preparedStatement.setString(1, EventName );
	       	preparedStatement.setString(2, address );
	       	preparedStatement.setInt(3, price );
	       	preparedStatement.setString(4, phoneNo );
	       	
	       	
	       	
	       	preparedStatement.executeUpdate();
	       	System.out.println(preparedStatement.executeUpdate());
	       	
	       	JOptionPane.showMessageDialog(infoPanel, "Successful Added to Updated");
	       	
	       	djNameTxt.setText(null);
	    	djPriceTxt.setText(null);
	    	djAddressTxt.setText(null);
	    	djPhoneNoTxt.setText(null);
	    	djIdTxt.setText(null);
	    	   
	    	
	       	
	    	   }catch (SQLException  ex) {
	   	       	JOptionPane.showMessageDialog(infoPanel, "Erro........"+ex);
	   	       	System.out.println(ex);
			}
	    	   try {
	           	PreparedStatement DjPreparedStatement;
	           	
	       		String qury = "SELECT * FROM Dj_table";
	       		DjPreparedStatement = connection.prepareStatement(qury);
	       		ResultSet resultSet = DjPreparedStatement.executeQuery();
	       		DefaultTableModel tm = (DefaultTableModel)DjTable.getModel();
	               tm.setRowCount(0);

	               while(resultSet.next()){

	                   Object o[] = {resultSet.getInt("id"),resultSet.getString("Name"),resultSet.getString("Address"),resultSet.getInt("Price_perhour"),resultSet.getString("Phone_Number"),resultSet.getInt("Total_Price")};
	                   tm.addRow(o);
	                                

	               }    	 
	       	} catch (Exception ex) {
	       			JOptionPane.showMessageDialog(null, ex);
	       	}
       	
       }
       
       if(e.getSource() == deleteDj) {
      	 //========= event adding to data base ====================
    	   int id = Integer.parseInt(djIdTxt.getText());
    	   
	    	   

	    	   try {
      	
      	String query = "DELETE FROM dj_table WHERE id = ?";
      

      	
      	PreparedStatement preparedStatement = connection.prepareStatement(query);
	       	
	       	preparedStatement.setInt(1, id );
	    	
	       	
	       	preparedStatement.executeUpdate();
	       	System.out.println(preparedStatement.executeUpdate());
	       	
	       	JOptionPane.showMessageDialog(infoPanel, "Successful Added to Deleted");
	       	
	    	djNameTxt.setText(null);
	    	djPriceTxt.setText(null);
	    	djAddressTxt.setText(null);
	    	djPhoneNoTxt.setText(null);
	    	djIdTxt.setText(null);
	       	
	    	
	    	   }catch (SQLException  ex) {
	   	       	JOptionPane.showMessageDialog(infoPanel, "Erro........"+ex);
	   	       	System.out.println(ex);
			}
	    	   try {
	           	PreparedStatement DjPreparedStatement;
	           	
	       		String qury = "SELECT * FROM Dj_table";
	       		DjPreparedStatement = connection.prepareStatement(qury);
	       		ResultSet resultSet = DjPreparedStatement.executeQuery();
	       		DefaultTableModel tm = (DefaultTableModel)DjTable.getModel();
	               tm.setRowCount(0);

	               while(resultSet.next()){

	                   Object o[] = {resultSet.getInt("id"),resultSet.getString("Name"),resultSet.getString("Address"),resultSet.getInt("Price_perhour"),resultSet.getString("Phone_Number"),resultSet.getInt("Total_Price")};
	                   tm.addRow(o);
	                                

	               }    	 
	       	} catch (Exception ex) {
	       			JOptionPane.showMessageDialog(null, ex);
	       	}
	    	   
      }
    
    // ========== Food Service data base  ============================
       
       if(e.getSource() == updateInfoFood) {
      	 //========= event adding to data base ====================
       	 String EventName =  foodNameTxt.getText();
	    	   int price = Integer.parseInt( foodPriceTxt.getText());
	    	   String address = foodAddressTxt.getText();
	    	   String phoneNo = foodPhoneNoTxt.getText();
	    	   int id = Integer.parseInt(foodIdTxt.getText());
	    	   

	    	   try {
      	
      	String query = "UPDATE food_table set Name=?, Address=?, Price_perhour=?, Phone_Number=? WHERE id = ? ";

      	
      		PreparedStatement preparedStatement = connection.prepareStatement(query);
	       	
	       	preparedStatement.setInt(5, id );
	    	preparedStatement.setString(1, EventName );
	       	preparedStatement.setString(2, address );
	       	preparedStatement.setInt(3, price );
	       	preparedStatement.setString(4, phoneNo );
	       	
	       	
	       	
	       	preparedStatement.executeUpdate(); 
	       	System.out.println(preparedStatement.executeUpdate());
	       	
	       	JOptionPane.showMessageDialog(infoPanelFood, "Successful Added to Updated");
	       	
	       	foodNameTxt.setText(null);
	    	foodPriceTxt.setText(null);
	    	foodAddressTxt.setText(null);
	    	foodPhoneNoTxt.setText(null);
	    	foodIdTxt.setText(null);
	    	   
	    	
	    	   }catch (SQLException  ex) {
	   	       	JOptionPane.showMessageDialog(infoPanelFood, "Erro........"+ex);
	   	       	System.out.println(ex);
			}
	    	   try {
	           	PreparedStatement foodPreparedStatement;
	           	
	       		String qury = "SELECT * FROM food_table";
	       		foodPreparedStatement = connection.prepareStatement(qury);
	       		ResultSet resultSet = foodPreparedStatement.executeQuery();
	       		DefaultTableModel tm = (DefaultTableModel)foodTable.getModel();
	               tm.setRowCount(0);

	               while(resultSet.next()){

	                   Object o[] = {resultSet.getInt("id"),resultSet.getString("Name"),resultSet.getString("Address"),resultSet.getInt("Price_perhour"),resultSet.getString("Phone_Number"),resultSet.getInt("Total_Price")};
	                   tm.addRow(o);
	                                

	               }    	 
	       	} catch (Exception ex) {
	       			JOptionPane.showMessageDialog(null, ex);
	       	}
      	
      }
      
      if(e.getSource() == deleteInfoFood) {
     	 //========= event adding to data base ====================
   	   int id = Integer.parseInt(foodIdTxt.getText());
   	   
	    	   

	    	   try {
     	
     	String query = "DELETE FROM food_table WHERE id = ?";
     

     	
     	PreparedStatement preparedStatement = connection.prepareStatement(query);
	       	
	       	preparedStatement.setInt(1, id );
	    	
	       	
	       	preparedStatement.executeUpdate();
	       	System.out.println(preparedStatement.executeUpdate());
	       	
	       	JOptionPane.showMessageDialog(infoPanelFood, "Successful Added to Deleted");
	       	
	    	foodNameTxt.setText(null);
	    	foodPriceTxt.setText(null);
	    	foodAddressTxt.setText(null);
	    	foodPhoneNoTxt.setText(null);
	    	foodIdTxt.setText(null);
	    	
	       	
	    	   }catch (SQLException  ex) {
	   	       	JOptionPane.showMessageDialog(infoPanelFood, "Erro........"+ex);
	   	       	System.out.println(ex);
			}	
	    	   try {
	           	PreparedStatement foodPreparedStatement;
	           	
	       		String qury = "SELECT * FROM food_table";
	       		foodPreparedStatement = connection.prepareStatement(qury);
	       		ResultSet resultSet = foodPreparedStatement.executeQuery();
	       		DefaultTableModel tm = (DefaultTableModel)foodTable.getModel();
	               tm.setRowCount(0);

	               while(resultSet.next()){

	                   Object o[] = {resultSet.getInt("id"),resultSet.getString("Name"),resultSet.getString("Address"),resultSet.getInt("Price_perhour"),resultSet.getString("Phone_Number"),resultSet.getInt("Total_Price")};
	                   tm.addRow(o);
	                                

	               }    	 
	       	} catch (Exception ex) {
	       			JOptionPane.showMessageDialog(null, ex);
	       	}
     }
      
      if(e.getSource() == searchDj) {
    	  //========= event adding to data base ====================
	    	   int id = Integer.parseInt(djIdTxt.getText());
	    	   

	    	   try {
    	
    	String query = "SELECT * FROM dj_table WHERE id = ? ";

    	
    		PreparedStatement preparedStatement = connection.prepareStatement(query);
	       	
	       	
//	    	preparedStatement.setString(2, EventName );
//	       	preparedStatement.setString(3, address );
//	       	preparedStatement.setInt(4, price );
//	       	preparedStatement.setString(5, phoneNo );
    		preparedStatement.setInt(1, id );
	       	ResultSet rs = preparedStatement.executeQuery();
	       	
	       	
	       	if(rs.next()) {
   		
	       		djNameTxt.setText(rs.getString("Name"));
		    	djPriceTxt.setText(rs.getString("Price_perhour"));
		    	djAddressTxt.setText(rs.getString("Address"));
		    	djPhoneNoTxt.setText(rs.getString("Phone_Number"));
		    	
		       	JOptionPane.showMessageDialog(infoPanel, "Record found successful");

	       	}else {
		       	JOptionPane.showMessageDialog(infoPanel, "Record Not found");

	       	}
	       	
	    	   }catch (SQLException  ex) {
	   	       	JOptionPane.showMessageDialog(infoPanel, "Erro........"+ex);
	   	       	System.out.println(ex);
			}
      }
      
      if(e.getSource() == searchInfoFood) {
    	  //========= event adding to data base ====================
	    	   int id = Integer.parseInt(foodIdTxt.getText());
	    	   

	    	   try {
    	
    	String query = "SELECT * FROM food_table WHERE id = ? ";

    	
    		PreparedStatement preparedStatement = connection.prepareStatement(query);
	       	
	       	

    		preparedStatement.setInt(1, id );
	       	ResultSet rs = preparedStatement.executeQuery();
	       	
	       	
	       	if(rs.next()) {
   		
	       		foodNameTxt.setText(rs.getString("Name"));
		    	foodPriceTxt.setText(rs.getString("Price_perhour"));
		    	foodAddressTxt.setText(rs.getString("Address"));
		    	foodPhoneNoTxt.setText(rs.getString("Phone_Number"));
		    	
		       	JOptionPane.showMessageDialog(infoPanelFood, "Record found successful");

	       	}else {
		       	JOptionPane.showMessageDialog(infoPanelFood, "Record Not found");

	       	}
	       	
	    	   }catch (SQLException  ex) {
	   	       	JOptionPane.showMessageDialog(infoPanelFood, "Erro........"+ex);
	   	       	System.out.println(ex);
			}
      }

    }
    
    
    
}
