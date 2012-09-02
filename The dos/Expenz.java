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

import java.io.*;
public class Expenz implements Serializable 
{
    private String ExpenseN; // Holds the expense name 
    private String expVal; // Holds the value   
    
    public Expenz ( String ExpenseN1, String expVal1)
    {    ExpenseN= ExpenseN1;
         expVal =expVal1;         
    }
    public Expenz ()
    {
        ExpenseN = null;
        expVal = null;
    }
  //SET METHODS
  public void setExpenseName (String ExpenseN2)
  {
  ExpenseN = ExpenseN2;
  }
  public void setExpenseValue (String expVal2)
  {
 expVal =expVal2;
  } 
//GET METHODS
  public String getExpenses ()
  {
      return ExpenseN;
    }
    public String getexpVal ()
  {
      return expVal;
    } 
     
    
}