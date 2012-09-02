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
import java.awt.*;




public class expenses extends JFrame implements ActionListener
{

     public static DrawGUI GUI = new DrawGUI();

//Output Streams
    ObjectOutputStream outputStreamExpenses = null;
   
    
// Input Streams    
    ObjectInputStream inputStreamExpenses = null;
   

    // declare all the arrays
    double effi; 
    int expSize = 0;
    //String expVal;
    //String ExpenseN;
    Expenz[] daExp = new Expenz [750]; //array  holds the expenses record
    Expenz temp = new Expenz(); //temperary holds the object of type expenses. It is used for sorting.
   
   
   
    public expenses()
    {
               
        GUI.btnAddit.addActionListener(this);
        GUI.btnDeleteit.addActionListener(this);
        GUI.btnClearS.addActionListener(this);
        GUI.btnFixit.addActionListener(this);
        GUI.btnModit.addActionListener(this);
        GUI.btnSearchS.addActionListener(this);
        GUI.btnSortS.addActionListener(this);
        GUI.btnDisplayAllS.addActionListener(this);
        GUI.btnSaveS.addActionListener(this);
        
              ExpenseReadFile();
    
    }
//ACTION LISTENER FOR Expense ARRAY ==================================    
    public void actionPerformed (ActionEvent e)
    {
        
        if (e.getSource() == GUI.btnAddit)        
        {
            Addit();
        }
        
        if (e.getSource() == GUI.btnDeleteit)
        {
            DeleteExpense();
        }
        if (e.getSource() == GUI.btnFixit)
        {
            Budge();
        }
        if (e.getSource() == GUI.btnModit)
        {
            Modit();
        }
        
         if (e.getSource() == GUI.btnDisplayAllS)
        {
            DisplayAllExpenses();
        }
        
        if (e.getSource() == GUI.btnClearS)
        {
            Clearit();
        }        

        if (e.getSource() == GUI.btnSearchS)
        {
           SearchExpenseID();
        }
        
        if (e.getSource() == GUI.btnSortS)
        {
           SortExpenses();
        }
        
        if (e.getSource() == GUI.btnSaveS)
        {
            ExpenseSave();
            
        }         

        
    }
    //METHODS

 
 //*****************************________________________________________________Expense METHODS____________________________________________**********************
    // ADD
    


    public void Addit()
    { 
      /* try
       {
          String ExpenseN = (GUI.txtExpense.getText());
        }
        catch (NumberFormatException nfe) {}
        */
        try
        {
           double expVal = Double.parseDouble((GUI.txtValue.getText()));
        }
        catch (NumberFormatException nfe) {}
        String expVal = GUI.txtValue.getText();
        String ExpenseN = GUI.txtExpense.getText();
        boolean fIntegerFound = false; // to check if the Expense name consists of letters only   
        boolean vCharFound = false; // to check if the value consists of digits only
        boolean ExpenseIDMatch = false; // when comparing Expense that has been inputed with the daExp. Set as false, as the Expense has not been found        
    
        //Flags 
        
     if ( !(ExpenseN.equals("")) ) //Expense name is not left blank    
            {
                for (int f=0; f<ExpenseN.length(); f++)
                    if(Character.isDigit(ExpenseN.charAt(f))) // if a integer has been in the expense
                        {
                            fIntegerFound = true;
                            break; //exits the loop
                        }
             }
             
         
                  if ( !(expVal.equals("")) ) //Expense value is not left blank    
            {
                for (int f=0; f<expVal.length(); f++)
                    if(!(Character.isDigit(expVal.charAt(f)))) // if a Character has been in the value
                        {
                            vCharFound = true;
                            break; //exits the loop
                        }
             }
             
   
    //================DATA VALIDATION FOR ADD Expense ==========================    

        for ( int j=0; j<expSize; j++)
        {
                if (ExpenseN.equals (GUI.txtExpense.getText()))
                {
                ExpenseIDMatch = true;
                break;
            }
                
                else
                {
                ExpenseIDMatch =false;
                 }
         }
           
      if ( expSize == 750 )
            GUI.txtDisplayFieldS.setText("You have reached the maximum number of Expenses"); 
            
      else if (ExpenseIDMatch = false)
        GUI.txtDisplayFieldS.setText( "Please enter a Expense Name");
      else if (ExpenseIDMatch)
      {
          GUI.txtDisplayFieldS.setText( "Already exists, Enter different name.");
        }     
            
       else if ( (ExpenseIDMatch = false) || (ExpenseN.equals("")) || (expVal.equals("")) )
                    GUI.txtDisplayFieldS.setText("Please fill in all the fields");
                    
       
                  
       else if (fIntegerFound) //if a number was found in the expense name
            GUI.txtDisplayFieldS.setText("Expenses: should be in form of letters.");
                       
       else if (vCharFound) //if a character was found in the value
            GUI.txtDisplayFieldS.setText("Value: should be in form of numbers.");
       
              
        else 
         {
            ExpenseIDMatch = false;
            daExp[expSize] = new Expenz (ExpenseN, expVal);
            expSize = expSize + 1;
            GUI.txtDisplayFieldS.setText("Expense has been added successfully!");
            }
    
    } // end of Add
    
//    Delete a Expense
    public void DeleteExpense()
        {
           boolean ExpenseIDMatch = false;
           boolean fIntegerFound = false; 
            
                String ExpenseN = GUI.txtExpense.getText(); // the expense name to be deleted
           
            int Count = -1;
            // ==============================DATA VALIDATION FOR DELETE Expense ======================
                     
             if ( (ExpenseN.equals("")))
                GUI.txtDisplayFieldS.setText("Please enter a expense name.");
                
                else //Expense name is not left blank    
            {
                for (int f=0; f<ExpenseN.length(); f++)
                    if(Character.isDigit(ExpenseN.charAt(f))) // if a integer has been in the expense
                        {
                            fIntegerFound = true;
                            break; //exits the loop
                        }
             }
             
            if (fIntegerFound)
            {
            GUI.txtDisplayFieldS.setText("Expenses: should be in form of letters.");
        }
        else
            {
                for ( int i=0; i < expSize; i++)
                {
                   
                     if (ExpenseN.equals (daExp[i].getExpenses()))
                       {
                           ExpenseIDMatch=true;
                           Count = i; 
                           for ( int j = Count; j < expSize-1; j++)
                           {
                                daExp[j].setExpenseName(daExp[j+1].getExpenses());
                                daExp[j].setExpenseValue(daExp[j+1].getexpVal());
                                
                            }
                            GUI.txtDisplayFieldS.setText ((ExpenseN) + " has been deleted successfully");
                            expSize=expSize -1;
                            break;
                        }
                        else
                        GUI.txtDisplayFieldS.setText (" Enter expense name");
                 }
           }  
                
            
            
        } //END OF DELETE

//DISPLAY ALL ExpenseS        
   public void DisplayAllExpenses()
   {
       String ExpenseN = GUI.txtExpense.getText();
        String expVal = GUI.txtValue.getText();
                   // ==============================DATA VALIDATION FOR Display All Expense ==================================
       if ( expSize == 0)
            GUI.txtDisplayFieldS.setText ("There are no expenses");
       
       else 
       {
            for (int i=0; i<expSize; i++)
            {
                System.out.println("Expense: " + daExp[i].getExpenses());
                System.out.println("Value: " +" $"+ daExp[i].getexpVal());
               
                System.out.println(" ----------------------------");
            }
       }
    
   }// end of display all Expenses
   
//Sort Expenses

 public void SortExpenses()
 {
     //==============================DATA VALIDATION FOR SORT ExpenseS ==================================
     if ( expSize == 0)
            GUI.txtDisplayFieldS.setText ("There are no expenses");
            
     else
     {
         for (int i=0; i<expSize; i++)
         {
             for (int j= i+1; j<expSize; j++)
             {
                 double g = Double.parseDouble((daExp[i].getexpVal()));
                 double h = Double.parseDouble((daExp[j].getexpVal()));
                 if (g < h)
                 {   
                     temp = daExp[i];
                     daExp[i] = daExp[j];
                     daExp[j] = temp;
                 } 
                 GUI.txtDisplayFieldS.setText ("Expenses have been sorted by their value!");
             }
         }
     }
     for (int i=0; i<expSize; i++)
            {
                System.out.println("Expense Name: " + daExp[i].getExpenses());
                System.out.println("Expense Value: " + daExp[i].getexpVal());
               
                System.out.println(" ----------------------------"); 
                
            }
 }
  
//CLEAR FIELDS
    public void Clearit()
    {
        GUI.txtExpense.setText ("");
        GUI.txtValue.setText ("");
       
        
    }

//Search by Expense ID
   public void SearchExpenseID()
    {
        
        String ExpenseN = GUI.txtExpense.getText(); // the Expense ID to be searched for
        
        //flags
        boolean fIntegerFound = false;  
        boolean ExpenseIDMatch = false;        
       
       // ====================== DATA VALIDATION FOR SEARCH Expense ======================
       
       if (ExpenseN.equals (""))
       {
           GUI.txtDisplayFieldS.setText("Please enter an existing expense.");
                   }
                     else //Expense name is not left blank    
            {
                for (int f=0; f<ExpenseN.length(); f++)
                    if(Character.isDigit(ExpenseN.charAt(f))) // if a integer has been in the expense
                        {
                            fIntegerFound = true;
                            break; //exits the loop
                        }
             }
             
            if (fIntegerFound)
            {
            GUI.txtDisplayFieldS.setText("Expenses: should be in form of letters.");
        }
      
       
        else
        {
                for ( int i=0; i < expSize; i++)
                {
                  
                     if (ExpenseN.equals (daExp[i].getExpenses()))
                       {
                           ExpenseIDMatch = true;
                           System.out.println("Expense: " + daExp[i].getExpenses());
                           System.out.println("Value: $" + daExp[i].getexpVal());
                           
                           GUI.txtDisplayFieldS.setText ("Expense has been found successfully");
                           break; 
                       }
                    else  
                     GUI.txtDisplayFieldS.setText ("Expense: " + ExpenseN + " has not been found");
                    }
        }
    }
// Save Expense (Save to file)
    public void ExpenseSave()
        {
        // writes to Expense file
        
        try
            {
                outputStreamExpenses = new ObjectOutputStream (new FileOutputStream ("Expenses.dat"));
                outputStreamExpenses.writeInt (expSize);
                
                for (int i= 0; i<expSize; i++)
                {
                    outputStreamExpenses.writeObject (daExp[i]);
                    GUI.txtDisplayFieldS.setText ("Data has been saved!");
                }

            }
        catch (IOException Q)
        {
            System.out.println ("A problem occured with the output to the file: Expensefile.txt ");
        }
        
    }    
    


    public void ExpenseReadFile()  
    {
        try
        {
            inputStreamExpenses = new ObjectInputStream (new FileInputStream ("Expenses.dat") );
            
            expSize = inputStreamExpenses.readInt();
            try
            {
                for (int i = 0; i<expSize; i++)
                    daExp[i] = (Expenz)(inputStreamExpenses.readObject());
            }
            
        catch (ClassNotFoundException x)
            {
                System.exit(0);
            }
            
        catch (EOFException x)
            {
                System.out.println ("End of File Exception");
            }
        }
        catch (FileNotFoundException x)
        {
            expSize = 0;
            System.out.println("Cannot find file: ExpenseFile.dat");
        }
        
        catch (IOException x)
        {
            expSize = 0;
            System.out.println ("Problem with the input from the file: Expenses.dat");
        }
    }
            
    public void Modit()
    { double count=0;
        for (int i= 0; i<expSize; i++)
             {
                 double g = Double.parseDouble((daExp[i].getexpVal()));
                 count=count+g;
            }
                
                 GUI.txtDisplayFieldS.setText ("Total expenses is $"+count+". Money left $"+(effi-count));
             }
    
    
    public void Budge()
    {    String expVal = GUI.txtValue.getText();
        boolean vCharFound=false;
          if ( !(expVal.equals("")) ) //Expense value is not left blank    
            {
                for (int f=0; f<expVal.length(); f++)
                    if(!(Character.isDigit(expVal.charAt(f)))) // if a Character has been in the value
                        {
                            vCharFound = true;
                            break; //exits the loop
                        }
             }
       
           if (vCharFound) //if a character was found in the value
            GUI.txtDisplayFieldS.setText("Value: should be in form of numbers.");
       
            else if (expVal.equals(""))
       {
           GUI.txtDisplayFieldS.setText("Enter value");
        }
        else 
         {
                effi = Double.parseDouble((GUI.txtValue.getText()));
                GUI.txtDisplayFieldS.setText("Fixed income changed!");
            
        }}
    }    

   

 


      
      
