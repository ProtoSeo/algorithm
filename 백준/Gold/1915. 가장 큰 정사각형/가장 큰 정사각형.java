import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[][] ary = new int[n][m];
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                ary[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][m - 1] = ary[i][m - 1];
        }
        for (int i = 0; i < m; i++) {
            dp[n - 1][i] = ary[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (ary[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1])) + 1;
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(dp[i][j], answer);
            }
        }
        System.out.println(answer * answer);
    }
}
