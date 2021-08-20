package numberTheory;

import java.util.Scanner;

public class fib {
    static int mod = 1000000007;

    public static long[][] mul(long a[][], long b[][]) {
        int rows = a.length, cols = b[0].length;
        long c[][] = new long[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    c[i][j] =(c[i][j]%mod+ ((a[i][k] % mod * b[k][j]) % mod) % mod)%mod;
                }
            }
        }
        return c;
    }

    public static long[][] power(long a[][], long power) {

        long id[][] = new long[2][2];
        id[0][0] = 1;
        id[0][1] = 0;
        id[1][0] = 0;
        id[1][1] = 1;

        while (power != 0) {
            if (power % 2 == 0) {
                a = mul(a, a);
                power /= 2;
            } else {
                id = mul(id, a);
                power--;
            }

        }

        
        return id;

    }

    public static long solve(int n) {
        long F[][] = new long[2][2];
        F[0][0] = 0;
        F[0][1] = 1;
        F[1][0] = 1;
        F[1][1] = 1;
        if (n == 0)
            return 0;

        long f[][] = new long[1][2];
        f[0][0] = 1;
        f[0][1] = 1;
        F = power(F, n-1);
        f = mul(f, F);
        return f[0][0] % mod;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println((int)solve(n));

    }
}
