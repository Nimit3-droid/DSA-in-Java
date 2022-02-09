import java.util.*;
public class sudoko {
    
    public static void main(String[] args){
        char mat[][]=new char[9][9];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<9;i++){
            String s=sc.next();
            for(int j=0;j<9;j++){
                mat[i][j]=s.charAt(j);
            }
        }
        sc.close();
        int mat1[][]=new int[9][9];
        int mat2[][]=new int[9][9];
        int mat3[][]=new int[9][9];
        for(int i=0;i<9;i++) {
            Arrays.fill(mat1[i], 0);
            Arrays.fill(mat2[i], 0);
            Arrays.fill(mat3[i], 0);
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(mat[i][j]!='.'){
                    int num=mat[i][j]-1-'0';
                    int k=3*(i/3)+j/3;
                    if(mat1[i][num]==1 || mat2[j][num]==1 || mat3[k][num]==1){
                        System.out.println("NO");
                        return ;
                    
                    }
                    mat1[i][num]= mat2[j][num]= mat3[k][num]=1;
                }
            }
        }
        System.out.println("YES");
    }
}
