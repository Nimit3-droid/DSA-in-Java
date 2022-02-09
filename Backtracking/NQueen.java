import java.util.*;
import java.io.*;
public class NQueen {
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(new File("input.txt"));
        int n= sc.nextInt();
        int count[]={0};
        char mat[][]=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(mat[i],'.');
        }
        nqueen(mat,0,count);
        sc.close();
    }

    private static boolean nqueen(char mat[][],int row,int count[]) throws IOException {
        int n=mat.length;
        if(n==row){
            count[0]++;
            FileWriter fw = new FileWriter(new File("output.txt"),true);
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    fw.write(mat[i][j]+"");
                }
                fw.write('\n');
            }
            fw.write('\n');
            fw.close();
        }

        for(int col=0;col<n;col++){
            if(isSafe(mat,row,col)){
                mat[row][col]='Q';
                
                if(nqueen(mat,row+1,count)){
                    
                    return true;
                }
                mat[row][col]='.';
            }
        }

        return false;

    }

    public static boolean isSafe(char mt[][],int row, int col){
        int n=mt.length;
        if(row>=n || col>=n || row<0 || col<0){
            return false;
        }
        for(int i=row,j=col; j>=0 && j<n && i>=0 && i<n; i--){
            if(mt[i][j] =='Q'){
                return false;
            }
        }
        
        for(int i=row,j=col;( j>=0 && j<n && i>=0 && i<n); i--,j--){
            if(mt[i][j] =='Q'){
                return false;
            }
        }
        
        for(int i=row,j=col;( j>=0 && j<n && i>=0 && i<n); i--,j++){
            if(mt[i][j] =='Q'){
                return false;
            }
        }
        
        return true;
    }
}
