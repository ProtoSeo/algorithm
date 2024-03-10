import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer;
    static int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    q.add(new int[]{j, i, 0});
                    isVisited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int nx = p[0];
            int ny = p[1];
            int c = p[2];
            answer = Math.max(c, answer);

            for (int k = 0; k < 8; k++) {
                int xx = nx + dx[k];
                int yy = ny + dy[k];
                if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                    continue;
                }
                if (isVisited[yy][xx] || map[yy][xx] == 1) {
                    continue;
                }
                q.add(new int[]{xx, yy, c + 1});
                isVisited[yy][xx] = true;
            }
        }
    }
}
