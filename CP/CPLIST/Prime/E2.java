package CP.CPLIST.Prime;
import java.util.*;
import java.io.*;
public class E2 {
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

    static int N=86300000;
    public static void seive(Boolean seive[]){
        seive[0]=true;
        seive[1]=true;
        for(int i=2;i*i<=N;i++){
            if(seive[i]==null){
                for(int j=i*i;j<=N;j+=i){
                    seive[j]=true;
                }
            }
        }
    }
    public static void main(String[] args) throws java.lang.Exception{
        FastReader sc = new FastReader();
        int q= sc.nextInt();
        
        Boolean seive[]=new Boolean[N+1];
        seive(seive);
        int prime[]=new int[5000001];
        int c=0;
        for(int i=2;i<=N;i++){
            if(seive[i]==null){
                prime[c]=i;
                c++;
            }
            if(c==5000000) break;
        
        }
        int qu[]=new int[q];
        int qi=0;
        while(q--!=0){
            qu[qi++]=sc.nextInt();
        }

        for(int i=0;i<qu.length;i++){
            System.out.println(prime[qu[i]-1]);
        }
    }
}
