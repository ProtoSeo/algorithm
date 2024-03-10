import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] map;
    static int[][] colors;
    static int[] dx = {-1, -1, 0, 1, 1, 0};
    static int[] dy = {0, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        colors = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'X' && colors[i][j] == 0) {
                    bfs(j, i);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'X') {
                    int now = colors[i][j];
                    answer = Math.max(answer, now);
                    for (int k = 0; k < 6; k++) {
                        int xx = j + dx[k];
                        int yy = i + dy[k];
                        if (xx < 0 || xx >= n || yy < 0 || yy >= n) {
                            continue;
                        }
                        if (map[yy][xx] == 'X' && colors[yy][xx] == now) {
                            answer = 3;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static void bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y, 1});
        colors[y][x] = 1;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int nx = p[0];
            int ny = p[1];
            int c = p[2];

            for (int i = 0; i < 6; i++) {
                int xx = nx + dx[i];
                int yy = ny + dy[i];
                if (xx < 0 || xx >= n || yy < 0 || yy >= n) {
                    continue;
                }
                if (map[yy][xx] != 'X' || colors[yy][xx] != 0) {
                    continue;
                }
                q.add(new int[]{xx, yy, 3 - c});
                colors[yy][xx] = 3 - c;
            }
        }
    }
}
