import java.io.*;
import java.util.*;

public class Main {

    static int[][] ary;
    static long[][][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ary = new int[n][n];
        for (int i = 0; i < n; i++) {
            final StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ary[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dp = new long[n][n][3];
        dp[0][1][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n && ary[i][j + 1] == 0) {
                    dp[i][j + 1][0] += dp[i][j][0] + dp[i][j][1];
                }
                if (i + 1 < n && j + 1 < n && ary[i][j + 1] == 0 && ary[i + 1][j] == 0 && ary[i + 1][j + 1] == 0) {
                    dp[i + 1][j + 1][1] += dp[i][j][0] + dp[i][j][1] + dp[i][j][2];
                }
                if (i + 1 < n && ary[i + 1][j] == 0) {
                    dp[i + 1][j][2] += dp[i][j][1] + dp[i][j][2];
                }
            }
        }
        System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
    }
}
