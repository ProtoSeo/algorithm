import java.io.*;
import java.util.*;

public class Main {
    static List<Pair> viruses = new ArrayList<>();
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int n, m, emptyCount;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if (map[i][j] == 2) {
                    viruses.add(new Pair(j, i));
                } else if (map[i][j] == 0) {
                    emptyCount++;
                }
            }
        }
        final int result = selectVirus(0, 0, new boolean[viruses.size()]);
        System.out.println((result == Integer.MAX_VALUE) ? -1 : result);
    }

    static int selectVirus(int num, int now, boolean[] isSelected) {
        if (now >= m) {
            return bfs(isSelected, emptyCount);
        }
        int result = Integer.MAX_VALUE;
        for (int i = num; i < viruses.size(); i++) {
            if (isSelected[i]) {
                continue;
            }
            isSelected[i] = true;
            result = Math.min(result, selectVirus(i + 1, now + 1, isSelected));
            isSelected[i] = false;
        }
        return result;
    }

    static int bfs(boolean[] isSelected, int emptyCount) {
        Deque<int[]> q = new ArrayDeque<>();
        int[][] isVisited = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(isVisited[i], -1);
        }
        for (int i = 0; i < viruses.size(); i++) {
            if (isSelected[i]) {
                Pair virus = viruses.get(i);
                q.add(new int[]{virus.x, virus.y, 0});
                isVisited[virus.y][virus.x] = 0;
            }
        }

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            int c = p[2];

            if (map[y][x] == 0) {
                emptyCount--;
            }
            if (emptyCount == 0) {
                return c;
            }

            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx < 0 || xx >= n || yy < 0 || yy >= n) {
                    continue;
                }
                if (isVisited[yy][xx] >= 0 || map[yy][xx] == 1) {
                    continue;
                }
                isVisited[yy][xx] = c + 1;
                q.add(new int[]{xx, yy, c + 1});
            }
        }
        return Integer.MAX_VALUE;
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
