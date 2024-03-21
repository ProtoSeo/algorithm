import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] map = new char[5][5];

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int answer = find(0, 0, new int[7]);
        System.out.println(answer);
    }

    static int find(int cnt, int idx, int[] selected) {
        if (cnt >= 7) {
            return bfs(selected);
        }
        int result = 0;
        for (int i = idx; i < 25; i++) {
            selected[cnt] = i;
            result += find(cnt + 1, i + 1, selected);
        }
        return result;
    }

    static int bfs(int[] selected) {
        boolean[] isVisited = new boolean[7];
        Deque<Integer> q = new ArrayDeque<>();
        q.add(selected[0]);
        isVisited[0] = true;

        int sCnt = 0;
        while (!q.isEmpty()) {
            int p = q.poll();
            int x = p % 5;
            int y = p / 5;

            if (map[y][x] == 'S') {
                sCnt++;
            }
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx < 0 || yy < 0 || xx >= 5 || yy >= 5) {
                    continue;
                }
                for (int j = 0; j < 7; j++) {
                    if (isVisited[j]) {
                        continue;
                    }
                    int nx = selected[j] % 5;
                    int ny = selected[j] / 5;
                    if (xx != nx || yy != ny) {
                        continue;
                    }
                    q.add(selected[j]);
                    isVisited[j] = true;
                }
            }
        }
        boolean canAllVisit = true;
        for (int i = 0; i < 7; i++) {
            canAllVisit &= isVisited[i];
        }
        if (canAllVisit && sCnt >= 4) {
            return 1;
        }
        return 0;
    }
}
