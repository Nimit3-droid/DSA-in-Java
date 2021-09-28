import java.util.*;
public class coinPickGame{
    public static int coinPick(int arr[] , int n,int i,int e,int dp[][]){
        if(e<i || n==0){
            dp[i][e]=0;
            return 0;
        }
        if(e-i+1==2){
            return dp[i][e]=Math.max(arr[i],arr[e]);
            
        }else if(e-i+1==1){
            return dp[i][e]=arr[i];
        }
        int p1=0,p2=0;
        if(dp[i][e]==-1){
            int x=0,y=0,z=0;
            if(dp[i+2][e]!=-1){
                x=dp[i+2][e];
            }
            if(dp[i+1][e-1]!=-1){
                y=dp[i+1][e-1];
            }
            if(dp[i][e-2]!=-1){
                z=dp[i][e-2];
            }
            p1=Math.min(x,y) + arr[i];
            p2=Math.min(z,y) + arr[e];
            return dp[i][e]=Math.max(p1,p2);
        }
        p1=Math.min(coinPick(arr,n,i+2,e,dp),coinPick(arr,n,i+1,e-1,dp)) + arr[i];
        p2=Math.min(coinPick(arr,n,i,e-2,dp),coinPick(arr,n,i+1,e-1,dp)) + arr[e];
        return dp[i][e]=Math.max(p1,p2);

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        int dp[][]=new int[n+1][n+1];
        System.out.println(coinPick(arr,n,0,n-1,dp));
    }
}