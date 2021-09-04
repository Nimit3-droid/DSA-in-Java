import java.util.*;

public class Knight {
    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static boolean isSafe(int x, int y, int n, boolean visited[][]) {
        if (x >= n || y >= n || x < 0 || y < 0 || visited[x][y])
            return false;
        return true;
    }

    public static int minstepsUtill(int n, int x, int y, int f1, int f2, boolean visited[][], int dist[][],
            int step[][]) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (curr.first == f1 && curr.second == f2) {
                return step[curr.first][curr.second];
            }
            for (int i = 0; i < 8; i++) {
                if (isSafe(dist[i][0] + curr.first, dist[i][1] + curr.second, n, visited)) {
                    visited[dist[i][0] + curr.first][dist[i][1] + curr.second] = true;
                    q.add(new Pair(dist[i][0] + curr.first, dist[i][1] + curr.second));
                    step[dist[i][0] + curr.first][dist[i][1] + curr.second] = step[curr.first][curr.second] + 1;
                }
            }
        }
        return -1;
    }

    public static void minSteps(int n, int s1, int s2, int f1, int f2) {
        // x,y = > x+2 y+1 , x+2 y-1, x-2 y-1, x-2 y+1 ,x+1 y+2 , x+1 y-2, x-1 y-2, x-1
        // y+2
        boolean visited[][] = new boolean[n][n];
        int step[][] = new int[n][n];
        int dist[][] = { { 2, 1 }, { 2, -1 }, { -2, -1 }, { -2, 1 }, { 1, 2 }, { 1, -2 }, { -1, -2 }, { -1, 2 } };
        int st = minstepsUtill(n, s1, s2, f1, f2, visited, dist, step);
        System.out.println("ans : " + st);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), s1 = sc.nextInt(), s2 = sc.nextInt(), f1 = sc.nextInt(), f2 = sc.nextInt();
        minSteps(n, s1, s2, f1, f2);
    }

}
