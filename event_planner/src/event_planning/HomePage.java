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
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author usman
 */
public class HomePage implements ActionListener{

   private JFrame homePage;
   private JPanel headerPanel;
   private JPanel bodyPanel;
   private JButton signIn;
   private JButton createAccount;
   JPanel bodyFooter;
       
    public HomePage() {
        
        ImageIcon backGroundImage1 = new ImageIcon(new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\logo2.jpg").getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));
        ImageIcon backGroundImage2 = new ImageIcon(new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\dining_table5.jpg").getImage().getScaledInstance(512, 340, Image.SCALE_DEFAULT));
        ImageIcon event = new ImageIcon (new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\dinin_table1-1.jpg").getImage().getScaledInstance(512, 340, Image.SCALE_DEFAULT));
//        ImageIcon event = new ImageIcon ("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\dinin_table1-1.jpg");
        
         //========== logo header part==============
        JLabel logo = new JLabel(backGroundImage1);
        JPanel logoPlanel = new JPanel();
        logoPlanel.setLayout(new GridLayout());
        logoPlanel.add(logo);
        
        //=========sign in header part ==========
        signIn = new JButton("Sign in");
        signIn.setPreferredSize(new Dimension(200,100));
        signIn.setFocusable(false);
        signIn.setFont(new Font("Times new Romen", Font.BOLD,20));
        signIn.addActionListener(this);
        
        JPanel signInPanel = new JPanel();
        signInPanel.setLayout(new GridLayout());
        signInPanel.add(signIn);
        
        //======= header panel ===========
        headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(300,100));
        headerPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        headerPanel.setBackground(new Color(222,226,255));
        headerPanel.setLayout(new BorderLayout());
        
        
        // ========= header adding components=====
        headerPanel.add(logoPlanel, BorderLayout.WEST);
        headerPanel.add(signInPanel, BorderLayout.EAST);
        
       
        //----------- body event part ----------------------
        JLabel eventIcon = new JLabel();
//        eventIcon.setText("Welcome to our event part");
        eventIcon.setForeground(Color.black);
        eventIcon.setFont(new Font("Times new Romen", Font.BOLD,15));
//        eventIcon.setHorizontalAlignment(JLabel.LEADING);
//        eventIcon.setVerticalAlignment(JLabel.TOP);
        eventIcon.setHorizontalTextPosition(JLabel.CENTER);
//        eventIcon.setVerticalTextPosition(JLabel.CENTER);
        
        eventIcon.setIcon(event);
//        eventIcon.setBounds(100,-30, 400, 400);
        
        
        
        //================= Dj picture part====================
        ImageIcon Dj = new ImageIcon (new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\DjCover.jpg").getImage().getScaledInstance(512, 340, Image.SCALE_DEFAULT));
        JLabel DjIcon = new JLabel();
        DjIcon.setIcon(Dj);
        
        //=========== food picture part =====================
        ImageIcon food = new ImageIcon (new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\foodService3-2.jpg").getImage().getScaledInstance(512, 340, Image.SCALE_DEFAULT));
        JLabel foodServiceIcon = new JLabel();
        foodServiceIcon.setIcon(food);
        
        //======= body panel ===========
        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());
        body.setPreferredSize(new Dimension(300,900));
        body.setBackground(Color.yellow);
        
        //----------- body panel------------------
        bodyPanel = new JPanel();
        bodyPanel.setLayout(new GridLayout());
        bodyPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        bodyPanel.setPreferredSize(new Dimension(300,600));
        bodyPanel.setBackground(new Color(221,167,123));
        
        //----------- body footer--------------------
        bodyFooter = new JPanel();
        bodyFooter.setLayout(new GridLayout(1,1));
        bodyFooter.setBorder(BorderFactory.createRaisedBevelBorder());
        bodyFooter.setPreferredSize(new Dimension(200,200));
        bodyFooter.setBackground(new Color(221,167,123));
         
        // ======= body Event ================
        JPanel bodyEvent = new JPanel();
        bodyEvent.setPreferredSize(new Dimension(200,200));
        bodyEvent.setBorder(BorderFactory.createRaisedBevelBorder());
        bodyEvent.setBackground(new Color(221,167,123));
        bodyEvent.setLayout(new BorderLayout());
        
        
        JPanel eventWrite = new JPanel();
        eventWrite.setPreferredSize(new Dimension(200,100));
        eventWrite.setBorder(BorderFactory.createLoweredBevelBorder());
        eventWrite.setBackground(new Color(20,30,40));
        eventWrite.setLayout(new GridLayout());
        
        JLabel eventLabel = new JLabel("Event");
        eventLabel.setFont(new Font("Lucida Console", Font.BOLD,25));
        eventLabel.setHorizontalAlignment(JLabel.CENTER);
        eventLabel.setHorizontalAlignment(JLabel.CENTER);
        eventLabel.setForeground(Color.white);
        
        eventWrite.add(eventLabel);
        
        bodyEvent.add(eventWrite, BorderLayout.NORTH);
        bodyEvent.add(eventIcon, BorderLayout.CENTER);
        
        //=========== body Dj ==================
        JPanel bodyDj = new JPanel();
        bodyDj.setLayout(new BorderLayout());
        bodyDj.setBorder(BorderFactory.createRaisedBevelBorder());
        bodyDj.setPreferredSize(new Dimension(200,200));
        bodyDj.setBackground(new Color(221,167,123));
        
        JPanel DjWrite = new JPanel();
        DjWrite.setBorder(BorderFactory.createLoweredBevelBorder());
        DjWrite.setPreferredSize(new Dimension(200,100));
        DjWrite.setBackground(new Color(20,30,40));
        DjWrite.setLayout(new GridLayout());
        
        JLabel DjLabel = new JLabel("Dj");
        DjLabel.setFont(new Font("Lucida Console", Font.BOLD,25));
        DjLabel.setHorizontalAlignment(JLabel.CENTER);
        DjLabel.setHorizontalAlignment(JLabel.CENTER);
        DjLabel.setForeground(Color.white);
        
        DjWrite.add(DjLabel);
        bodyDj.add(DjWrite, BorderLayout.NORTH);
        bodyDj.add(DjIcon, BorderLayout.CENTER);
        
        //===========body food ==================
        JPanel bodyFood = new JPanel();
        bodyFood.setPreferredSize(new Dimension(200,200));
        bodyFood.setBorder(BorderFactory.createRaisedBevelBorder());
        bodyFood.setLayout(new BorderLayout());
        bodyFood.setBackground(new Color(221,167,123));
        
        JPanel FoodWrite = new JPanel();
        FoodWrite.setPreferredSize(new Dimension(200,100));
        FoodWrite.setBorder(BorderFactory.createLoweredBevelBorder());
        FoodWrite.setBackground(new Color(20,30,40));
        FoodWrite.setLayout(new GridLayout());
        
        JLabel FoodLabel = new JLabel("Food");
        FoodLabel.setFont(new Font("Lucida Console", Font.BOLD,25));
        FoodLabel.setHorizontalAlignment(JLabel.CENTER);
        FoodLabel.setHorizontalAlignment(JLabel.CENTER);
        FoodLabel.setForeground(Color.white);
        
        FoodWrite.add(FoodLabel);
        bodyFood.add(FoodWrite, BorderLayout.NORTH);
        bodyFood.add(foodServiceIcon, BorderLayout.CENTER);
        
        //========= body about us==========
        JPanel bodyAbout = new JPanel();
        bodyAbout.setPreferredSize(new Dimension(100,100));
        bodyAbout.setBorder(BorderFactory.createLoweredBevelBorder());
        bodyAbout.setLayout(null);
        bodyAbout.setBackground(new Color(221,167,123));
        
        
        // =========== image for about us===================
         ImageIcon aboutIcon = new ImageIcon(new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\about.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        
         //=========== label for aout us =================
         JLabel aboutLabel = new JLabel();
         aboutLabel.setText("About Us");
         aboutLabel.setFont(new Font("Times new Romen", Font.BOLD,25));
         aboutLabel.setBounds(270, -20, 1000, 100);
         aboutLabel.setIcon(aboutIcon);
         
         JLabel aboutUs = new JLabel();
         aboutUs.setText("A very nice and well designed event Venue, comprising of a conference hall, bar and cinema ");
         aboutUs.setFont(new Font("Times new Romen", Font.BOLD,14));
         aboutUs.setBounds(10, 10, 1000, 110);
         
         JLabel continue1 = new JLabel("for entertainment purposes of the Visitors. It is very suitable for ceremonial and wedding ");
         continue1.setFont(new Font("Times new Romen", Font.BOLD,14));
         continue1.setBounds(10, 40, 1000, 110);
         
         JLabel continue2 = new JLabel("parties. we also have best Dj for entertaining the events and well prepare dish or food to");
         continue2.setFont(new Font("Times new Romen", Font.BOLD,14));
         continue2.setBounds(10, 70, 1000, 110);
         
         JLabel continue3 = new JLabel("satisfy customers needs and wants thank you.");
         continue3.setFont(new Font("Times new Romen", Font.BOLD,14));
         continue3.setBounds(10, 100, 1000, 110);
         
         bodyAbout.add(aboutLabel);
         bodyAbout.add(continue1);
         bodyAbout.add(continue2);
         bodyAbout.add(continue3);
         bodyAbout.add(aboutUs);
        
        //========= body Contact us==========
        JPanel bodyContact = new JPanel();
        bodyContact.setPreferredSize(new Dimension(100,100));
        bodyContact.setBorder(BorderFactory.createLoweredBevelBorder());
        bodyContact.setBackground(new Color(221,167,123));
        bodyContact.setLayout(null);
        
        // =========== image for contact us ===============
        ImageIcon callIcon = new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\call.png");
        ImageIcon whatAppIcon = new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\whatsapp.png");
        ImageIcon emailIcon = new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\email.png");
        ImageIcon contactIcon = new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\contact.png");
        
        // ========= labels for contact  us
        JLabel contactNo = new JLabel();
        contactNo.setText("Contact Us");
        contactNo.setFont(new Font("Times new Romen", Font.BOLD,25));
        contactNo.setBounds(270, -30, 1000, 100);
        contactNo.setIcon(contactIcon);
        
        JLabel phoneNo = new JLabel();
        phoneNo.setText("08161652400");
        phoneNo.setFont(new Font("Times new Romen", Font.BOLD,22));
        phoneNo.setBounds(40, 20, 1000, 100);
        phoneNo.setIcon(callIcon);
        
        JLabel whatAppNo = new JLabel();
        whatAppNo.setText("08161652400");
        whatAppNo.setFont(new Font("Times new Romen", Font.BOLD,22));
        whatAppNo.setBounds(40, 110, 1000, 100);
        whatAppNo.setIcon(whatAppIcon);
        
        JLabel emailNo = new JLabel();
        emailNo.setText("AbdullahiAbu@gmail.com");
        emailNo.setFont(new Font("Times new Romen", Font.BOLD,22));
        emailNo.setBounds(300, 30, 1000, 100);
        emailNo.setIcon(emailIcon);
        
        bodyContact.add(contactNo);
        bodyContact.add(phoneNo);
        bodyContact.add(whatAppNo);
        bodyContact.add(emailNo);
        
        bodyFooter.add(bodyAbout);
        bodyFooter.add(bodyContact);

         // ========= body adding components=====
        bodyPanel.add(bodyEvent);
        bodyPanel.add(bodyDj);
        bodyPanel.add(bodyFood);
         
        body.add(bodyPanel, BorderLayout.CENTER);
//        body.add(bodyFooter, BorderLayout.SOUTH);
        
        
     // --------- Frame of the project ----------
        JScrollPane scrollpane = new JScrollPane();
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        homePage = new JFrame("Home Page");
        homePage.setIconImage(backGroundImage1.getImage());
        homePage.setSize(1200,650);
        homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homePage.setLocationRelativeTo(null);
        homePage.setLayout(new BorderLayout());       
        homePage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        homePage.add(headerPanel, BorderLayout.NORTH);
        homePage.add(body, BorderLayout.CENTER);
        homePage.add(bodyFooter, BorderLayout.SOUTH);
//        bodyPanel.add(scrollpane);
//        homePage.add(scrollpane);
        homePage.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == signIn){
        homePage.dispose();
        try {
			new login();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        }
        
    }
    
}
