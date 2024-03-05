import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[2000005];
        dp[1000000] = 0;
        dp[1000001] = 1;
        for (int i = 1000002; i <= 2000000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
        }
        for (int i = 1000001; i >= 2; i--) {
            dp[i - 2] = (dp[i] - dp[i - 1]) % 1000000000;
        }

        int result = dp[1000000 + n];
        if (result == 0) {
            System.out.println(0);
        } else if (result < 0) {
            System.out.println(-1);
        } else {
            System.out.println(1);
        }
        System.out.println(Math.abs(result));
    }
}
