import java.util.*;
public class HamiltonianCycle {
    static ArrayList<String> ans=new ArrayList<String>();
    public static void path(int mat[][],int src,HashSet<Integer> visited,int orsrc,String path) {
        visited.add(src);
        if(visited.size()==mat.length && mat[src][orsrc]!=0){
            ans.add(path+" "+src+" "+ orsrc);
        }
        for(int i=0;i<mat[0].length;i++){
            if(!visited.contains(i) && mat[src][i]==1){
                path(mat, i, visited, orsrc, path+" "+src);
            }
        }
        visited.remove(src);

    }
    public static void main(String[] args){
        HashSet<Integer> visited=new HashSet<Integer>();
        int mat[][] = {{0, 1, 0, 1, 0},
        {1, 0, 1, 1, 1},
        {0, 1, 0, 0, 1},
        {1, 1, 0, 0, 0},
        {0, 1, 1, 0, 0},
    };
    int mat2[][] = {{0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0},
        };
        path(mat,2,visited,2,"");
        System.out.println(ans);
        path(mat2,2,visited,2,"");
        System.out.println(ans);
    }
}
