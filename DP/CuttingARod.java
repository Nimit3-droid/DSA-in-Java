import java.util.*;
public class CuttingARod{
    public static int cut(int arr[],int n){
        //cut(n) = max(arr[i]+cut(arr,n-1-i));
        if(n<=0) return 0;
        int max=Integer.MIN_VALUE;
        for( int i=0;i<n;i++){
            max=Math.max(arr[i]+cut(arr,n-i-1),max);
        }
        return max;
    }
    public static int cut(int arr[],int n,int dp[]){
        //cut(n) = max(arr[i]+cut(arr,n-1-i));
        if(n<=0) return 0;
        int max=Integer.MIN_VALUE;
        
        for( int i=0;i<n;i++){
            int y;
            if(dp[n-1-i]!=-1){
                y=dp[n-1-i];
            }else{
                y=cut(arr,n-i-1);
            }
            
            max=Math.max(arr[i]+y,max);
        }
        return max;
    }
    public static void main(String[] args){
        
        int arr[]={1,5,8,9,10,17,17 ,20};
        System.out.println(cut(arr,8));
        int dp[]=new int[8+1];
        Arrays.fill(dp,-1);
        System.out.println(cut(arr,8,dp));
    }
}