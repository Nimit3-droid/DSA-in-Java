// package DP;
// public class CuttingARod{
//     public static int cut(int arr[],int n){
//         //cut(n) = max(arr[i]+cut(arr,n-1-i));
//         // int n=arr.length;
//         if(n<1) return 0;
//         int max=Integer.MIN_VALUE;
//         for( int i=0;i<n;i++){
//             max=Math.max(arr[i]+cut(arr,n-i-1),max);
//         }
//         return max;
//     }
//     // public static int cutt(int arr[]){
//     //     //cut(n) = max(arr[i]+cut(arr,n-1-i));
//     //     int n=arr.length;
//     //     if(n<1) return 0;
//     //     int dp[]=new int[n+1];
//     //     dp[0]=0;
//     //     for( int i=1;i<=n;i++){
//     //         int max=Integer.MIN_VALUE;
//     //         for(int j=0;j<i;j++){
//     //             max=Math.max(arr[j]+dp[i-j-1],max);
//     //         }
//     //         dp[i]=max;
//     //     }
//     //     return dp[n];
//     // }
//     public static void main(String[] args){
//         int arr[]={1,2,3,4,5,6,7,8,9,10,11};
//         System.out.println(cut(arr,arr.length));
//     }
// }