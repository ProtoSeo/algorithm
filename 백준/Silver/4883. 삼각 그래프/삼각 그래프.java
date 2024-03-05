import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int[][] dp = new int[n][3];
            String[] split = br.readLine().split(" ");
            dp[0][0] = Integer.MAX_VALUE;
            dp[0][1] = Integer.parseInt(split[1]);
            dp[0][2] = dp[0][1] + Integer.parseInt(split[2]);

            for (int i = 1; i < n; i++) {
                split = br.readLine().split(" ");
                dp[i][0] = Integer.parseInt(split[0]) + Math.min(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = Integer.parseInt(split[1]) + Math.min(Math.min(dp[i][0], dp[i - 1][0]), Math.min(dp[i - 1][1], dp[i - 1][2]));
                dp[i][2] = Integer.parseInt(split[2]) + Math.min(dp[i][1], Math.min(dp[i - 1][1], dp[i - 1][2]));
            }

            sb.append(t++).append(". ").append(dp[n - 1][1]).append('\n');
            n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }
}
