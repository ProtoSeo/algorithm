import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int[][] d = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = map[i][j];
                if (i - 1 >= 0) {
                    d[i][j] = Math.max(d[i][j], d[i - 1][j] + map[i][j]);
                }
                if (j - 1 >= 0) {
                    d[i][j] = Math.max(d[i][j], d[i][j - 1] + map[i][j]);
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    d[i][j] = Math.max(d[i][j], d[i - 1][j - 1] + map[i][j]);
                }
            }
        }
        System.out.println(d[n - 1][m - 1]);
    }
}
