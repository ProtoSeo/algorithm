import java.io.*;
import java.util.*;

public class Main {
    static int[][][] dp = new int[61][61][61];
    static int[][] damages = {{1, 3, 9}, {1, 9, 3}, {3, 1, 9}, {3, 9, 1}, {9, 1, 3}, {9, 3, 1}};

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <= 60; i++) {
            for (int j = 0; j <= 60; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] hp = new int[3];
        for (int i = 0; i < n; i++) {
            hp[i] = Integer.parseInt(stk.nextToken());
        }
        System.out.println(find(hp[0], hp[1], hp[2]));
    }

    static int find(int a, int b, int c) {
        if (a == 0 && b == 0 && c == 0) {
            return 0;
        }
        if (dp[a][b][c] != Integer.MAX_VALUE) {
            return dp[a][b][c];
        }
        for (int[] damage : damages) {
            int aa = Math.max(a - damage[0], 0);
            int bb = Math.max(b - damage[1], 0);
            int cc = Math.max(c - damage[2], 0);

            dp[a][b][c] = Math.min(dp[a][b][c], find(aa, bb, cc) + 1);
        }
        return dp[a][b][c];
    }
}
