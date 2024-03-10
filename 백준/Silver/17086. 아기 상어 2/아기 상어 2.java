import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
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
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    answer = Math.max(answer, bfs(j, i));
                }
            }
        }
        System.out.println(answer);

    }

    static int bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[n][m];

        q.add(new int[]{x, y, 0});
        isVisited[y][x] = true;

        int result = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int nx = p[0];
            int ny = p[1];
            int c = p[2];

            if (map[ny][nx] == 1) {
                result = c;
                break;
            }

            for (int k = 0; k < 8; k++) {
                int xx = nx + dx[k];
                int yy = ny + dy[k];
                if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                    continue;
                }
                if (isVisited[yy][xx]) {
                    continue;
                }
                q.add(new int[]{xx, yy, c + 1});
                isVisited[yy][xx] = true;
            }
        }
        return result;
    }
}
