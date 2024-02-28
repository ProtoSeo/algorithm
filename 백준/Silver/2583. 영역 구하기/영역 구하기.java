import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[][] map = new int[n][m];
        while (k-- > 0) {
            stk = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());

            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    map[i][j] = 1;
                }
            }
        }

        boolean[][] isVisited = new boolean[n][m];
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && !isVisited[i][j]) {
                    Deque<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{j, i});
                    isVisited[i][j] = true;
                    int size = 0;

                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        int x = p[0];
                        int y = p[1];
                        size++;
                        for (int l = 0; l < 4; l++) {
                            int xx = x + dx[l];
                            int yy = y + dy[l];

                            if (xx < 0 || xx >= m || yy < 0 || yy >= n || isVisited[yy][xx] || map[yy][xx] == 1) {
                                continue;
                            }
                            q.add(new int[]{xx, yy});
                            isVisited[yy][xx] = true;
                        }
                    }
                    sizes.add(size);
                }
            }
        }

        System.out.println(sizes.size());
        sizes.sort(Comparator.naturalOrder());
        for (int size : sizes) {
            System.out.print(size + " ");
        }
    }
}
