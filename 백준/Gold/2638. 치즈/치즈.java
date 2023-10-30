import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            final String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        ArrayDeque<Pair> air = new ArrayDeque<>();
        Set<Pair> cheese = new HashSet<>();
        boolean[][] isVisited = new boolean[n][m];
        air.add(new Pair(0, 0));
        isVisited[0][0] = true;
        int answer = 0;

        while (!air.isEmpty()) {
            while (!air.isEmpty()) {
                final Pair p = air.poll();
                int x = p.x;
                int y = p.y;
                map[y][x] = 0;

                for (int i = 0; i < 4; i++) {
                    int xx = x + dx[i];
                    int yy = y + dy[i];

                    if (xx < 0 || yy < 0 || xx >= m || yy >= n || isVisited[yy][xx]) {
                        continue;
                    }

                    if (map[yy][xx] == 0) {
                        air.add(new Pair(xx, yy));
                        isVisited[yy][xx] = true;
                    }
                    if (map[yy][xx] == 1) {
                        cheese.add(new Pair(xx, yy));
                    }
                }
            }
            if (cheese.isEmpty()) {
                break;
            }
            for (Pair p : cheese) {
                int x = p.x;
                int y = p.y;

                int count = 0;
                for (int i = 0; i < 4; i++) {
                    int xx = x + dx[i];
                    int yy = y + dy[i];
                    if (isVisited[yy][xx] && map[yy][xx] == 0) {
                        count++;
                    }
                }
                if (count >= 2) {
                    air.add(new Pair(x, y));
                    isVisited[y][x] = true;
                }
            }
            cheese = new HashSet<>();
            answer++;
        }
        System.out.println(answer);
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
