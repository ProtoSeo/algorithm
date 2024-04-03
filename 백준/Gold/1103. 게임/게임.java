import java.io.*;
import java.util.*;

public class Main {

    static int n, m, answer;
    static boolean hasCycle = false;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] ary;
    static int[][] dp;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        dp = new int[n][m];
        ary = new int[n][m];
        isVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            var str = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                if (c == 'H') {
                    ary[i][j] = -1;
                    continue;
                }
                ary[i][j] = c - '0';
            }
        }
        isVisited[0][0] = true;
        go(0, 0, 1);
        System.out.println(hasCycle ? -1 : answer);
    }

    static void go(int x, int y, int count) {
        dp[y][x] = count;
        answer = Math.max(answer, count);
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i] * ary[y][x];
            int yy = y + dy[i] * ary[y][x];
            if (xx < 0 || yy < 0 || xx >= m || yy >= n) {
                continue;
            }
            if (ary[yy][xx] == -1 || dp[yy][xx] > count) {
                continue;
            }
            if (isVisited[yy][xx]) {
                hasCycle = true;
                return;
            }
            isVisited[yy][xx] = true;
            go(xx, yy, count + 1);
            isVisited[yy][xx] = false;
        }
    }
}
