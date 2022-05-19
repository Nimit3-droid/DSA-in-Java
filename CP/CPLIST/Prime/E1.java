package CP.CPLIST.Prime;
import java.util.*;
import java.io.*;
public class E1 {
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
    static void seive(int dp[]){
        int n=dp.length;
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i*i<=n;i++){
            if(dp[i]==0){
                for(int j=i*i;j<n;j+=i){
                    dp[j]=1;
                }
            }
        }
    }
    public static void generate(ArrayList<Integer> primes,int dp[],int n){
        for(int i=2;i*i<=n;i++){
            if(dp[i]==0){
                primes.add(i);
            }
        }
    }
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t= sc.nextInt();
        int dp[]=new int[1000000];
        seive(dp);
        while(t--!=0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            ArrayList<Integer> primes = new ArrayList<>();
            generate(primes,dp,m);
            int dummy[]=new int[m-n+1];
            for(int pr : primes){
                int firstmul= (n/pr) *pr ;
                if(firstmul<n) firstmul+=pr;
                for(int i=Math.max(firstmul, pr*pr);i<=m;i+=pr){
                    dummy[i-n]=1;
                }
            }
     
            for(int i=n;i<=m;i++){
                if(dummy[i-n]==0 && i!=1) System.out.println(i);
            }
        }
        System.out.println();
    }
}
