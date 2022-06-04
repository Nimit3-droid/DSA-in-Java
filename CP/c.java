package CP;
import java.util.*;
import java.io.*;
public class c {
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
   
    public static void main(String[] args){
        FastReader sc = new FastReader();
        int t= sc.nextInt();
        while (t--!=0){
            int n=sc.nextInt();
            int m=sc.nextInt();

            int mat[][]=new int[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    mat[i][j]=sc.nextInt();
                }
            }

            int sorted[][]=new int[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    sorted[i][j]=mat[i][j];
                }
                Arrays.sort(sorted[i]);
            }
            int ans[]={1,1};
            int flag=0;
            for(int i=0; i<n; i++){
                int col=0;
                int j=0;
                int i1=0;
                while(j<m){
                    if(mat[i][j]!=sorted[i][j]){
                        col++;
                        i1=0;
                        break;
                    }
                    j++;
                }
                j++;
                int i2=0;
                while(j<m){
                    if(mat[i][j]!=sorted[i][j]){
                        col++;
                        i2=j;
                        break;
                    }
                    j++;
                }
                if(col>2){
                    ans[0]=-1;
                    break;
                }
                for(int k=0;k<n;k++){
                    if(!(mat[k][i1]>=mat[k][i2])){
                        flag=1;
                        break;
                    }
                }
                if(flag==1){
                    ans[0]=-1;
                    break;
                }else if(col==2){
                    ans[0]=i1+1;
                    ans[1]=i2+1;
                }
            }

            if(ans[0]==-1){
                System.out.println(-1);
            }else{
                System.out.println(ans[0]+" "+ans[1]);
            }

            
            
        }
    }
}
