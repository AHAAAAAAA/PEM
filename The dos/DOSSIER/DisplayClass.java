import java.io.*;

 public class DisplayClass implements Serializable    
   {
       //Variables
       private String GameD;
     
       
 public DisplayClass(String GameD1)
       {
           GameD = GameD1;
       }
        
 public DisplayClass()
        {
            GameD = null;
        }
        
        //SET
        
 public void setGameD(String GameD2)
        {
            GameD = GameD2;
        }
                
        //GET
     
 public String getGameD()
        {
            return GameD;
        }
        
        
    }