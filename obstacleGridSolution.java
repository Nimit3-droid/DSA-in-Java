import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class obstacleGridSolution {

    public static void main(String[] args) {
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