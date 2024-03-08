import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stk = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(stk.nextToken());
        int w = Integer.parseInt(stk.nextToken());
        int[] plums = new int[t + 1];
        for (int i = 1; i <= t; i++) {
            plums[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[t + 1][w + 1];
        for (int i = 1; i <= t; i++) {
            int plum = plums[i];
            for (int j = 0; j <= w; j++) {
                if (j == 0) {
                    if (plum == 1) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                    continue;
                }

                if (j % 2 == 1) {
                    if (plum == 2) {
                        dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1]);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                    }
                } else if (j % 2 == 0) {
                    if (plum == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1]);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= t; i++) {
            for (int j = 0; j <= w; j++) {
                answer = Math.max(dp[i][j], answer);
            }
        }
        System.out.println(answer);
    }
}
