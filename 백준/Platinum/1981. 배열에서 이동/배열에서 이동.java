import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            var stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int l = 0;
        int r = 201;
        while (l < r) {
            int mid = (l + r) / 2;
            if (canGo(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(r);
    }

    static boolean canGo(int diff) {
        for (int i = 0; i + diff <= 200; i++) {
            if (bfs(i, i + diff)) {
                return true;
            }
        }
        return false;
    }

    static boolean bfs(int l, int r) {
        if (l > map[0][0] || map[0][0] > r) {
            return false;
        }
        boolean[][] isVisited = new boolean[n][n];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        isVisited[0][0] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];

            if (x == n - 1 && y == n - 1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];

                if (xx < 0 || yy < 0 || xx >= n || yy >= n || isVisited[yy][xx]) {
                    continue;
                }
                if (map[yy][xx] < l || map[yy][xx] > r) {
                    continue;
                }
                q.add(new int[]{xx, yy});
                isVisited[yy][xx] = true;
            }
        }
        return false;
    }
}
