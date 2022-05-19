import java.util.*;
import java.math.BigInteger;
public class strMUL {
    public static String baseConversion(String number, int sBase, int dBase){

        return Long.toString(Long.parseUnsignedLong(number, sBase), dBase);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t--!=0){
            int sb1=sc.nextInt();
            String s1=sc.next();

            int sb2=sc.nextInt();
            String s2=sc.next();

            String s3=baseConversion(s1,sb1,10);
            String s4=baseConversion(s2,sb2,10);
            // String s5=StringMultiplication.multiply(s3,s4);
            BigInteger a = new BigInteger(s3);
            BigInteger b = new BigInteger(s3);
            BigInteger  mult = a.multiply(b);
        
            System.out.println(baseConversion(mult.toString(),10,Math.max(sb1, sb2)));
        }
        NumSysConv nsc = new NumSysConv();
        
        System.out.print("Enter your original number --> ");
        String origNbr = sc.next();
        
        System.out.print("Enter your original base --> ");
        String origBase = sc.next();
        
        System.out.print("Enter your desired base --> ");
        String newBase = sc.next();
        
        String[] elements = {origNbr, origBase, newBase};
        String newNbr = nsc.BaseConverter(elements);
        
        System.out.println(origNbr + " base-" + origBase + " converted to base-" + newBase + " is " + newNbr);
        sc.close();
    }
}
