import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(stk.nextToken());
            dp[m] = dp[m - 1] + 1;
            max = Math.max(max, dp[m]);
        }
        System.out.println(n - max);
    }
}