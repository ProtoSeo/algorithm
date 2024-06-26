import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j <= i - 2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j - 1] * j);
            }
        }
        System.out.println(dp[n]);
    }
}
