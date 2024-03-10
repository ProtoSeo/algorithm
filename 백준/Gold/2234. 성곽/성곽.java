import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] ary;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());
        ary = new int[n][m];
        map = new int[n][m];
        adjList = new List[n * m];
        for (int i = 0; i < n * m; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], -1);
        }

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(stk.nextToken());
                for (int k = 0; k < 4; k++) {
                    if ((ary[i][j] & (1 << k)) == 0) {
                        int xx = j + dx[k];
                        int yy = i + dy[k];
                        int s = i * m + j;
                        int e = yy * m + xx;
                        adjList[s].add(e);
                    }
                }
            }
        }

        int roomCnt = 0;
        int maxSize = 0;
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] >= 0) {
                    continue;
                }
                int idx = i * m + j;
                int size = bfs(j, i);
                result.put(idx, size);
                roomCnt++;
                maxSize = Math.max(maxSize, size);
            }
        }

        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + 1 < n && map[i][j] != map[i + 1][j]) {
                    maxSum = Math.max(maxSum, result.get(map[i][j]) + result.get(map[i + 1][j]));
                }
                if (j + 1 < m && map[i][j] != map[i][j + 1]) {
                    maxSum = Math.max(maxSum, result.get(map[i][j]) + result.get(map[i][j + 1]));
                }
            }
        }
        System.out.println(roomCnt + "\n" + maxSize + "\n" + maxSum);
    }

    static int bfs(int x, int y) {
        int idx = y * m + x;
        int size = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        map[y][x] = idx;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int nx = p[0];
            int ny = p[1];
            int now = ny * m + nx;
            size++;

            for (int next : adjList[now]) {
                int yy = next / m;
                int xx = next % m;
                if (map[yy][xx] >= 0) {
                    continue;
                }
                q.add(new int[]{xx, yy});
                map[yy][xx] = idx;
            }
        }
        return size;
    }
}
