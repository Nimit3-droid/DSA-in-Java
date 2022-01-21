package PrefixSum;

import java.util.Scanner;

public class DigitPrimes {
    static int  Max=100000000;
    static boolean prime[]=new boolean[100000001];
    static int dPrime[]=new int[100000001];
    public static void isprime(boolean isDigitPrime[]){
        for(int i=2; i*i<=Max;i++){
            if(!isDigitPrime[i]){
                for(int j=i*i;j<=Max;j+=i){
                    isDigitPrime[j]=true;
                }
            }
        }

    }
    static void seive() {
        int  i, j;
        prime[0] = true;
        prime[1] = true;
        for (i = 2; i *i<= Max; i++) {
            // dPrime[i] = dPrime[i - 1];
            if (!prime[i]) {
                // if (!prime[dSum(i)]) ++dPrime[i];
                for (j = i * i; j <= Max; j += i)
                    prime[j] = true;
            }
        }
        for (i = 2; i<= Max; i++) {
            dPrime[i] = dPrime[i - 1];
            if (!prime[i]) {
                if (!prime[dSum(i)]) ++dPrime[i];
            }
        }
        
    }
    static int dSum(int N) {
        int T = 0;
        while (N>0) {
            T += (N % 10);
            N /= 10;
        }
        return T;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        while(n--!=0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            seive();
            System.out.println(dPrime[b] - dPrime[a - 1]);
        }
        sc.close();
    }

}
