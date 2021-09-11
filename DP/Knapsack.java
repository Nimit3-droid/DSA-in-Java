import java.util.*;
public class Knapsack {
    public static int Knapsck(int n, int w,int wt[],int val[]){
        int dp[][]=new int[n+1][w+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=w;j++){
                if(j==0 || i==0) dp[i][j]=0;
                else if(wt[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }


        return dp[n][w];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int w=sc.nextInt();
        int val[]=new int[n];
        int wt[]=new int[n];
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        System.out.println(Knapsck(n,w,wt,val));
    }
}
