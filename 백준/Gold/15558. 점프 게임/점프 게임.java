import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int[][] map = new int[2][n];
        boolean[][] isVisited = new boolean[2][n];

        for (int i = 0; i < 2; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0});
        isVisited[0][0] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int y = p[0];
            int x = p[1];
            int c = p[2];

            if (x + 1 >= n || x + k >= n) {
                System.out.println(1);
                return;
            }
            if (x + 1 < n && map[y][x + 1] == 1 && !isVisited[y][x + 1]) {
                q.add(new int[]{y, x + 1, c + 1});
                isVisited[y][x + 1] = true;
            }
            if (x - 1 > c && map[y][x - 1] == 1 && !isVisited[y][x - 1]) {
                q.add(new int[]{y, x - 1, c + 1});
                isVisited[y][x - 1] = true;
            }
            if (x + k < n && map[(y + 1) % 2][x + k] == 1 && !isVisited[(y + 1) % 2][x + k]) {
                q.add(new int[]{(y + 1) % 2, x + k, c + 1});
                isVisited[(y + 1) % 2][x + k] = true;
            }
        }
        System.out.println(0);
    }
}