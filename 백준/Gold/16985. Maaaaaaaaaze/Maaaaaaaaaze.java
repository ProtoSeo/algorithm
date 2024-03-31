import java.io.*;
import java.util.*;

public class Main {

    static int answer = -1;
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static int[][][][] boards = new int[5][4][5][5];
    static int[][] directions = new int[4 * 4 * 4 * 4 * 4][5];

    public static void main(String[] args) throws IOException {
        final var br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                var stk = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    boards[i][0][j][k] = Integer.parseInt(stk.nextToken());
                }
            }
        }
        rotate();
        createDirections();
        findOrder(0, new int[5], new boolean[5]);
        System.out.println(answer);
    }

    static void rotate() {
        for (int i = 0; i < 5; i++) {
            int[][] originalBoard = boards[i][0];

            for (int j = 1; j < 4; j++) {
                int[][] destBoard = new int[5][5];
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        destBoard[l][5 - k - 1] = originalBoard[k][l];
                    }
                }
                boards[i][j] = destBoard;
                originalBoard = destBoard;
            }
        }
    }

    static void createDirections() {
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        for (int m = 0; m < 4; m++) {
                            directions[idx++] = new int[]{i, j, k, l, m};
                        }
                    }
                }
            }
        }
    }

    static void findOrder(int idx, int[] order, boolean[] isVisited) {
        if (idx >= 5) {
            for (int[] direction : directions) {
                int result = bfs(order, direction);
                if (result == -1) {
                    continue;
                }
                if (answer == -1 || answer > result) {
                    answer = result;
                }
            }
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            order[idx] = i;
            findOrder(idx + 1, order, isVisited);
            isVisited[i] = false;
        }
    }

    static int bfs(int[] order, int[] direction) {
        if (boards[order[0]][direction[0]][0][0] == 0 || boards[order[4]][direction[4]][4][4] == 0) {
            return -1;
        }
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][][] isVisited = new boolean[5][5][5];
        q.add(new int[]{0, 0, 0, 0});
        isVisited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            int z = p[2];
            int c = p[3];

            if (x == 4 && y == 4 && z == 4) {
                return c;
            }
            for (int i = 0; i < 6; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                int zz = z + dz[i];

                if (isNotContains(xx, yy, zz)) {
                    continue;
                }
                if (isVisited[zz][yy][xx]) {
                    continue;
                }
                if (boards[order[zz]][direction[zz]][yy][xx] == 1) {
                    q.add(new int[]{xx, yy, zz, c + 1});
                    isVisited[zz][yy][xx] = true;
                }
            }
        }
        return -1;
    }

    private static boolean isNotContains(int xx, int yy, int zz) {
        return xx < 0 || yy < 0 || zz < 0 || xx >= 5 || yy >= 5 || zz >= 5;
    }
}
