package PrefixSum;

import java.util.Scanner;

public class MatrixDiamond {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while (t--!=0){
            int n=sc.nextInt();
            int mat[][]= new int[n+2][n+2];
            int d1[][]=new int [n+2][n+2];
            int d2[][]=new int [n+2][n+2];
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    mat[i][j]=sc.nextInt();
                }
            }

            //diag prfix sum
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    d1[i][j]+=d1[i-1][j-1];
                    d2[i][j]+=d2[i-1][j+1];
                }
            }
            int ans=Integer.MIN_VALUE, curr=0;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    curr=mat[i][j];
                    ans=Math.max(ans,curr);
                    
                    for(int d=1;Math.max(i, j)+d<=n && Math.min(i, j)>d;d++){
                        curr+=d1[i-1][j+d-1] - d1[i-d][j];
                        curr+=d1[i+d-1][j-1] - d1[i][j-d];
                        curr+=d2[i-1][j-d-1] - d2[i-d][j];
                        curr+=d2[i+d-1][j+1] - d2[i][j+d];
                        curr+=mat[i+d][j] + mat[i-d][j] +mat[i][j+d] +mat[i][j-d];
                        ans=Math.max(ans,curr);
                    }
                }
            }
        System.out.println(ans);                
        }
        sc.close();
    }
}
