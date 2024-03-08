import java.io.*;

public class Main {
    static int[][] dp = new int[1001][1001];

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        if (k > n / 2) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][1] = i;
        }
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % 1_000_000_003;
            }
        }
        System.out.println(dp[n][k]);
    }
}
