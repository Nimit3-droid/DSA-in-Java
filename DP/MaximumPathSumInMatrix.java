import java.util.*;
public class MaximumPathSumInMatrix {
    static int maximumPath(int n, int Matrix[][])
    {
        //n^2
        int dp[][]=new int[n][n];
        for(int i =0;i<n;i++){
            dp[i]=Arrays.copyOf(Matrix[i],n);
        }

        
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int x=(i==n-1)? 0 : dp[i+1][j];
                int y=(j==0 || i==n-1)?0 : dp[i+1][j-1];
                int z=(j==n-1 || i==n-1)?0 : dp[i+1][j+1];
                dp[i][j]=Matrix[i][j] + Math.max(z,Math.max(x,y));
            }
        }
        int maxSum=0;
        for(int i=0;i<n;i++){
            maxSum=Math.max(maxSum,dp[0][i]);
        }
        
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int mat[][]=new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                mat[i][j]=sc.nextInt();
            }
        }
        System.out.println(maximumPath(n,mat));
    }
    
}
