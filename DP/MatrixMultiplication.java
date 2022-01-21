
import java.util.*;
public class MatrixMultiplication {
    static ArrayList<String> brackets = new ArrayList<String>();
    public static int matMul(int dp[][],int arr[],int i,int j){
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int count = matMul(dp,arr,i,k) + matMul(dp,arr,k+1,j) + arr[i-1]*arr[k]*arr[j];
            ans=Math.min(ans,count);
        }
        return dp[i][j]=ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        sc.close();
        System.out.println(matMul(dp,arr, 1, n-1));
    }
}
