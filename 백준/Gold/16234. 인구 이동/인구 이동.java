import java.io.*;
import java.util.*;

public class Main {

    static int n, l, r;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] ary;
    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        l = Integer.parseInt(stk.nextToken());
        r = Integer.parseInt(stk.nextToken());

        ary = new int[n][n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ary[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int answer = 0;
        while (canMove()) {
            answer++;
            move();
        }
        System.out.println(answer);
    }

    private static void move() {
        boolean[][] isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j] && !adjList[i * n + j].isEmpty()) {
                    Deque<Integer> q = new ArrayDeque<>();
                    Set<Integer> prev = new HashSet<>();
                    int sum = 0;

                    q.add(i * n + j);
                    isVisited[i][j] = true;
                    while (!q.isEmpty()) {
                        int p = q.poll();
                        int x = p % n;
                        int y = p / n;
                        sum += ary[y][x];
                        prev.add(p);

                        for (int next : adjList[p]) {
                            int yy = next / n;
                            int xx = next % n;
                            if (isVisited[yy][xx]) {
                                continue;
                            }
                            isVisited[yy][xx] = true;
                            q.add(next);
                        }
                    }

                    for (int p : prev) {
                        int x = p % n;
                        int y = p / n;
                        ary[y][x] = sum / prev.size();
                    }
                }
            }
        }
    }

    private static boolean canMove() {
        adjList = new List[n * n];
        for (int i = 0; i < n * n; i++) {
            adjList[i] = new ArrayList<>();
        }

        boolean canMove = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int xx = j + dx[k];
                    int yy = i + dy[k];
                    if (xx < 0 || yy < 0 || xx >= n || yy >= n) {
                        continue;
                    }
                    int diff = Math.abs(ary[i][j] - ary[yy][xx]);
                    if (l > diff || diff > r) {
                        continue;
                    }
                    canMove = true;
                    adjList[i * n + j].add(yy * n + xx);
                }
            }
        }
        return canMove;
    }
}
