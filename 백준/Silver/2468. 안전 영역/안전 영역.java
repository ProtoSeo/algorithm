import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int min = 101;
        int max = 0;
        for (int i = 0; i < n; i++) {
            var stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }
        int answer = 1;
        for (int i = min; i <= max; i++) {
            answer = Math.max(bfs(i), answer);
        }
        System.out.println(answer);
    }

    static int bfs(int value) {
        int result = 0;
        boolean[][] isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                var q = new ArrayDeque<int[]>();
                if (!isVisited[i][j] && map[i][j] > value) {
                    result++;
                    q.add(new int[]{j, i});
                    isVisited[i][j] = true;
                    while (!q.isEmpty()) {
                        var p = q.poll();
                        int x = p[0];
                        int y = p[1];

                        for (int k = 0; k < 4; k++) {
                            int xx = x + dx[k];
                            int yy = y + dy[k];
                            if (yy < 0 || xx < 0 || xx >= n || yy >= n || isVisited[yy][xx] || map[yy][xx] <= value) {
                                continue;
                            }
                            q.add(new int[]{xx, yy});
                            isVisited[yy][xx] = true;
                        }
                    }
                }
            }
        }
        return result;
    }
}
