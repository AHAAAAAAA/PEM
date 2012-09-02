/*
 * ----------Ali Ahmed Ali Ahmed Mohamed----------
 * ----Abdul Rahman Kanoo International School----
 * -----------Computer Science: Dossier-----------
 * -------------------May: 2011-------------------
 */


import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;


public class Main extends EasyApp implements ActionListener
{
    public static GUI GUI = new GUI();
   
    // Delcaring the arrays
        MemberClass[] MemberArray = new MemberClass [10000];              //Array that saves the members info
        DisplayClass[] DisplayArray = new DisplayClass [10000];                    //Array that displays a specific chosen team
    
        
    //Output Streams
    ObjectOutputStream MemberOutput = null;
    ObjectOutputStream DisplayOutput = null;
    
    //Input Streams
    ObjectInputStream MemberInput = null;
    ObjectInputStream DisplayInput = null;
         
         
  
    //Initializing Variables for MEMBER TAB
    String NameM = null;             //Member's Name 
    int IDM = 0;                   //Member's CPR (Also ID)
    String MobileM = null;        //Member's mobile number
    String EmailM = null;         //Member's email
    String AddressM = null;         //Member's address
    String NationalityM = null;      //Member's nationality
    String LSTGameM = null;            //Member's chosen game
    int MemberSize = 0;             // Number of Members exist
    
    
    //Initializing Variables for Display TAB
    String GameD = null;            //Game Name
    int DisplaySize = 0;            //number of records
    String Dis[] = new String [9999];            //To save member's names in it
    
    
    public Main()
    {
        GUI.btnAddM.addActionListener(this);
        GUI.btnClearM.addActionListener(this);
        GUI.btnDeleteM.addActionListener(this);
        GUI.btnDisplayM.addActionListener(this);
        GUI.btnSearchM.addActionListener(this);
        GUI.btnSaveM.addActionListener(this);
        
        GUI.btnDisplayD.addActionListener(this);

        
        LoadFiles();            
    }
    
    public void actionPerformed (ActionEvent e)
    {
       
        //==Member Tab==
        
        if (e.getSource() == GUI.btnAddM)
        {
            AddM();
        }
        
        if (e.getSource() == GUI.btnClearM)
        {
            ClearM();
        }
        
        if (e.getSource() == GUI.btnDeleteM)
        {
           DeleteM();
        }
        
        if (e.getSource() == GUI.btnDisplayM)
        {
            DisplayM();
        }
        
        if (e.getSource() == GUI.btnSearchM)
        {
            SearchM();
        }
        
        if (e.getSource() == GUI.btnSaveM)
        {
            SaveM();
        }
        
        //==Display Tab==
        
         if (e.getSource() == GUI.btnDisplayD)
        {
            DisplayD();
        }
        
    }
        
        
     
    
    //==MEMBERS TAB METHODS==

    //==ADD A MEMBER==

 public void AddM()
    {
        boolean MemberFound = false;
        NameM = GUI.txtNameM.getText();
        MobileM = GUI.txtMobileM.getText();
        EmailM = GUI.txtEmailM.getText();
        AddressM = GUI.txtAddressM.getText();
        NationalityM = GUI.txtNationalityM.getText();
   
        
        if( (NameM.equals("")) || (MobileM.equals("")) || (EmailM.equals("")) || (AddressM.equals("")) || (NationalityM.equals("")) )    //If one or all the fields are empty      
        
        {
            output("You Must Fill All the Fields to Register a Member");
            MemberFound = true;
        }
            
        else
        if (!(NameM.equals("")) && !(MobileM.equals("")) && !(EmailM.equals("")) && !(AddressM.equals("")) && !(NationalityM.equals("")) )      //If all the fields are filled
        
        {
             for(int x = 0; x < ( NameM.length() ); x++)
             if(Character.isDigit(NameM.charAt(x)))                             //if field consists of integers (type check)
             {
                  MemberFound = true;
                  output("Use Letters Only for the Name");
             }
             
             
             int o = 0;
                for (int e = 0; e < MemberSize; e++)
                {
                    if (MemberArray[e].getIDM()>o)
                    {
                        o = MemberArray[e].getIDM();
                    }
                }
             IDM = o + 1;
             
             
             
             int GameM = GUI.LSTGameM.getSelectedIndex();
             if (GameM == 0)
             {
                 LSTGameM = "Football, Men";
             }
             else
             if (GameM == 1)
             {
                 LSTGameM = "Football, Youth";
             }
             else
             if (GameM == 2)
             {
                 LSTGameM = "Football, Kids";
             }
             else
             if (GameM == 3)
             {
                 LSTGameM = "Basketball, Men";
             }
             else
             if (GameM == 4)
             {
                 LSTGameM = "Basketball, Youth";
             }
             else
             if (GameM == 5)
             {
                 LSTGameM = "Basketball, Kids";
             }
             else
             if (GameM == 6)
             {
                 LSTGameM = "Volleyball, Men";
             }
             else
             if (GameM == 7)
             {
                 LSTGameM = "Volleyball, Youth";
             }
             else
             if (GameM == 8)
             {
                 LSTGameM = "Volleyball, Kids";
             }
             else
             if (GameM == 9)
             {
                 LSTGameM = "Handball, Men";
             }
             else
             if (GameM == 10)
             {
                 LSTGameM = "Handball, Youth";
             }
             else
             if (GameM == 11)
             {
                 LSTGameM = "Handball, Kids";
             }
             else
             if (GameM == 12)
             {
                 LSTGameM = "Tennis, Men";
             }
             else
             if (GameM == 13)
             {
                 LSTGameM = "Tennis, Youth";
             }
             else
                 LSTGameM = "Tennis, Kids";
                          
        }


                

     
        if (MemberFound == false)
        {
            MemberArray[MemberSize] = new MemberClass(NameM, IDM, MobileM, EmailM, AddressM, NationalityM, LSTGameM);           //Adds the Member to the array
            MemberSize = MemberSize+1;                                                                  //Increases the number of Member by 1
            output("You Have Successfully Registered The Member " + NameM + " !");
            GUI.txtIDM.setText(IDM + "");
        }
    }

    
    
    /*
    //==DELETE A Member==
    
    public void DeleteM()
    {
        boolean IDMF = false;
        
        for (int x = 0; x < (IDM.length()); x++)
                if (Character.isDigit(IDM.charAt(x)))                             //if field consists of integers (type check)
                {
                    IDMF = true;
                    output("Use Letters Only for the CPR");
                }
        
        int index = -1;
      
        //Validation
  
   if(IDM.equals(""))               //If field is empty
   {
       output("CPR Field is Empty, Please Enter a CPR to Complete Process");
   }

 
    
    else
    {
        for ( int x = 0; x < MemberSize ; x++)
        {
            if (IDM.equals(MemberArray[x].getIDM()))
            {
              index = x;  
              IDMF = true;
                for (int y = index; y < MemberSize-1; y++)
                {
                MemberArray[y].setIDM(MemberArray[y+1].getIDM());               //Shifts up the records by a factor of 1 position
                MemberArray[y].setNameM(MemberArray[y+1].getNameM());
                MemberArray[y].setMobileM(MemberArray[y+1].getMobileM());
                MemberArray[y].setEmailM(MemberArray[y+1].getEmailM());
                MemberArray[y].setAddressM(MemberArray[y+1].getAddressM());
                MemberArray[y].setNationalityM(MemberArray[y+1].getNationalityM());
                MemberArray[y].setGListM(MemberArray[y+1].getGListM());
                }            
                output("You Have Successfully Deleted the Member from the System");
               
               
               MemberSize = MemberSize -1;     //Decreases the number of members in the club by 1
                            
            }
        }
        if (IDMF == false)
        {  
         output("The CPR You Entered Cannot be Found"); 
        }
    }
}
    */
   
   
   
   
   
   
   public void DeleteM()


    {
        boolean MemberDFound = false;
        try 
    {
        IDM = Integer.parseInt((GUI.txtIDM.getText()));
    }
        catch (NumberFormatException err)
        {
            output("Invalid");
        }
        
        int index = -1;
      
        //    --Validation for Delete--
  
   if(IDM == 0)               //If field is empty
   {
       output("Please Enter a CPR");
   }
   else if ((IDM < 0) || (IDM > 9999))    //If number is out of range
   {
       output("Enter a Valid CPR");
   }
 
    
    
    
    
    else
    {
         for ( int x = 0; x < MemberSize ; x++)
        {
           if (IDM == MemberArray[x].getIDM())
            {
              index = x;  
              MemberDFound = true;
                for (int y = index; y < MemberSize-1; y++)
                {
                MemberArray[y].setIDM(MemberArray[y+1].getIDM());               //Shifting up the records by 1 position
                MemberArray[y].setNameM(MemberArray[y+1].getNameM());
                MemberArray[y].setIDM(MemberArray[y+1].getIDM());
                MemberArray[y].setNationalityM(MemberArray[y+1].getNationalityM());
                MemberArray[y].setAddressM(MemberArray[y+1].getAddressM());
                MemberArray[y].setMobileM(MemberArray[y+1].getMobileM());
                MemberArray[y].setEmailM(MemberArray[y+1].getEmailM());
                
            }            
                           
               
                MemberSize = MemberSize -1;          //Decreases the number of customers by 1
                            
            }
        }
        
    }
}

   
   
   
   
   
   
   
   
   
   
   
   
   
   
    
    
    //==DISPLAY ALL MEMBERS==

    public void DisplayM()
    {
        if(MemberSize == 0)           //In case no record exists
        {
            output("No Member Record is Found");
        }
        
        else
        
        {
            System.out.println("Name" + "            " + "CPR" + "       " + "Mobile" + "   " + "Email" + "                " + "Address" + "                   " + "Nationality" + " " + "Game");
            System.out.println("============================================================================================================================================================================");
            
            for(int e = 0; e < MemberSize; e++)
            {
                    
                System.out.print(MemberArray[e].getNameM() + "  ");
                System.out.print(MemberArray[e].getIDM() + "  ");
                System.out.print(MemberArray[e].getMobileM() + "  ");
                System.out.print(MemberArray[e].getEmailM() + "  ");
                System.out.print(MemberArray[e].getAddressM() + "  ");
                System.out.print(MemberArray[e].getNationalityM() + "  ");
                System.out.println(MemberArray[e].getGListM());
            }
        }
    }
    
    
    
    //==CLEAR ALL FIELDS IN MEMEBERS TAB==
       
    public void ClearM()
        {
            GUI.txtNameM.setText("");
            GUI.txtIDM.setText("");
            GUI.txtMobileM.setText("");
            GUI.txtEmailM.setText("");
            GUI.txtAddressM.setText("");
            GUI.txtNationalityM.setText("");
            output("Fields Cleared");
        }
    
        
        

    //==SEARCH FOR A MEMBER==
    
   public void SearchM()
   {
    NameM = null;
    MobileM = null;
    EmailM = null;
    AddressM = null;
    NationalityM = null;
    LSTGameM = null;
        
    boolean SearchFound = false;
    
        try
        {
            IDM = Integer.parseInt((GUI.txtIDM.getText()));
        }
    
        catch(NumberFormatException err)
        {
            output( "Customer ID Error is detected");
        }
    
       
       if (IDM == 0)             //Checks if the field is empty
        output("Please enter a valid CPR");     
         
       else
       {
            for(int x = 0; x < MemberSize; x++)
            {
                
                if(IDM == (MemberArray[x].getIDM()))          //If the CPR is found
                {
                 GUI.txtNameM.setText(MemberArray[x].getNameM());     //Displays the information
                 GUI.txtMobileM.setText(MemberArray[x].getMobileM());
                 GUI.txtEmailM.setText(MemberArray[x].getEmailM());
                 GUI.txtAddressM.setText(MemberArray[x].getAddressM());
                 GUI.txtNationalityM.setText(MemberArray[x].getNationalityM());
                 output("Member is Found");
                 SearchFound = true;
                }
            }
       if(SearchFound == false)
                {
                    output("Sorry, There is No Member With The CPR Number: " + IDM);     
                }
       }
        
        }
        
        
        
        
   //==Save METHOD==
        public void SaveM()
        {
    
           //Saves to Member File
                 try
                 {
                     MemberOutput = new ObjectOutputStream(new FileOutputStream("Member.dat")); //Saves to the Member file
                     MemberOutput.writeInt(MemberSize);
                              for(int i = 0; i < MemberSize; i++)
                     {
                         MemberOutput.writeObject(MemberArray[i]);
                     }
        
                 }
                 catch(IOException R)
                 {
                     output("Problem with output to file Member.dat");
                 }
                 
        }
        
        
        
        
        
        
        
        
        
        
//==TEAMS DISPLAY TAB METHODS==

//==DISPLAY METHOD==


    public void DisplayD()
    {

            if(DisplaySize == 0)
        {
            output("There Are No Players In This Team");
        }
        else
        {
            System.out.println(GameD);
            for (int h = 0; h < MemberArray.length; h++)
            {
                if (LSTGameM.equals(GameD))
                {
                    for (int j = 0; j < 9999; j++)
                        {
                            Dis[j] = NameM;
                            System.out.println(DisplayArray[j]);
                        }
                }
            }
            
            
            
           
            
    }
    
    }



    
    
    
    
    
//==LOAD FILES METHOD==

    public void LoadFiles()
    {

        
    
        //==Load Member Array==

        try
        {
            MemberInput = new ObjectInputStream(new FileInputStream("Member.dat")); //Loads the Member's file
            
            MemberSize = MemberInput.readInt();
            
            try
            {
                for (int i = 0; i < MemberSize; i++)
                MemberArray[i]= (MemberClass)MemberInput.readObject();
            }
        
            catch(ClassNotFoundException err)
            {
                System.exit(0);
            }
        
            catch(EOFException err)
            {
                output("1.1 - End of File Exception");
            }
        }
    
        catch(FileNotFoundException err)
        {
            MemberSize=0;
            output("1.2 - Cannot find file Member.dat.");
        }
        catch (IOException err)
        {
            MemberSize=0;
            output("1.3 - Problem with input from file Member.dat.");
        }

        //Load Display Array

        try
        {
            DisplayInput = new ObjectInputStream(new FileInputStream("Display.dat"));      //Loads the Displayal's file
            DisplaySize = DisplayInput.readInt();
            
            try
            {
                for (int i=0; i<DisplaySize; i++)
                DisplayArray[i]= (DisplayClass)DisplayInput.readObject();
            }
        
            catch(ClassNotFoundException err)
            {
                System.exit(0);
            }
        
            catch(EOFException err)
            {
                output("2.1 - End of File Exception");
            }
        }
    
        catch(FileNotFoundException err)
        {
            DisplaySize=0;
            output("2.2 - Cannot find file Display.dat.");
        }
        catch (IOException err)
        {
            DisplaySize=0;
            output("2.3 - Problem with input from file Display.dat.");
        }


    }




}