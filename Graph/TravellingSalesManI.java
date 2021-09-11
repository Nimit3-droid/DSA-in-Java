import java.util.*;
public class TravellingSalesManI {
    //tc=n*n(2^n)
    static int n;
    static int allvisited;
    public static int tsp(int dist[][],int dp[][],int mask,int pos){
        if( mask == allvisited){
            return dist[pos][0];
        }
        if(dp[mask][pos]!=-1){
            return dp[mask][pos];
        }
        
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(((1<<i) & mask)==0){
                int newAns=dist[pos][i] + tsp(dist,dp,mask|(1<<i),i);
                ans=Math.min(ans,newAns);
            }
        }
        return dp[mask][pos]=ans;
    }
    public static void main(String args[]){
        // Scanner sc= new Scanner(System.in);
        // n=sc.nextInt();
        n=4;
        allvisited=(1<<n) -1;
        // int dist[][] = {{0, 20, 42, 25},
        //     {20, 0, 30,24 },
        //     {42, 30, 0,10 },
        //     {25, 34, 10, 0},
        // };
        int dist[][] = {{0, 1, 15, 6},
            {2, 0, 7,3 },
            {9, 6, 0,12 },
            {10, 4, 8, 0},
        };
        int dp[][]=new int[1<<n][n];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        System.out.println(tsp(dist,dp,1, 0));
    }
}
