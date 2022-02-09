import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class countPallindromicSubsecq {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        String str = sc.nextLine();
        int dp[][] = new int[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans=countPallindromicSubsecqDP(str, 0, str.length() - 1, dp);
        FileWriter fw = new FileWriter(new File("output.txt"));
        fw.write(ans + "\n");
        fw.close();
        sc.close();
    }

    private static int countPallindromicSubsecqDP(String str, int i, int j, int[][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (i == j) {
            dp[i][j] = 1;
            return 1;
        }
        if (str.charAt(i) == str.charAt(j)) {
            return dp[i][j] = 1 + countPallindromicSubsecqDP(str, i + 1, j, dp)
                    + countPallindromicSubsecqDP(str, i, j - 1, dp);

        } else {
            return dp[i][j] = 1 + countPallindromicSubsecqDP(str, i + 1, j, dp)
                    + countPallindromicSubsecqDP(str, i, j - 1, dp) + countPallindromicSubsecqDP(str, i + 1, j - 1, dp);

        }
    }
}