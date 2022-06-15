import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// package StringAlgos;

public class RollingHashFunction {
    static long prime = 31, primePower = 1, value = 0, MOD=100000007;

    public static long getHash(String key) {
        for (char c : key.toCharArray()) {
            value =(value + (c * primePower)%MOD)%MOD;
            primePower =(primePower * prime)%MOD;

        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        
        // System.out.println();
        FileWriter fw = new FileWriter(new File("output.txt"));
        int n=sc.nextInt();
        for(int i = 0; i <n;i++){
            fw.write(getHash(sc.next())+"\n");
        }
        sc.close();
        fw.close();
    }
}
