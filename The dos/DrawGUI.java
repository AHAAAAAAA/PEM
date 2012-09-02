////////////////////////////////////////////////////
///Ahmed Hussain Almutawa//////////////////////////
//////Candidate Number: 003652-066//////////////////
///Personal Expense Manager//////////////////////
///////////////////////////////////////////////////
///March 23, 2011///////////////////////////////
//////AbdulRahman Kanoo International School/////
//////////////////////////////////////////////////
///IDE: BlueJ, Windows 7////////////////////////
//////To simplify expense managing and budgets////
////////////////////////////////////////////////




import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.accessibility.*;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class DrawGUI extends JFrame
{
    private JTabbedPane tabbedPane;
    private JPanel expense;
    JScrollPane ListBR;
    JScrollPane scrP;
    JTextArea txtArea;
    
    //expenses TAB
    //Buttons
    JButton btnAddit = new JButton ("Add");
    JButton btnModit = new JButton ("Budget ");
    JButton btnClearS = new JButton ("Clear "); 
    JButton btnFixit = new JButton ("Fixed Income ");
    JButton btnDeleteit = new JButton ("Delete");
    JButton btnSearchS = new JButton ("Search ");
    JButton btnSortS = new JButton ("Sort ");
    JButton btnDisplayAllS = new JButton ("Display All");
    JButton btnSaveS = new JButton ("Save ");
    JLabel lblExpense = new JLabel ("Expense: ", JLabel.LEFT);
    JLabel lblValue = new JLabel ("Value: ", JLabel.LEFT);
    JTextField txtExpense = new JTextField();
    JTextField txtValue = new JTextField();
    JTextField txtDisplayFieldS = new JTextField();
    
    
 
    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public DrawGUI()
    {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);
        
        
         txtArea = new JTextArea() ;
         txtArea.setLineWrap(false); // allow line wrap
         txtArea.setEditable(false); // it does not allow editing
         scrP= new JScrollPane (txtArea);
         scrP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        //Create the Tab Pages
          createexpense();
                   
       //Create a tabbed pane
       
       tabbedPane = new JTabbedPane();
       tabbedPane.addTab("Expenses",expense);
       topPanel.add(tabbedPane,BorderLayout.CENTER);
       
       //Set Console Features
       setTitle("Expense manager");
       setSize(550,600);
       setResizable(false);
       setVisible(true);
    }
       
       public void createexpense()
       {
            expense = new JPanel();
            expense.setLayout(null);
            
            //ADD Components
          
            expense.add(lblExpense);
            expense.add(lblValue);   
            expense.add(txtExpense);
            expense.add(txtValue);
            expense.add(txtDisplayFieldS);
            expense.add(btnAddit);
            expense.add(btnModit);
            expense.add(btnClearS);
            expense.add(btnDeleteit);
            expense.add(btnFixit);
            expense.add(btnSortS);
            expense.add(btnSearchS);
            expense.add(btnDisplayAllS);
            expense.add(btnSaveS);
              
            //Set Bounds
            lblExpense.setBounds(200,10,120,20);
            lblValue.setBounds(350,10,120,20);                       
            txtExpense.setBounds(200,30,100,25);
            txtValue.setBounds(350,30,100,25);
            txtDisplayFieldS.setBounds(200,60,300,400);
            btnAddit.setBounds(50,50,125,30);
            btnModit.setBounds (50,100,125,30);
            btnDeleteit.setBounds(50,150,125,30);
            btnClearS.setBounds(50,200,125,30);
            btnDeleteit.setBounds(50,250,125,30);
            btnFixit.setBounds(50,300,125,30);
            btnSortS.setBounds(50,350,125,30);
            btnSearchS.setBounds(50,400,125,30);
            btnDisplayAllS.setBounds(50,450,125,30);
            btnSaveS.setBounds(50,500,125,30);
        }
      }