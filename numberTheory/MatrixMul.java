package numberTheory;

import java.util.Scanner;

public class MatrixMul {
    public static int [][] mul(int a[][],int b[][]){
        int rows = a.length, cols = b[0].length;
        int c[][]=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                for(int k=0;k<a[0].length;k++){
                    c[i][j]+=(a[i][k] * b[k][j]);
                }
            }
        }
        return c;
    }
    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt(), m=sc.nextInt();
        int power=sc.nextInt();
        int a[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int  j=0;j<m;j++){
                a[i][j]=sc.nextInt();
            }
        }
        int id[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int  j=0;j<n;j++){
                if(i==j)
                    id[i][j]=1;
            }
        }

        while(power!=0){
            if(power%2==0){
                id=mul(a, a);
                power/=2;
            }else{
                id=mul(id, a);
                power--;
            }

        }
        for(int i=0;i<m;i++){
            for(int  j=0;j<m;j++){
                System.out.print(id[i][j]+"  ");
            }
            System.out.println();
        }

    }
}
