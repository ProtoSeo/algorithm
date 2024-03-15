import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        final StringBuilder sb = new StringBuilder();
        long[][] dp = new long[1001][1001];
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][3] = 1;
        dp[3][2] = 2;
        for (int i = 4; i <= 1000; i++) {
            for (int j = 2; j <= i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 2][j - 1] + dp[i - 3][j - 1]) % 1_000_000_009;
            }
        }
        while (t-- > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            sb.append(dp[n][m]).append('\n');
        }
        System.out.print(sb);
    }
}
