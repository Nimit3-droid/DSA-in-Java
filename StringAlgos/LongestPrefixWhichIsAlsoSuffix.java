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
                //lps[i]=-1;
                i++;
            }
        }
        return lps;
    }
    public static void KMP_Patten(String str,String pattern) throws IOException{
        int lps[]=kmpDP(pattern);
        FileWriter fw = new FileWriter(new File("output.txt"));
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
                    
                    fw.write("Pattern found at index "+ (i-1)+"\n");
                    j=lps[j-1]+1;
                    
                }
            }else if(j>0){
                j=lps[j-1]+1;
            }else{
                i++;
            }
        }
        fw.close();
        
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        String str=sc.nextLine();
        String pat=sc.nextLine();
        KMP_Patten(str,pat);

        sc.close();
    }
    
}
