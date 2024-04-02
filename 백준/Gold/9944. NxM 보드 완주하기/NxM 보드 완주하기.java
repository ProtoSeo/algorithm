import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static char[][] map;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 1;
        var sb = new StringBuilder();
        String str;
        while ((str = br.readLine()) != null) {
            var stk = new StringTokenizer(str);
            n = Integer.parseInt(stk.nextToken());
            m = Integer.parseInt(stk.nextToken());
            map = new char[n][m];

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == '.') {
                        cnt++;
                    }
                }
            }
            int answer = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == '.') {
                        map[i][j] = '#';
                        int result = find(j, i, cnt - 1);
                        if (result != -1 && (answer == -1 || answer > result)) {
                            answer = result;
                        }
                        map[i][j] = '.';
                    }
                }
            }
            sb.append("Case ").append(idx++).append(": ").append(answer).append('\n');
        }
        System.out.println(sb);
    }

    static int find(int x, int y, int cnt) {
        int answer = -1;
        if (cnt == 0) {
            return 0;
        }
        for (int i = 0; i < 4; i++) {
            int xx = x;
            int yy = y;
            while (canGo(xx + dx[i], yy + dy[i]) && map[yy + dy[i]][xx + dx[i]] == '.') {
                xx = xx + dx[i];
                yy = yy + dy[i];
                map[yy][xx] = '#';
                cnt--;
            }
            if (xx != x || yy != y) {
                int result = find(xx, yy, cnt);
                if (result != -1 && (answer == -1 || answer > result + 1)) {
                    answer = result + 1;
                }
            }
            while (xx != x || yy != y) {
                map[yy][xx] = '.';
                cnt++;
                xx = xx - dx[i];
                yy = yy - dy[i];
            }
        }
        return answer;
    }

    static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && y < n && x < m;
    }
}
