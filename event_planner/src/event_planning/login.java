/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package event_planning;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import model.User;

/**
 *
 * @author usman
 */
public class login  implements ActionListener{
  private  JFrame login;
  private  JLabel nameLabel;
  private  JTextField nametext;
  private  JLabel passwordLabel;
  private  JPasswordField passwordtext;
  private  JButton enter;
  private  JButton cancel;
  private  JLabel noAccount;
  private  JButton cancelPic;
  private  JComboBox userId;
  Connection connection;
    
    login() throws SQLException{
     ImageIcon enterIcon = new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\loginIcon.png");
     ImageIcon cancelIcon = new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\logoutIcon.png");
     ImageIcon backGroundImage1 = new ImageIcon(new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\logo2.jpg").getImage().getScaledInstance(300, 256, Image.SCALE_DEFAULT));
     ImageIcon backGroundImage2 = new ImageIcon(new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\dining_table5.jpg").getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT));
        
     //========connection of databasse =============
     String url = "jdbc:mysql://localhost:3306/eventplanner";
     connection = DriverManager.getConnection(url, "root", "Abdullahi");
     
     
     
      //--------- label part of the project ---------------
        JLabel background = new JLabel();
        background.setIcon(backGroundImage1);
        background.setSize(500,400);
        background.setVerticalAlignment(JLabel.CENTER);
        background.setHorizontalAlignment(JLabel.CENTER);
     
        JLabel welcomeLabel = new JLabel("WELCOME TO LOGIN PAGE");
        welcomeLabel.setFont(new Font("Times new Romen", Font.BOLD,16));      
        welcomeLabel.setBounds(10, 10, 300, 100);
        
        
        JLabel nameLabel = new JLabel("Username");
        nameLabel.setFont(new Font("Times new Romen", Font.BOLD,15));      
        nameLabel.setBounds(10, 60, 200, 100);
        
        nametext = new JTextField();
        nametext.setBounds(10, 130, 170, 30);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Times new Romen", Font.BOLD,15));      
        passwordLabel.setBounds(10, 125, 200, 100);
       
        passwordtext = new JPasswordField();
        passwordtext.setBounds(10, 190, 170, 30);
        
        
         JLabel userlabel = new JLabel("User:");
        userlabel.setFont(new Font("Times new Romen", Font.BOLD,15));
        userlabel.setBounds(10, 185, 200, 100);
        
        String types[] = {"Customer","Admin"};
        userId = new JComboBox(types);
        userId.setBounds(10, 255, 210, 20);
        
        
         //----------button part ------------------
        enter = new JButton("Enter");
        enter.setFocusable(false);
        enter.setBounds(10, 300, 120, 50);
        enter.setIcon(enterIcon);
        enter.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.setFocusable(false);
        cancel.setBounds(140, 300, 130, 50);
        cancel.setIcon(cancelIcon);
        cancel.addActionListener(this);
        
        // ---------- if not account ------------
        noAccount = new JLabel("Click Here for new Account");
        noAccount.setFont(new Font("Times new Romen", Font.BOLD,15));
        noAccount.setBounds(30, 340, 1000, 100);
        noAccount.addMouseListener(new MouseListener() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	 
        	 
             login.dispose();
             try {
				new createAccount();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
         }

         @Override
         public void mousePressed(MouseEvent e) {
             noAccount.setForeground(Color.GREEN);
         }

         @Override
         public void mouseReleased(MouseEvent e) {
         }

         @Override
         public void mouseEntered(MouseEvent e) {
         noAccount.setFont(new Font("Times new Romen", Font.BOLD,17));
         noAccount.setForeground(Color.red);
         }

         @Override
         public void mouseExited(MouseEvent e) {
           noAccount.setFont(new Font("Times new Romen", Font.BOLD,15));
           noAccount.setForeground(Color.black);
             
         }
        }
        );
        
     //---------- left panel part---------------
        JPanel panelleft = new JPanel();
        panelleft.setSize(200,200);
        panelleft.setLayout(new GridLayout());
        panelleft.setBackground(Color.white);
        panelleft.add(background);
        
        ImageIcon cancelIcon2 = new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\deleteIcon.png");
        cancelPic = new JButton(cancelIcon2);
        cancelPic.setBackground(Color.white);
        cancelPic.setFocusable(false);
        cancelPic.setForeground(Color.red);
        cancelPic.setBounds(220,0, 50, 50);
        cancelPic.addActionListener(this);
        
        
        // ----------- right panel -----------------
        JPanel panelright = new JPanel();
        panelright.setSize(200,200);
        panelright.setLayout(null);
        panelright.setBackground(Color.WHITE);
        panelright.add(nameLabel);
        panelright.add(nametext);
        panelright.add(passwordtext);
        panelright.add(passwordLabel);
        panelright.add(enter);
        panelright.add(cancel);
        panelright.add(welcomeLabel);
        panelright.add(noAccount);
        panelright.add(userlabel);
        panelright.add(userId);
        panelright.add(cancelPic);
        
     
     
      // --------- Frame of the project ----------
        login = new JFrame("Create New Account");
        login.setIconImage(backGroundImage1.getImage());
        login.setResizable(false);
        login.setSize(570,430);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setLocationRelativeTo(null);
        login.setLayout(new GridLayout(1,1));       
        login.setUndecorated(true);
        login.add(panelleft);
        login.add(panelright);
        
        login.setVisible(true);
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == cancel){
        login.dispose();
        }
        
        
        if(e.getSource() == enter) {
        	
        	String email = nametext.getText();
        	char[] password = passwordtext.getPassword();
        	int userIdForm = userId.getSelectedIndex();
        	ResultSet resultSet;
        	
        	
        	
        	if(userIdForm == 0) {
        		//============= customer connections ==================
        		System.out.println("customer working");
        		
        		if(email.equals("") || password.equals(null)) {
	        		JOptionPane.showMessageDialog(null, "Please fill the fields");
	        	}else {
	        	
	        		try {
	        		String query = "SELECT * FROM Customer_Table WHERE email = ? AND password = ?";
	        		
	        		PreparedStatement preparedStatement;
					
						preparedStatement = connection.prepareStatement(query);
					
			       	
			       	preparedStatement.setString(1, email);
			       	preparedStatement.setString(2,new String( password));
		            resultSet = preparedStatement.executeQuery();
	
		            if (resultSet.next()) {
		            	login.dispose();
		            	
		            	User.email = email;
			       		new	CustomerHomePage();
		         }else {
		             JOptionPane.showMessageDialog(null,  "wrong id or password");
//		             nametext.setText("");
		             passwordtext.setText("");
		         }
	        		} catch (SQLException e1) {
	    				// TODO Auto-generated catch block
	    				e1.printStackTrace();
	    			}
		        
	        		
	        	}
	        		
        		
        		
        	}else {
        		// ================ Admin connection to data base ================
        		System.out.println("Admin working");
        		if(email.equals("") || password.equals(null)) {
	        		JOptionPane.showMessageDialog(null, "Please fill the fields");
	        	}else {
	        	
	        		try {
	        		String query = "SELECT * FROM admin_Table WHERE email = ? AND password = ?";
	        		
	        		PreparedStatement preparedStatement;
					
						preparedStatement = connection.prepareStatement(query);
					
			       	
			       	preparedStatement.setString(1, email);
			       	preparedStatement.setString(2,new String( password));
		            resultSet = preparedStatement.executeQuery();
	
		            if (resultSet.next()) {
		            	login.dispose();
			       		new	AdminHomePage();
			       		
		         }else {
		             JOptionPane.showMessageDialog(null,  "wrong id or password");
		             nametext.setText("");
		             passwordtext.setText("");
		         }
	        		} catch (SQLException e1) {
	    				// TODO Auto-generated catch block
	    				e1.printStackTrace();
	    			}
		        
	        		
	        	}
        	}
        	
        	
        }
        
        
        if(e.getSource() == cancelPic){
        login.dispose();
        }
        
    }
}
