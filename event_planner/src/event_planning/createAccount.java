/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package event_planning;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

import com.mysql.cj.exceptions.PasswordExpiredException;

/**
 *
 * @author usman
 */
public class createAccount implements ActionListener{
    private JFrame account;
    private JLabel background;
    private JTextField fullnametext;
    private JTextField phonetext;
    private JComboBox gender;
    private JPasswordField passwordtext;
    private JPasswordField comfirmpasswordtext;
    private ImageIcon backGroundImage1; 
    private ImageIcon backGroundImage2; 
    private JButton enter;
    private JButton cancel;
    private JTextField gmailText;
    Connection connection;

    public createAccount() throws SQLException {
   
        //========connection of databasse =============
        String url = "jdbc:mysql://localhost:3306/eventplanner";
        connection = DriverManager.getConnection(url, "root", "Abdullahi");
        
        ImageIcon enterIcon = new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\loginIcon.png");
        ImageIcon cancelIcon = new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\logoutIcon.png");
        
        backGroundImage1 = new ImageIcon(new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\logo2.jpg").getImage().getScaledInstance(300, 256, Image.SCALE_DEFAULT));
        backGroundImage2 = new ImageIcon(new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\dining_table5.jpg").getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT));
        
        //--------- label part of the project ---------------
        background = new JLabel();
        background.setIcon(backGroundImage1);
        background.setSize(500,400);
        background.setVerticalAlignment(JLabel.CENTER);
        background.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel welcomeLabel = new JLabel("WELCOME TO CREATE NEW ACCOUNT");
        welcomeLabel.setFont(new Font("Times new Romen", Font.BOLD,14));      
        welcomeLabel.setBounds(10, -20, 400, 100);
        
        JLabel nameLabe = new JLabel("Full Name:");
        nameLabe.setFont(new Font("Times new Romen", Font.BOLD,15));      
        nameLabe.setBounds(10, 15, 200, 100);
        
        
        JLabel phoneLabe = new JLabel("Phone Number:");
        phoneLabe.setFont(new Font("Times new Romen", Font.BOLD,15));      
        phoneLabe.setBounds(10, 70, 210, 100);
        
        
        JLabel gmailLabe = new JLabel("Email:");
        gmailLabe.setFont(new Font("Times new Romen", Font.BOLD,15));      
        gmailLabe.setBounds(10, 130, 210, 100);
          
       
        JLabel genderlabel = new JLabel("Gender");
        genderlabel.setFont(new Font("Times new Romen", Font.BOLD,15));
        genderlabel.setBounds(10, 185, 200, 100);
        
        String types[] = {"Male","Female"};
        gender = new JComboBox(types);
        gender.setBounds(10, 255, 210, 20);
        
        JLabel passwordLabe = new JLabel("Password:");
        passwordLabe.setFont(new Font("Times new Romen", Font.BOLD,15));      
        passwordLabe.setBounds(10, 245, 200, 100);
        
        
        JLabel comfirmLabe = new JLabel("Confirm Password:");
        comfirmLabe.setFont(new Font("Times new Romen", Font.BOLD,15));      
        comfirmLabe.setBounds(10, 300, 300, 100);
        
        
        //------------- Text Field part -------------
        fullnametext = new JTextField();
        fullnametext.setBounds(10, 75, 170, 30);
        
        
        phonetext = new JTextField();
        phonetext.setBounds(10, 135, 170, 30);
        
        gmailText = new JTextField();
        gmailText.setBounds(10, 190, 170, 30);
        
        passwordtext = new JPasswordField();
        passwordtext.setBounds(10, 305, 170, 30);
        
        
        comfirmpasswordtext = new JPasswordField();
        comfirmpasswordtext.setBounds(10, 360, 170, 30);
        
        //----------button part ------------------
        enter = new JButton("Enter");
        enter.setFocusable(false);
        enter.setBounds(10, 420, 120, 50);
        enter.setIcon(enterIcon);
        enter.addActionListener(this);
        
        cancel = new JButton("Back");
        cancel.setFocusable(false);
        cancel.setBounds(140, 420, 130, 50);
        cancel.setIcon(cancelIcon);
        cancel.addActionListener(this);
        
        //---------- left panel part---------------
        JPanel panelleft = new JPanel();
        panelleft.setSize(200,200);
        panelleft.setLayout(new GridLayout());
        panelleft.setBackground(Color.white);
        panelleft.add(background);
        
        
        // ----------- right panel -----------------
        JPanel panelright = new JPanel();
        panelright.setSize(200,200);
        panelright.setLayout(null);
//        panelright.setBounds(200, 200, 200, 200);
        panelright.setBackground(Color.WHITE);
        panelright.add(nameLabe);
        panelright.add(fullnametext);
        panelright.add(phonetext);
        panelright.add(passwordtext);
        panelright.add(comfirmpasswordtext);
        panelright.add(nameLabe);
        panelright.add(phoneLabe);
        panelright.add(passwordLabe);
        panelright.add(comfirmLabe);
        panelright.add(gender);
        panelright.add(genderlabel);
        panelright.add(enter);
        panelright.add(cancel);
        panelright.add(welcomeLabel);
        panelright.add(gmailLabe);
        panelright.add(gmailText);
        
        
        // --------- Frame of the project ----------
        account = new JFrame("Create New Account");
        account.setIconImage(backGroundImage1.getImage());
        account.setResizable(false);
        account.setSize(570,550);
        account.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        account.setLocationRelativeTo(null);
        account.setLayout(new GridLayout(1,1));       

        account.add(panelleft);
        account.add(panelright);
        
        account.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == cancel){
        account.dispose();
        try {
			new login();
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
        }
        
        if(e.getSource() == enter){
//        account.dispose();
//        	add data to the database
		       try {
		    	   String name = fullnametext.getText();
		    	   String phoneNo = phonetext.getText();
		    	   String email = gmailText.getText();
		    	   String genderText;
		    	   String password = new String (passwordtext.getPassword());
		    	   String comfirmPassword = new String(comfirmpasswordtext.getPassword());
		    	   int genderParty = gender.getSelectedIndex();
		    	   
		    	   if (genderParty == 0) {
					genderText = "Male";
				}else {
					genderText = "Female";
				}
		    	   if(name.equals("") || phoneNo.equals("")|| email.equals("") || genderText.equals("")||password.equals(null) || comfirmPassword.equals(null)) {
		    		   JOptionPane.showMessageDialog(null, "Fields can not be Emtpy");
		    	   }else {
		    		   if(password.length() <4) {
		    			   JOptionPane.showMessageDialog(null, "Password must be atlest 4 character long");
		    		   }else {
		    			   
		    	   if(password.equals(comfirmPassword)) {
		    	   
		       	String query = "INSERT INTO Customer_Table(FullName,PhoneNumber,Email,Gender,Password) values (?,?,?,?,?) ";
		       	
		       	PreparedStatement preparedStatement = connection.prepareStatement(query);
		       	  
		    	   
		       	
		       	preparedStatement.setString(1, name );
		       	preparedStatement.setString(2, phoneNo );
		       	preparedStatement.setString(3, email );
		       	preparedStatement.setString(4, genderText );
		       	preparedStatement.setString(5,new String( password) );
		       	
		       	preparedStatement.executeUpdate();
		       	JOptionPane.showMessageDialog(null, "Account has been Created :)");
		       	account.dispose();
		       	new login();
		       }else {
		    	   JOptionPane.showMessageDialog(null, "Password doesn't match");
		       }
		    		   }
		    	   }
		    	   
		       	
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		       
        }
        
		       
    }
    
}
