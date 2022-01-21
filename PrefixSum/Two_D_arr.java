package PrefixSum;

import java.util.Scanner;

public class Two_D_arr {


    public static void main(String[] args) {
        // 1 based index
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int u = sc.nextInt();
        int q = sc.nextInt();
        int a[][] = new int[n + 1][m + 1];
        int d[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                d[i][j] = a[i][j] = sc.nextInt();

            }
        }
        // System.out.println("a");
        // print(a);
        // System.out.println("d");
        // print(d);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                d[i][j] = d[i][j] - a[i - 1][j] - a[i][j - 1] + a[i - 1][j - 1];
            }
        }
        // System.out.println("afterdiff");
        // print(d);

        while (u-- != 0) {
            int k = sc.nextInt(), r1 = sc.nextInt(), c1 = sc.nextInt(), r2 = sc.nextInt(), c2 = sc.nextInt();
            r1++;
            c1++;
            r2++;
            c2++;
            if (r1 >= 0 && c1 >= 0) {
                d[r1][c1] += k;
            }
            if (r2 + 1 <= n && c1 >= 0) {
                d[r2 + 1][c1] -= k;
            }
            if (r1 >= 0 && c2 + 1 <= m) {
                d[r1][c2 + 1] -= k;
            }
            if (r2 + 1 <= n && c2 + 1 <= m) {
                d[r2 + 1][c2 + 1] += k;
            }
        }
        // System.out.println("after k added ");
        // print(d);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                d[i][j] = d[i][j] + d[i - 1][j] + d[i][j - 1] - d[i - 1][j - 1];
            }
        }
        // System.out.println(" 1st pr");
        // print(d);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                d[i][j] = d[i][j] + d[i - 1][j] + d[i][j - 1] - d[i - 1][j - 1];
            }
        }
        // System.out.println(" 2 st pr");
        // print(d);
        while (q-- != 0) {
            int ans = 0;
            int r1 = sc.nextInt(), c1 = sc.nextInt(), r2 = sc.nextInt(), c2 = sc.nextInt();
            r1++;
            c1++;
            r2++;
            c2++;
            ans = d[r2][c2] - d[r1 - 1][c2] - d[r2][c1 - 1] + d[r1 - 1][c1 - 1];
            System.out.println(ans);
        }
        sc.close();

    }
}
