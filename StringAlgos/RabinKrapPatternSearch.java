import java.util.*;
public class RabinKrapPatternSearch {

    // TC=> avg (n+m)  .... worst - > (nm) if all the chars are same
    public static void rabinKrap(String str,String pattern){
        int patLen=pattern.length();
        int strLen=str.length();
        int hashedPat=0, hashedTxt=0;
        int d=256, MOD = 101, h=1;
        //h=d ^ (patLength-1);
        for(int i=0;i<(patLen-1);i++){
            h=(h*d)%MOD;
        }
        for(int i=0;i<patLen;i++){
            hashedPat= (d*hashedPat + pattern.charAt(i))%MOD;
            hashedTxt= (d*hashedTxt + str.charAt(i))%MOD;
        }
        for(int i=0;i<=strLen-patLen;i++){
            if(hashedPat==hashedTxt){
                int j=0;
                for(;j<patLen;j++){
                    if(pattern.charAt(j)!=str.charAt(j+i)){
                        break;
                    }
                }
                if(j==patLen) System.out.println(i);
            }
            if(i<strLen-patLen){
                hashedTxt=(d*(hashedTxt - h*str.charAt(i)) + str.charAt(i+patLen))%MOD;
                if(hashedTxt<0) hashedTxt+=MOD;
            }
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String text = sc.nextLine() , pattern = sc.next();
        rabinKrap(text,pattern);
    }
    
}
