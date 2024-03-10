import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] ary;
    static long[][] dp = new long[21][101];

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        ary = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(stk.nextToken());
        }

        dp[ary[0]][0] = 1;
        for (int i = 1; i < n - 1; i++) {
            int num = ary[i];
            for (int j = 0; j <= 20; j++) {
                if (dp[j][i - 1] <= 0) {
                    continue;
                }
                if (j - num >= 0) {
                    dp[j - num][i] += dp[j][i - 1];
                }
                if (j + num <= 20) {
                    dp[j + num][i] += dp[j][i - 1];
                }
            }
        }
        System.out.println(dp[ary[n - 1]][n - 2]);
    }
}
