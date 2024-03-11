import java.io.*;
import java.util.*;

public class Main {
    static boolean[][][] isVisited = new boolean[201][201][201];

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] lmt = new int[3];
        for (int i = 0; i < 3; i++) {
            lmt[i] = Integer.parseInt(stk.nextToken());
        }

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, lmt[2]});
        isVisited[0][0][lmt[2]] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        continue;
                    }
                    int from = Math.max(p[i] + p[j] - lmt[j], 0);
                    int to = Math.min(p[i] + p[j], lmt[j]);
                    int none = p[3 - i - j];

                    if (i == 0 && j == 1) {
                        update(from, to, none, q);
                    } else if (i == 0 && j == 2) {
                        update(from, none, to, q);
                    } else if (i == 1 && j == 0) {
                        update(to, from, none, q);
                    } else if (i == 1 && j == 2) {
                        update(none, from, to, q);
                    } else if (i == 2 && j == 0) {
                        update(to, none, from, q);
                    } else if (i == 2 && j == 1) {
                        update(none, to, from, q);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = lmt[1]; i >= 0; i--) {
            if (lmt[2] - i >= 0 && isVisited[0][i][lmt[2] - i]) {
                sb.append(lmt[2] - i).append(' ');
            }
        }
        System.out.println(sb);
    }

    static void update(int a, int b, int c, Deque<int[]> q) {
        if (isVisited[a][b][c]) {
            return;
        }
        isVisited[a][b][c] = true;
        q.add(new int[]{a, b, c});
    }
}
