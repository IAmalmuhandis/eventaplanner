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
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.border.EmptyBorder;

/**
 *
 * @author usman
 */
public class CustomerHomePage implements MouseListener {
   private ImageIcon backGroundImage1; 
   private ImageIcon backGroundImage2; 
   private JFrame CustomerhomePage;
   private JPanel headerPanel;
   private JPanel bodyPanel;
   private JButton logout;
   private JPanel eventPanel;
   private JPanel DjPanel;
   private JPanel foodServicePanel;
   private JPanel viewPanel;
   private JPanel fooServePanel;
   private JPanel viewServicePanel;
   
     
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
   ImageIcon Dj2;

    public CustomerHomePage()  {
 
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
                    CustomerhomePage.dispose();
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
        centerHeader.setBackground(new Color(21,122,110));
     
        
        JLabel welcomeLabel = new JLabel("Welcome to Home page");
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
    
        JLabel action = new JLabel("What would you like to do today");
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
        bodyPanel.setLayout(new GridLayout(2,2,20,20));
        bodyPanel.setBorder(new EmptyBorder(60, 60, 60, 60));
        bodyPanel.setBackground(new Color(221,167,123));
        
        //-------------- Event panel -------------
        eventIcon = new ImageIcon (new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\dining_table3.jpg").getImage().getScaledInstance(522, 640, Image.SCALE_DEFAULT));
        eventIcon2 = new ImageIcon ("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\eventIcon.png");
        

        eventPanel = new JPanel();
        eventPanel.setBackground(Color.BLUE);
        eventPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        eventPanel.setLayout(new GridLayout());
        eventPanel.setBackground(new Color(200,80,10));
        eventPanel.setPreferredSize(new Dimension(200,200));
        eventPanel.addMouseListener(this);
    
        event = new JLabel("Add Event Center/Food Service/DJ");
//        event.setIcon(eventIcon);
        event.setIcon(eventIcon2);
        event.setFont(new Font("Times new Roman", Font.PLAIN,30));
        event.setHorizontalTextPosition(JLabel.RIGHT); 
        event.setVerticalTextPosition(JLabel.CENTER);
        event.setVerticalAlignment(JLabel.CENTER);
        event.setHorizontalAlignment(JLabel.CENTER);
        event.setForeground(Color.black);
    
        eventPanel.add(event);
        
        //-------------- Dj panel -------------
        DjIcon = new ImageIcon (new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\DjCover2.jpg").getImage().getScaledInstance(562, 640, Image.SCALE_DEFAULT));
        Dj2 = new ImageIcon ("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\djIcon.png");

        
        DjPanel = new JPanel();
        DjPanel.setBackground(Color.cyan);
        DjPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder()); 
        DjPanel.setLayout(new GridLayout());
        DjPanel.setBackground(new Color(200,80,10));
        DjPanel.setPreferredSize(new Dimension(200,200));
        DjPanel.addMouseListener(this);
    
        Dj = new JLabel("Add DJ");
//        Dj.setIcon(DjIcon);
        Dj.setIcon(Dj2);
        Dj.setFont(new Font("Times new Roman", Font.PLAIN,30));
        Dj.setHorizontalTextPosition(JLabel.RIGHT); 
        Dj.setVerticalTextPosition(JLabel.CENTER);
        Dj.setVerticalAlignment(JLabel.CENTER);
        Dj.setHorizontalAlignment(JLabel.CENTER);
        Dj.setBackground(Color.black);
        
        DjPanel.add(Dj);
        
        //-------------- food serves panel -------------
        foodIcon = new ImageIcon (new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\image\\foodservice2.jpg").getImage().getScaledInstance(522, 640, Image.SCALE_DEFAULT));
        foodIcon2 = new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\foodIccon.png");
        
        
        foodServicePanel = new JPanel();
        foodServicePanel.setBackground(Color.yellow);
        
        foodServicePanel = new JPanel();
        foodServicePanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        foodServicePanel.setBackground(Color.cyan);
        foodServicePanel.setLayout(new GridLayout());
        foodServicePanel.setBackground(new Color(200,80,10));
        foodServicePanel.setPreferredSize(new Dimension(200,200));
        foodServicePanel.addMouseListener(this);
    
        foodServe = new JLabel("Add Food Serivce");
//        foodServe.setIcon(foodIcon);
        foodServe.setIcon(foodIcon2);
        foodServe.setFont(new Font("Times new Roman", Font.PLAIN,30));
        foodServe.setHorizontalTextPosition(JLabel.RIGHT); 
        foodServe.setVerticalTextPosition(JLabel.CENTER);
        foodServe.setVerticalAlignment(JLabel.CENTER);
        foodServe.setHorizontalAlignment(JLabel.CENTER);
        foodServe.setBackground(Color.BLACK);
        
        foodServicePanel.add(foodServe);
        
        //-------------- view serves panel -------------
        viewIcon = new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Event_Planning\\src\\icon\\cartIcon.png");
        
        viewServicePanel = new JPanel();
        viewServicePanel.setBackground(Color.black);
       viewServicePanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        viewServicePanel.setLayout(new GridLayout());
        viewServicePanel.setBackground(new Color(200,80,10));
        viewServicePanel.setPreferredSize(new Dimension(200,200));
        viewServicePanel.addMouseListener(this);
    
        viewServe = new JLabel("View Carts");
        viewServe.setIcon(viewIcon);
        viewServe.setFont(new Font("Times new Roman", Font.PLAIN,30));
        viewServe.setHorizontalTextPosition(JLabel.RIGHT); 
        viewServe.setVerticalTextPosition(JLabel.CENTER);
        viewServe.setVerticalAlignment(JLabel.CENTER);
        viewServe.setHorizontalAlignment(JLabel.CENTER);
        viewServe.setBackground(Color.black);
        
        viewServicePanel.add(viewServe);
        
        
        bodyPanel.add(eventPanel);
        bodyPanel.add(viewServicePanel);
        
        //============ frame of the customer ===============
        CustomerhomePage = new JFrame("Customer Home page");
        CustomerhomePage = new JFrame("Home Page");
        CustomerhomePage.setIconImage(backGroundImage1.getImage());
        CustomerhomePage.setSize(1200,650);
        CustomerhomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CustomerhomePage.setLocationRelativeTo(null);
//        CustomerhomePage.setResizable(false);
        CustomerhomePage.setLayout(new BorderLayout());       
        CustomerhomePage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        CustomerhomePage.add(headerPanel, BorderLayout.NORTH);
        CustomerhomePage.add(bodyPanel, BorderLayout.CENTER);
             
        CustomerhomePage.setVisible(true);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== foodServicePanel){
               foodServicePanel.setBackground(Color.red); 
           }
        
         if(e.getSource()== DjPanel){
               DjPanel.setBackground(Color.red);
           }
           
           if(e.getSource()== eventPanel){
               eventPanel.setBackground(Color.red);
           }
           
           if(e.getSource()== viewServicePanel){
               viewServicePanel.setBackground(Color.red);
           }
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==eventPanel){
        CustomerhomePage.dispose();
        try {
			new CutomerEventPage();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        }
        if(e.getSource()==viewPanel){
        CustomerhomePage.dispose();
        try {
			new CustomerViewPage();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        }
       
       
        if(e.getSource() == viewServicePanel){
        CustomerhomePage.dispose();
        try {
			new CustomerViewPage();
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

           if(e.getSource()== foodServicePanel){
               foodServicePanel.setBackground(Color.green);
              
           }
           if(e.getSource()== DjPanel){
               DjPanel.setBackground(Color.green);
           }
           
           if(e.getSource()== eventPanel){
               eventPanel.setBackground(Color.green);
           }
           
           if(e.getSource()== viewServicePanel){
               viewServicePanel.setBackground(Color.green);
           }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
      if(e.getSource()== foodServicePanel){
               foodServicePanel.setBackground(new Color(200,80,10));
              
           }
           if(e.getSource()== DjPanel){
               DjPanel.setBackground(new Color(200,80,10));
           }
           
           if(e.getSource()== eventPanel){
               eventPanel.setBackground(new Color(200,80,10));
           }
           
           if(e.getSource()== viewServicePanel){
               viewServicePanel.setBackground(new Color(200,80,10));
           }

    }
    
}
