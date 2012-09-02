import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI extends JFrame
{
    private JTabbedPane tabbedPane;
    private JPanel Welcome;
    private JPanel Members;
    private JPanel TeamDisplay;
    
    // Welcome TAB
    
    JLabel lblhello = new JLabel ("Welcome", JLabel.LEFT);
    JLabel lbltitle = new JLabel ("AK United", JLabel.LEFT);
    JLabel lblregis = new JLabel ("Registration System", JLabel.LEFT);
    
    
    // Members TAB  
    
    JButton btnAddM = new JButton ("Add");
    JButton btnDeleteM= new JButton("Delete");
    JButton btnDisplayM = new JButton ("Display All");
    JButton btnClearM = new JButton ("Clear");
    JButton btnSearchM = new JButton ("Search");
    JButton btnSaveM = new JButton("Save");
    
    
    
    JLabel  lbltitle2 = new JLabel ("Members", JLabel.LEFT);
    JLabel  lblNameM = new JLabel ("Name", JLabel.LEFT);
    JLabel  lblIDM = new JLabel ("Member ID", JLabel.LEFT);
    JLabel  lblMobileM = new JLabel ("Mobile", JLabel.LEFT);
    JLabel  lblEmailM = new JLabel ("Email", JLabel.LEFT);
    JLabel  lblAddressM = new JLabel ("Address", JLabel.LEFT);
    JLabel  lblNationalityM = new JLabel ("Nationality", JLabel.LEFT);
    JLabel  lblGameM = new JLabel ("Game", JLabel.LEFT);
    JTextField  txtNameM = new JTextField();
    JTextField  txtIDM = new JTextField();
    JTextField  txtMobileM = new JTextField();
    JTextField  txtEmailM = new JTextField();
    JTextField  txtAddressM = new JTextField();
    JTextField  txtNationalityM = new JTextField();
    
    public JComboBox LSTGameM = new JComboBox();
    String[] GListM = {"Football, Men", "Football, Youth", "Football, Kids", "Basketball, Men", "Basketball, Youth", "Basketball, Kids", "Volleyball, Men", "Volleyball, Youth", "Volleyball, Kids", "Handball, Men", "Handball, Youth", "Handball, Kids", "Tennis, Men", "Tennis, Youth", "Tennis, Kids"};


    
    //Team Display TAB
    
    JButton btnDisplayD = new JButton ("Display");
    
   
    JLabel lbltitle3 = new JLabel ("Team Display", JLabel.LEFT);
    JLabel lblGameD = new JLabel ("Game Name", JLabel.LEFT);
    
    public JComboBox LSTGameD = new JComboBox();
    String[] GListD = {"Football, Men", "Football, Youth", "Football, Kids", "Basketball, Men", "Basketball, Youth", "Basketball, Kids", "Volleyball, Men", "Volleyball, Youth", "Volleyball, Kids", "Handball, Men", "Handball, Youth", "Handball, Kids", "Tennis, Men", "Tennis, Youth", "Tennis, Kids"};

    
    
    
    
    public GUI()
    {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        getContentPane().add(topPanel);
        
        //Create the Tab Pages
          createWelcome();
          createMembers();
          createTeamDisplay();
          
       //Create a tabbed pane
       
       tabbedPane = new JTabbedPane();
       tabbedPane.addTab("Home",Welcome);
       tabbedPane.addTab("Members",Members);
       tabbedPane.addTab("Team Display",TeamDisplay);
       topPanel.add(tabbedPane,BorderLayout.CENTER);
       
       //Set Console Features
       setTitle("AK United Registration System");
       setSize(600,600);
       setResizable(false);
       setVisible(true);
    }
       
       public void createWelcome()
       {
            Welcome = new JPanel();
            Welcome.setLayout(null);
            
            //ADD Components
            Welcome.add(lblhello);
            Welcome.add(lbltitle);
            Welcome.add(lblregis);
            
            //Set Bounds
            lblhello.setBounds(160,50,500,70);
            lblhello.setFont(new Font("Serif", Font.PLAIN,70));
            lblhello.setForeground(Color.red);
         
            lbltitle.setBounds(190,150,500,50);
            lbltitle.setFont(new Font("Serif", Font.PLAIN,50));
            lbltitle.setForeground(Color.blue);
            
            lblregis.setBounds(178,220,500,50);
            lblregis.setFont(new Font("Serif", Font.PLAIN,30));
            lblregis.setForeground(Color.black);
            
        }

    
       
        
        //The Member panel is created is this method
        public void createMembers()
        {
            Members= new JPanel();
            Members.setLayout(null);
            
            Members.add(lbltitle2);
            Members.add(lblNameM);
            Members.add(lblIDM);
            Members.add(lblMobileM);
            Members.add(lblEmailM);
            Members.add(lblAddressM);
            Members.add(lblNationalityM);
            Members.add(lblGameM);
            Members.add(txtNameM);
            Members.add(txtIDM);
            Members.add(txtMobileM);
            Members.add(txtEmailM);
            Members.add(txtAddressM);
            Members.add(txtNationalityM);
            
            for(int x = 0; x<GListM.length;x++)
            LSTGameM.addItem(GListM[x]);
            Members.add(LSTGameM);
            
            Members.add(btnAddM);
            Members.add(btnDeleteM);
            Members.add(btnDisplayM);
            Members.add(btnClearM);
            Members.add(btnSearchM);
            Members.add(btnSaveM);

            
            //Set Bounds
            lbltitle2.setBounds(150,0,500,100);
            lbltitle2.setFont(new Font("Serif", Font.PLAIN,72));
            lbltitle2.setForeground(Color.red);
            
            lblIDM.setBounds(10,130,500,20);
            lblIDM.setFont(new Font("Serif", Font.PLAIN,14));
            lblIDM.setForeground(Color.black);
            txtIDM.setBounds(80,130,200,20);
            
            lblNameM.setBounds(10,155,500,20);
            lblNameM.setFont(new Font("Serif", Font.PLAIN,14));
            lblNameM.setForeground(Color.black);
            txtNameM.setBounds(80,155,200,20);
            
            lblMobileM.setBounds(10,180,500,20);
            lblMobileM.setFont(new Font("Serif", Font.PLAIN,14));
            lblMobileM.setForeground(Color.black);
            txtMobileM.setBounds(80,180,200,20);
            
            lblEmailM.setBounds(10,205,500,20);
            lblEmailM.setFont(new Font("Serif", Font.PLAIN,14));
            lblEmailM.setForeground(Color.black);
            txtEmailM.setBounds(80,205,200,20);
            
            lblAddressM.setBounds(10,230,500,20);
            lblAddressM.setFont(new Font("Serif", Font.PLAIN,14));
            lblAddressM.setForeground(Color.black);
            txtAddressM.setBounds(80,230,200,20);
            
            lblNationalityM.setBounds(10,255,500,20);
            lblNationalityM.setFont(new Font("Serif", Font.PLAIN,14));
            lblNationalityM.setForeground(Color.black);
            txtNationalityM.setBounds(80,255,200,20);
            
            lblGameM.setBounds(10,280,500,20);
            lblGameM.setFont(new Font("Serif", Font.PLAIN,14));
            lblGameM.setForeground(Color.black);
            LSTGameM.setBounds(80,280,200,20);
            
            
            btnAddM.setBounds(10,375,150,30);
            btnDeleteM.setBounds(210,375,150,30);
            btnDisplayM.setBounds(410,375,150,30);
            btnClearM.setBounds(10,420,150,30);
            btnSearchM.setBounds(210,420,150,30);
            btnSaveM.setBounds(410,420,150,30);
            
            
        }
        
        //The Team Display panel is created in this method
        public void createTeamDisplay()
        {
            TeamDisplay = new JPanel();
            TeamDisplay.setLayout(null);
            
            TeamDisplay.add(lbltitle3);
            TeamDisplay.add(lblGameD);
            
            for(int z = 0; z < GListD.length; z++)
            LSTGameD.addItem(GListD[z]);
            TeamDisplay.add(LSTGameD);
            
            TeamDisplay.add(btnDisplayD);
           
           
            //Set Bounds
         
            lbltitle3.setBounds(130,20,500,100);
            lbltitle3.setFont(new Font("Serif", Font.PLAIN,60));
            lbltitle3.setForeground(Color.red);
            
            lblGameD.setBounds(10,200,500,20);
            lblGameD.setFont(new Font("Serif", Font.PLAIN,14));
            lblGameD.setForeground(Color.black);
            LSTGameD.setBounds(90,200,150,20);
            
            btnDisplayD.setBounds(80,250,100,20);

                      
        }
  
    }
    