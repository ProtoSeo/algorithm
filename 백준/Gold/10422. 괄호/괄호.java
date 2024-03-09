import java.io.*;

public class Main {
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[5001][2];
        dp[2][0] = 1;
        for (int i = 4; i <= 5000; i += 2) {
            dp[i][0] = (dp[i - 2][0] + dp[i - 2][1]) % MOD;
            for (int j = 2; j < i; j += 2) {
                dp[i][1] += (((dp[j][0] + dp[j][1]) % MOD) * dp[i - j][0]) % MOD;
            }
            dp[i][1] %= MOD;
        }
        int t = Integer.parseInt(br.readLine());
        final StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append((dp[n][0] + dp[n][1]) % 1000000007).append('\n');
        }
        System.out.println(sb);
    }
}
