import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static String str;
    static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        str = br.readLine();
        Arrays.fill(dp, 987654321);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            for (int j = i + 1; j < n; j++) {
                int update = (i - j) * (i - j);
                if ((c == 'J' && str.charAt(j) == 'B') || (c == 'O' && str.charAt(j) == 'J') || (c == 'B' && str.charAt(j) == 'O')) {
                    dp[j] = Math.min(dp[j], dp[i] + update);
                }
            }
        }
        System.out.println(dp[n - 1] == 987654321 ? -1 : dp[n - 1]);
    }
}