import java.util.*;

public class RatInMaze {

    //Time and space Complexity: O(3^(n^2)). 
    static String path = "";
    
    public static boolean isSafe(int mat[][], int r, int c, int x, int y, int visited[][]) {
        if (x == -1 || x == r || y == -1 || y == c || visited[x][y] == 1 || mat[x][y] == 0)
            return false;

        return true;
    }

    public static void findDirections(int mat[][], int r, int c, int x, int y, int[][] visited, ArrayList<String> ans ) {
        if(!isSafe(mat, r, c, x, y, visited)) return;
        if (x == r - 1 && y == c - 1) {
            ans.add(path);
            return;
        }
        visited[x][y] = 1;
        if (isSafe(mat, r, c, x, y + 1, visited)) {
            path += 'R';
            findDirections(mat, r, c, x, y + 1, visited,ans);
            path = path.substring(0, path.length() - 1);
        }
        if (isSafe(mat, r, c, x + 1, y, visited)) {
            path += 'D';
            findDirections(mat, r, c, x + 1, y, visited,ans);
            path = path.substring(0, path.length() - 1);
        }
        if (isSafe(mat, r, c, x, y - 1, visited)) {
            path += 'L';
            findDirections(mat, r, c, x, y - 1, visited,ans);
            path = path.substring(0, path.length() - 1);
        }
        if (isSafe(mat, r, c, x - 1, y, visited)) {
            path += 'U';
            findDirections(mat, r, c, x - 1, y, visited,ans);
            path = path.substring(0, path.length() - 1);
        }
        visited[x][y] = 0;
    }

    public static ArrayList<String> findDirections(int mat[][], int r, int c) {

        int visited[][] = new int[r][c];
        ArrayList<String> ans = new ArrayList<String>();
        findDirections(mat, r, c, 0, 0, visited,ans);
        return ans;
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int r=sc.nextInt(), c=sc.nextInt();
        // int matrix[][]=new int[r][c];
        // for(int i=0; i<r; i++){
        // for(int j=0; j<c; j++){
        // matrix[i][j]=sc.nextInt();
        // }
        // }
        int matrix[][] = { { 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 1 } };
        int r = 5, c = 5;
        ArrayList<String> d = findDirections(matrix, r, c);
        for (String ans : d) {
            System.out.println(ans);
        }
    }
}
