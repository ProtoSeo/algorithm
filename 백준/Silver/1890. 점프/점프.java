import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[][] dp = new long[101][101];
    static int[][] ary = new int[101][101];

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            final StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ary[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) {
                    break;
                }
                if (dp[i][j] >= 1 && i + ary[i][j] < n) {
                    dp[i + ary[i][j]][j] += dp[i][j];
                }
                if (dp[i][j] >= 1 && j + ary[i][j] < n) {
                    dp[i][j + ary[i][j]] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}
