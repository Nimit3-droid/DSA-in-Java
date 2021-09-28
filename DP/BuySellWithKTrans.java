import java.util.*;
public class BuySellWithKTrans{
    public static int generateProfit(int price[],int n,int k){
        int dp[][]=new int[k+1][n];
        //dp[t][d] -> for t th tranjaction on d th day, what is the profit
        for(int t=1;t<=k;t++){
            int maxPreRow=Integer.MIN_VALUE;
            for(int d=1;d<n;d++){
                // for(int j=0;j<d;j++){
                //     maxPreRow=Math.max(maxPreRow,price[d]-price[j]+dp[d][j]);
                // }
                maxPreRow=Math.max(maxPreRow,dp[t-1][d-1]-price[d-1]);
                dp[t][d]=Math.max(maxPreRow+price[d],dp[t][d-1]);
            }
        }
        return dp[k][n-1];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int price[]=new int[n];
        for(int i=0; i<n; i++){
            price[i]=sc.nextInt();
        }
        System.out.println(generateProfit(price,n,k));
    }
}