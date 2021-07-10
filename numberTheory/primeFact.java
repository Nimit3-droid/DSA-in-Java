package numberTheory;

import java.util.Scanner;

public class primeFact {
    public static void primefactUsingSeive(int k) {
        int arr[] = new int[100000001];
        int max = 100000000;
        for (int i = 2; i * i <= max; i++) {
            if (arr[i] == 0) {
                for (int j = i * i; j <= max; j += i) {
                    if (arr[j] == 0) {

                        arr[j] = i;
                    }
                }
            }
        }
        String ans = "";
        while (arr[k] != 0) {
            ans = ans + " " + arr[k];
            k /= arr[k];
        }
        if (arr[k] == 0) {
            ans = ans + " " + k;
        }
        System.out.println(ans);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                int count = 0;
                while (n % i == 0) {
                    count++;
                    n /= i;
                }
                System.out.println(i + "^" + count);
            }
        }
        // if n>0 => it is prime
        if (n > 0) {
        System.out.println(n + "^1");
        }

        primefactUsingSeive(100);
    }
}
