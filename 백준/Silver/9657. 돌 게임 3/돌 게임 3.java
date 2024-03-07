import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[1001];
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        dp[4] = true;
        for (int i = 5; i <= 1000; i++) {
            dp[i] = !(dp[i - 1] && dp[i - 3] && dp[i - 4]);
        }
        System.out.println(dp[n] ? "SK" : "CY");
    }
}
