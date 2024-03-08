import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] ary;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ary = new int[n + 1];
        dp = new int[n + 1][n + 1];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            ary[i] = Integer.parseInt(stk.nextToken());
            Arrays.fill(dp[i], -1);
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            sb.append(find(s, e)).append('\n');
        }
        System.out.print(sb);
    }

    static int find(int s, int e) {
        if (dp[s][e] >= 0) {
            return dp[s][e];
        }
        if (s == e) {
            return dp[s][e] = 1;
        } else if (e - s == 1) {
            return dp[s][e] = (ary[e] == ary[s]) ? 1 : 0;
        } else {
            return dp[s][e] = (ary[e] == ary[s] && find(s + 1, e - 1) == 1) ? 1 : 0;
        }
    }
}
