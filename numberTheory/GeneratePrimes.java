package numberTheory;
import java.util.*;
import java.io.*;
 
public class GeneratePrimes
{
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
	public static void main (String[] args) throws java.lang.Exception
	{
		FastReader sc=new FastReader();
        int dp[]=new int[1000000];
        seive(dp);
        ArrayList<Integer> primes = new ArrayList<>();
        generate(primes,dp,86028131);
        ArrayList<Integer> ans = new ArrayList<>();
        PrintWriter w = new PrintWriter(System.out);
        int n=1;
        int m=86028131;
        int dummy[]=new int[m-n+1];
        for(int pr : primes){
            int firstmul= (n/pr) *pr ;
            if(firstmul<n) firstmul+=pr;
            for(int i=Math.max(firstmul, pr*pr);i<=m;i+=pr){
                dummy[i-n]=1;
            }
        }
        for(int i=n;i<=m;i++){
            if(dummy[i-n]==0 && i!=1 ) {
                ans.add(i);
            }
        }
        int t= sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while(t--!=0){
            int p=sc.nextInt();
            sb.append(ans.get(p-1)+"\n");
        }
		
        w.println(sb.toString());
        w.flush();
	}
} 