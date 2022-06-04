package numberTheory;
import java.util.*;
import java.io.*;
public class moduloInverse {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("input.txt"));
        //m must be prime
        //The multiplicative inverse of “a modulo m”
        // exists if and only if a and m are relatively prime (i.e., if gcd(a, m) = 1).
        int m=sc.nextInt();
        int inv[]=new int[m];
        inv[1]=1;
        for(int i=2;i<m;i++){
            inv[i]=(m-(m/i )*inv[m%i])%m;
        }
        FileWriter fw = new FileWriter(new File("output.txt"));
        for(int i=1; i<m; i++){
            fw.write(i + " "+inv[i]+"\n");
        }
        
        fw.close();
        sc.close();
    }

}
