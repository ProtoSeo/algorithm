import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, -1, 1, -1, 1};
    static int n, m;
    static int[][] ary;
    static Pair[][] cache;
    static int[][] ballCount;

    public static void main(String[] args) throws IOException {
        final var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        ary = new int[n][m];
        ballCount = new int[n][m];
        cache = new Pair[n][m];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Pair result = move(j, i);
                ballCount[result.y][result.x]++;
            }
        }

        var sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(ballCount[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static Pair move(int x, int y) {
        if (cache[y][x] != null) {
            return cache[y][x];
        }
        int nx = x;
        int ny = y;
        int value = ary[y][x];
        for (int i = 0; i < 8; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx < 0 || yy < 0 || yy >= n || xx >= m) {
                continue;
            }
            if (value > ary[yy][xx]) {
                nx = xx;
                ny = yy;
                value = ary[yy][xx];
            }
        }
        if (nx == x && ny == y) {
            return cache[y][x] = new Pair(x, y);
        }
        return cache[y][x] = move(nx, ny);
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
