import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.charAt(0) - '0' == 0) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= str.length(); i++) {
            int prev = str.charAt(i - 2) - '0';
            int now = str.charAt(i - 1) - '0';
            int num = prev * 10 + now;
            if (prev == 0 && now == 0) {
                System.out.println(0);
                return;
            }
            if (prev != 0 && num <= 26) {
                dp[i] += dp[i - 2];
            }
            if (now != 0) {
                dp[i] += dp[i - 1];
            }
            dp[i] %= 1000000;
        }
        System.out.println(dp[str.length()]);
    }
}
