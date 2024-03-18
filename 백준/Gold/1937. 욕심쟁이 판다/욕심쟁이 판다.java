import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int[][] map = new int[501][501];
    static int[][] dp = new int[501][501];

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, find(j, i));
            }
        }
        System.out.println(answer);
    }

    private static int find(int x, int y) {
        if (dp[y][x] > 0) {
            return dp[y][x];
        }
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (yy < 0 || xx < 0 || yy >= n || xx >= n) {
                continue;
            }
            if (map[yy][xx] <= map[y][x]) {
                continue;
            }
            result = Math.max(result, find(xx, yy));
        }
        return dp[y][x] = result + 1;
    }
}
