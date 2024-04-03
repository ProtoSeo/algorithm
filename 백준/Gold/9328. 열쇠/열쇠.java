import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static char[][] map;
    static Deque<int[]>[] doors;
    static boolean[] hasKey;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        while (t-- > 0) {
            var stk = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stk.nextToken());
            m = Integer.parseInt(stk.nextToken());

            map = new char[n + 2][m + 2];
            doors = new Deque[26];
            hasKey = new boolean[26];
            for (int i = 0; i < 26; i++) {
                doors[i] = new ArrayDeque<>();
            }
            for (int i = 0; i < n + 2; i++) {
                Arrays.fill(map[i], '.');
            }
            for (int i = 1; i < n + 1; i++) {
                String s = br.readLine();
                for (int j = 1; j < m + 1; j++) {
                    map[i][j] = s.charAt(j - 1);
                }
            }

            String key = br.readLine();
            for (char c : key.toCharArray()) {
                if (c == '0') {
                    break;
                }
                hasKey[c - 'a'] = true;
            }
            sb.append(findDocument()).append('\n');
        }
        System.out.print(sb);
    }

    static int findDocument() {
        int answer = 0;
        boolean[][] isVisited = new boolean[n + 2][m + 2];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];

            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx < 0 || yy < 0 || xx >= m + 2 || yy >= n + 2 || map[yy][xx] == '*' || isVisited[yy][xx]) {
                    continue;
                }
                char c = map[yy][xx];
                isVisited[yy][xx] = true;
                if ('a' <= c && c <= 'z') {
                    q.add(new int[]{xx, yy});
                    if (!hasKey[c - 'a']) {
                        hasKey[c - 'a'] = true;
                        while (!doors[c - 'a'].isEmpty()) {
                            q.add(doors[c - 'a'].poll());
                        }
                    }
                } else if ('A' <= c && c <= 'Z') {
                    if (hasKey[c - 'A']) {
                        q.add(new int[]{xx, yy});
                    } else {
                        doors[c - 'A'].add(new int[]{xx, yy});
                    }
                } else if (c == '$') {
                    q.add(new int[]{xx, yy});
                    answer++;
                } else if (c == '.') {
                    q.add(new int[]{xx, yy});
                }
            }
        }
        return answer;
    }
}
