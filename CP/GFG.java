package CP;
import java.util.*;
import static java.lang.Math.max;
public class ct {
	static int MaximumPath(int mat[][],int N,int M,int s,int p){
		int res = mat[s][p];
 
        for (int i = 1; i < N; i++){
            res = -1;
            for (int j = 0; j < M; j++)
            {
                if (j > 0 && j < M - 1)
                    mat[i][j] += max(mat[i - 1][j],
                                 max(mat[i - 1][j - 1],
                                    mat[i - 1][j + 1]));
 
                else if (j > 0)
                    mat[i][j] += max(mat[i - 1][j],
                                    mat[i - 1][j - 1]);
 
                else if (j < M - 1)
                    mat[i][j] += max(mat[i - 1][j],
                                mat[i - 1][j + 1]);
 
                res = max(mat[i][j], res);
            }
        }
        return res;
	}
    private static int MaximumPath2(int[][] mat,int N,int M,int s,int p) {
        int res = mat[s][p];
        for (int i = N-2; i >=0; i--){
            res = -1;
            for (int j = 0; j < M; j++){
                if (j > 0 && j < M - 1)
                    mat[i][j] += max(mat[i + 1][j],
                                 max(mat[i + 1][j + 1],
                                    mat[i + 1][j - 1]));
 
                else if (j > 0)
                    mat[i][j] += max(mat[i + 1][j],
                                    mat[i + 1][j - 1]);
 
                else if (j < M - 1)
                    mat[i][j] += max(mat[i + 1][j],
                                mat[i + 1][j + 1]);
 
                res = max(mat[i][j], res);
            }
        }
        return res;
    }
	
	public static void main(String arg[]){
		Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int p=sc.nextInt();
        int q=sc.nextInt();
        sc.close();
        int Mat[][]=new int[n][m];
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                Mat[i][j]=arr[i][j];
            }
        }
        Mat[0][p]=arr[0][p];
		int ans =MaximumPath(Mat,n,m,0,p);
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m;j++){
                Mat[i][j]=arr[i][j];
            }
        }
        Arrays.fill(Mat[n-1],0);
        Mat[n-1][q]=arr[n-1][q];
        ans=Math.max(MaximumPath2(Mat,n,m,n-1,q),ans);
        System.out.println(ans);
	}

}


