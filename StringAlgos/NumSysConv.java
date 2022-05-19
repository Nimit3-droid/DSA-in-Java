import java.util.*;
class NumSysConv
{
    private String usrNum;
    private int usrBase;
    private int newBase;
    String newNum = "";
    String ans = "";
    ArrayList<Integer> numElem = new ArrayList<>();
    int TenNum = 0;
    
    public String BaseConverter(String[] w)
    {
        newNum = "";
        usrNum = w[0];
        usrBase = Integer.parseInt(w[1]);
        newBase = Integer.parseInt(w[2]);
        
        if(usrBase == 10)
            convFromTen(Integer.parseInt(usrNum));
        else
        {
            if(newBase == 10)
            {
                convToTen();
                newNum = "";
                newNum +=TenNum;
            }//end if 
            else
            {
            convToTen();
            convFromTen(TenNum);
            }//end else
        }//end else
        return newNum;
    }//end BaseConverter
    
    public int convToTen()
    {
        for(int x = 0; x < usrNum.length(); x++)
        {
            if('A' <= usrNum.charAt(x) && usrNum.charAt(x) <= 'Z')
                numElem.add((usrNum.charAt(x)-55));

            else if('a' <= usrNum.charAt(x) && usrNum.charAt(x) <= 'z')
                numElem.add((usrNum.charAt(x)-87));
            
            else if('0' <= usrNum.charAt(x) && usrNum.charAt(x) <= '9')
                numElem.add(usrNum.charAt(x) - 48);
                
        }//end conversion of char to Integer
        for(int i = 0; i < numElem.size(); i++)
            TenNum = TenNum + (int)(Math.pow(usrBase,numElem.size()- 1 - i) * numElem.get(i));
            
            
        return TenNum;
    }//end convToTwo
    
    public void convFromTen(int x)
    {
        int number = x;
        int remainder = 0;
        while(number != 0)
        {
            remainder = number % newBase;
            if(remainder > 9)
                ans+= (char)(remainder + 55);
            else
                ans+= remainder;
            
            number /=newBase;
            
        }//End Conversion
        
        for(int z = ans.length() - 1; z >= 0; z--)
          newNum = newNum + ans.charAt(z);
    }//end convFromTen
}//endNumSysConv