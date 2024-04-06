import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        char[][] map = new char[n][m];
        var isVisited = new int[n][m];
        var fireVisited = new int[n][m];
        Deque<int[]> move = new ArrayDeque<>();
        Deque<int[]> fire = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(isVisited[i], -1);
            Arrays.fill(fireVisited[i], -1);
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'J') {
                    isVisited[i][j] = 0;
                    move.add(new int[]{j, i, 0});
                } else if (map[i][j] == 'F') {
                    fireVisited[i][j] = 0;
                    fire.add(new int[]{j, i, 0});
                }
            }
        }

        for (int i = 0; !move.isEmpty(); i++) {
            while (!fire.isEmpty() && i == fire.peek()[2]) {
                int[] p = fire.poll();
                int x = p[0];
                int y = p[1];
                int c = p[2];
                for (int j = 0; j < 4; j++) {
                    int xx = x + dx[j];
                    int yy = y + dy[j];
                    if (yy < 0 || xx < 0 || xx >= m || yy >= n) {
                        continue;
                    }
                    if (fireVisited[yy][xx] >= 0 || map[yy][xx] == '#') {
                        continue;
                    }
                    fireVisited[yy][xx] = c + 1;

                    fire.add(new int[]{xx, yy, c + 1});
                }
            }
            while (!move.isEmpty() && i == move.peek()[2]) {
                int[] p = move.poll();
                int x = p[0];
                int y = p[1];
                int c = p[2];

                for (int j = 0; j < 4; j++) {
                    int xx = x + dx[j];
                    int yy = y + dy[j];
                    if (yy < 0 || xx < 0 || xx >= m || yy >= n) {
                        System.out.println(c + 1);
                        return;
                    }
                    if (isVisited[yy][xx] >= 0 || fireVisited[yy][xx] >= 0 || map[yy][xx] == '#') {
                        continue;
                    }
                    isVisited[yy][xx] = c + 1;
                    move.add(new int[]{xx, yy, c + 1});
                }
            }
            if (move.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                break;
            }
        }
    }
}
