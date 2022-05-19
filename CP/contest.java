package CP;

import java.util.*;
import java.io.*;

public class contest {
    static class pair {
        int x, y, p, q;

        pair(int x, int y, int p, int q) {
            this.x = x;
            this.y = y;
            this.p = p;
            this.q = q;
        }

        pair(int x, int y, int p) {
            this.x = x;
            this.y = y;
            this.p = p;
        }

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void swap(int arr[], int x, int y) {
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }

    static int LongestIncreasingSubsequenceLength(int A[], int size) {

        int[] tailTable = new int[size];
        int len;

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (A[i] < tailTable[0])
                tailTable[0] = A[i];

            else if (A[i] > tailTable[len - 1])
                tailTable[len++] = A[i];

            else
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
        }

        return len;
    }

    static int CeilIndex(int A[], int l, int r, int key) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    public static int solve(int n,int m){
        if(n==m){
            return 0;
        }
        if(n>=m) return n%=m;
        return 1+Math.min(solve(n+1,m) , solve(n*2,m));
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i]=sc.nextInt();
        }
        int mod=32768;
       
    }
}