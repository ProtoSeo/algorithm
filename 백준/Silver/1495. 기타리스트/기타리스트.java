import java.io.*;
import java.util.*;

public class Main {
    static int n, s, m;
    static int[] v;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        s = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        v = new int[n + 1];
        dp = new boolean[n + 1][m + 1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            v[i] = Integer.parseInt(stk.nextToken());
        }

        dp[0][s] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (!dp[i - 1][j]) {
                    continue;
                }
                if (j + v[i] <= m) {
                    dp[i][j + v[i]] = true;
                }
                if (j - v[i] >= 0) {
                    dp[i][j - v[i]] = true;
                }
            }
        }
        int answer = -1;
        for (int i = m; i >= 0; i--) {
            if (dp[n][i]) {
                answer = Math.max(answer, i);
            }
        }
        System.out.println(answer);
    }
}
