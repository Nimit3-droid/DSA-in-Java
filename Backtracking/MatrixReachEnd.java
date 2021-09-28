import java.util.*;
public class MatrixReachEnd {
    public static void reachTheEnd(char[][] grid,int maxTime){
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        if(dfs(grid,0,0,vis) <= maxTime) System.out.println("Yes");
        else System.out.println("No");
    }

    public static int dfs(char[][] grid,int i,int j,boolean[][] vis){
        if(!isSafe(grid,i,j,vis)) return Integer.MAX_VALUE;
        if(i==grid.length-1 && j==grid[0].length-1) return 0;

        vis[i][j] = true;

        int ans=min(dfs(grid,i+1,j,vis),dfs(grid,i-1,j,vis),dfs(grid,i,j+1,vis),dfs(grid,i,j-1,vis));
        vis[i][j] = false;
        return ans==Integer.MAX_VALUE?ans:ans+1;
    }

    private static int min(int a, int b, int c, int d) {
        return Math.min(a,Math.min(b,Math.min(c,d)));
    }

    private static boolean isSafe(char[][] grid, int i, int j, boolean[][] vis) {
        return i>=0 && i< grid.length && j>=0 && j<grid[0].length && !vis[i][j] && grid[i][j]=='.';
    }
    public static void main(String[] args){
        List<String> list=new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0; i<n; i++){
            String line =sc.next();
            list.add(line);
        }

        char[][] mat=new char[n][];
        int i=0;
        for(String s: list){
            mat[i++]=s.toCharArray();
        }
        int maxTime=sc.nextInt();
        reachTheEnd(mat,maxTime);
    }
}
