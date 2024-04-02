import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int answer = 0;
        for (int y1 = 0; y1 < n; y1++) {
            for (int x1 = 0; x1 < m; x1++) {
                for (int s1 = 0; ; s1++) {
                    if (x1 - s1 < 0 || x1 + s1 >= m || y1 - s1 < 0 || y1 + s1 >= n) {
                        break;
                    }
                    if (map[y1 - s1][x1] != '#' || map[y1 + s1][x1] != '#' || map[y1][x1 - s1] != '#' || map[y1][x1 + s1] != '#') {
                        break;
                    }
                    map[y1 - s1][x1] = map[y1 + s1][x1] = map[y1][x1 - s1] = map[y1][x1 + s1] = '*';
                    for (int y2 = 0; y2 < n; y2++) {
                        for (int x2 = 0; x2 < m; x2++) {
                            for (int s2 = 0; ; s2++) {
                                if (x2 - s2 < 0 || x2 + s2 >= m || y2 - s2 < 0 || y2 + s2 >= n) {
                                    break;
                                }
                                if (map[y2 - s2][x2] != '#' || map[y2 + s2][x2] != '#' || map[y2][x2 - s2] != '#' || map[y2][x2 + s2] != '#') {
                                    break;
                                }
                                answer = Math.max(answer, (4 * s1 + 1) * (4 * s2 + 1));
                            }
                        }
                    }
                }
                for (int s1 = 0; ; s1++) {
                    if (x1 - s1 < 0 || x1 + s1 >= m || y1 - s1 < 0 || y1 + s1 >= n) {
                        break;
                    }
                    if (map[y1 - s1][x1] != '*' || map[y1 + s1][x1] != '*' || map[y1][x1 - s1] != '*' || map[y1][x1 + s1] != '*') {
                        break;
                    }
                    map[y1 - s1][x1] = map[y1 + s1][x1] = map[y1][x1 - s1] = map[y1][x1 + s1] = '#';
                }
            }
        }
        System.out.println(answer);
    }
}
