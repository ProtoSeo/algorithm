import java.io.*;
import java.util.*;

public class Main {

    static int n, m, p;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static char[][] map;
    static Deque<int[]>[] playerQueue;
    static int[] s;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        p = Integer.parseInt(stk.nextToken());

        playerQueue = new Deque[p + 1];
        s = new int[p + 1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= p; i++) {
            playerQueue[i] = new ArrayDeque<>();
            s[i] = Integer.parseInt(stk.nextToken());
        }

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (Character.isDigit(map[i][j])) {
                    playerQueue[map[i][j] - '0'].add(new int[]{j, i});
                }
            }
        }
        move();
        int[] answer = new int[p + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Character.isDigit(map[i][j])) {
                    answer[map[i][j] - '0']++;
                }
            }
        }
        var sb = new StringBuilder();
        for (int i = 1; i <= p; i++) {
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb);
    }

    static void move() {
        while (true) {
            for (int i = 1; i <= p; i++) {
                for (int j = 0; j < s[i] && !playerQueue[i].isEmpty(); j++) {
                    bfs(i);
                }
            }

            boolean isAllEmpty = true;
            for (int i = 1; i <= p; i++) {
                if (!playerQueue[i].isEmpty()) {
                    isAllEmpty = false;
                    break;
                }
            }
            if (isAllEmpty) {
                break;
            }
        }
    }

    static void bfs(int player) {
        Deque<int[]> nextQueue = new ArrayDeque<>();
        while (!playerQueue[player].isEmpty()) {
            int[] pair = playerQueue[player].poll();
            int x = pair[0];
            int y = pair[1];
            for (int k = 0; k < 4; k++) {
                int xx = x + dx[k];
                int yy = y + dy[k];
                if (xx < 0 || yy < 0 || xx >= m || yy >= n) {
                    continue;
                }
                if (map[yy][xx] == '.') {
                    map[yy][xx] = (char) ('0' + player);
                    nextQueue.add(new int[]{xx, yy});
                }
            }
        }
        playerQueue[player].addAll(nextQueue);
    }
}
