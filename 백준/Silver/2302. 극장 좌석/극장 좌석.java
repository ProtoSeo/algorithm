import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int now = 1;
        int answer = 1;
        for (int i = 0; i < m; i++) {
            int s = Integer.parseInt(br.readLine());
            answer *= dp[s - now];
            now = s + 1;
        }
        System.out.println(answer * dp[n - now + 1]);
    }
}