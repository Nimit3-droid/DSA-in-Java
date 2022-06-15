import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class LongestPrefixWhichIsAlsoSuffix {
    //naive approach n^2
    public static int LCS(String s) {
        int n=s.length();
        int j=(n+1)/2;
        int i=0;
        while(j<n){
            if(s.charAt(i)==s.charAt(j)){
                i++;j++;
            }else{
                j=(j-i+1);
                i=0;
            }
        }

        return i;
    }
    //        /\
    // o(N) //||\\
    public static int[] kmpDP(String str){
        int n = str.length();
        int lps[]=new int[n];
        Arrays.fill(lps, -1);
        int i = 1;
        int j = 0;
        while(i<n){
            if(str.charAt(i)==str.charAt(j)){
                lps[i]=j;
                i++;
                j++;
            }else if(j>0){
                j=lps[j-1]+1;
            }else{
                lps[i]=-1;
                i++;
            }
        }
        //do +1 to get length
        return lps;
    }
    static int[] kmpDPgfg(String s) {
        // code here
        int n=s.length();
        int i=1;
        int len=0;
        int lpsArr[]=new int[n];
        lpsArr[0]=0;
        while(i<n){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lpsArr[i]=len;
                i++;
            }else if(len==0){
                lpsArr[i]=0;
                i++;
            }else{
                len=lpsArr[len-1];
            }
            
        }
        return lpsArr;
    }
    public static void KMP_Patten(String str,String pattern) throws IOException{
        int lps[]=kmpDP(pattern);
        for(int i=0;i<lps.length;i++){
            System.out.print(lps[i] +" ");
        }
        int i=0, j=0;
        int n= str.length();
        while(i<n){
            if(str.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            
                if(j==pattern.length()){
                    System.out.print("Pattern found at index "+ (i-1)+"\n");
                    j=lps[j-1]+1;
                    
                }
            }else if(j>0){
                j=lps[j-1]+1;
            }else{
                i++;
            }
        }        
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        // String pat=sc.nextLine();
        // KMP_Patten(str,pat);
        kmpDPgfg(str);
        System.out.println();
        kmpDP(str);

        sc.close();
    }
    
}
