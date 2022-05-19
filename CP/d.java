package CP;
import java.util.*;
import java.io.*;
import java.math.BigInteger;


public class d {
    static class pair{
        int x, y,p,q;
        pair(int x, int y, int p,int q){
            this.x = x;
            this.y = y;
            this.p=p;
            this.q=q;
        }
    }
    static class pair1{
        int x, y;
        pair1(int x, int y){
            this.x = x;
            this.y = y;
    
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
   

    public static void swap(int arr[],int x,int y){
        int t=arr[x];
        arr[x]=arr[y];  
        arr[y]=t;
    }
    public static void main(String[] args){
        FastReader sc = new FastReader();
        // int t= sc.nextInt();
        // while(t--!=0){
            long n = sc.nextLong();
            long x = sc.nextLong();
            char arr[]=sc.next().toCharArray();
            for(int i=0;i<n;i++){
                if(arr[i]=='U'){
                    int j=i-1;
                    while(j>=0 && arr[j]=='.'){
                        j--;
                    }
                    if(j>=0){
                        arr[j]='.';
                        arr[i]='.';
                    }
                }
            }
            BigInteger ab= new BigInteger(x+"");
            BigInteger two= new BigInteger("2");
            BigInteger one= new BigInteger("1");
            for(int i=0;i<n;i++){
                if(arr[i]=='L'){
                    ab=ab.multiply(two);
                }else if(arr[i]=='R'){
                    ab=(ab.multiply(two)).add(one);
                }else if(arr[i]=='U'){
                    if(ab==one){
                        continue;
                    }
                    ab=ab.divide(two);
                }
            }
            System.out.println(ab.toString()); 
            
        // }

        
    }
}