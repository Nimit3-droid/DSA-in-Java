import java.util.Scanner;
//  class Solution {
//     public int solve(int n, int[] arr) {
//         int count[] = new int[n];
//         int sum = 0;
//         for (int i = 0; i < n; i++) {
//             sum += arr[i];
//         }
//         if (sum % 3 != 0)
//             return 0;
//         int seg = sum / 3;

//         int suff[] = new int[n];
//         suff[n - 1] = arr[n - 1];
//         for (int i = n - 2; i >= 0; i--) {
//             suff[i] = suff[i + 1] + arr[i];
//         }
      
//         for (int i = n - 1; i >= 0; i--) {
//             if (suff[i] ==seg) {
//                 count[i] = 1;
//             }
//         }

       
//         for (int i = n - 2; i >= 0; i--) {
//             count[i] += count[i + 1];
//         }

//         sum = 0;
//         int ans = 0;
//         for (int i = 0; i < n - 2; i++) {
//             sum += arr[i];
//             if (sum  == seg) {
//                 ans += count[i + 2];
//             }
//         }
//         return ans;

//     }
// }
 class Solution {
    public int[] solve(String A) {
        int ans[]=new int[2];
        int l=0;
        int r=0;
        int c=0;
        int lt=0;
        int i=0;
        int max=Integer.MIN_VALUE;
        while(i<A.length()){
            if(A.charAt(i)=='0'){
                c++;
            }else{
                c--;
            }
            if(c>max){
                max=c;
                l=lt;
                r=i;
            }
            if(c<0){
                c=0;
                lt=i+1;
            }
            i++;
        }

        ans[0]=l++;ans[1]=r++;
        return ans;
    }
}

public class Tester {
   

    public static void main(String[] args) {
        // Solution obj=new Solution();
        // Scanner sc=new Scanner(System.in);
        // // int n=sc.nextInt();
        // // int arr[]=new int[n];
        // // for(int i=0;i<n;i++){
        // //     arr[i]=sc.nextInt();
        // // }
        // String A=sc.next();
        // int res[]=obj.solve(A);
        // System.out.println(res[0]+" "+res[1]);
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        char cmat[][]=new char[n][m];
        for(int i=0;i<n;i++){
                String s=sc.next();
                cmat[i]=s.toCharArray();
        }
        int obstacleGrid[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(cmat[i][j]=='.'){
                    obstacleGrid[i][j]=0;
                }else{
                    obstacleGrid[i][j]=1;
                }
            }
        }

       
     int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            System.out.println(0);return;
        }

        obstacleGrid[0][0] = 1;

        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1] +obstacleGrid[i-1][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        System.out.println(obstacleGrid[R - 1][C - 1]);

    }
}