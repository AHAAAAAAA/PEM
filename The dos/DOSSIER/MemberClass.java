import java.io.*;
public class MemberClass implements Serializable
{

// Variables
    private String NameM;
    private int IDM;
    private String MobileM;
    private String EmailM;
    private String AddressM;
    private String NationalityM;
    private String GListM;
    
    public MemberClass(String NameM1, int IDM1, String MobileM1, String EmailM1, String AddressM1, String NationalityM1, String GListM1)
    {
        NameM = NameM1;
        IDM = IDM1;
        MobileM = MobileM1;
        EmailM = EmailM1;
        AddressM = AddressM1;
        NationalityM = NationalityM1;
        GListM = GListM1;
    }
    
    public MemberClass()
    {
        NameM = null;
        IDM = 0;
        MobileM = null;
        EmailM = null;
        AddressM = null;
        NationalityM = null;
        GListM = null;
    }   
    
    //SET
    
    public void setNameM(String NameM2)
        {
            NameM = NameM2;
        }
    
    
    public void setIDM(int IDM2)
        {
            IDM = IDM2;
        }
        
    public void setMobileM(String MobileM2)
        {
            MobileM = MobileM2;
        }
        
    public void setEmailM(String EmailM2)
        {
            EmailM = EmailM2;
        }
        
    public void setAddressM(String AddressM2)
        {
            AddressM = AddressM2;
        }
        
    public void setNationalityM(String NationalityM2)
        {
            NationalityM = NationalityM2;
        }
    
    public void setGListM(String GListM2)
        {
            GListM = GListM2;
        }
                
        
   //GET
   
   
   public String getNameM()
        {
            return NameM;
        }
   
   public int getIDM()
        {
            return IDM;
        }
        
   public String getMobileM()
        {
            return MobileM;
        }
        
   public String getEmailM()
        {
            return EmailM;
        }
   
   public String getAddressM()
        {
            return AddressM;
        }
        
   public String getNationalityM()
        {
            return NationalityM;
        }
        
   public String getGListM()
        {
            return GListM;
        }
        
        
    }
   
    