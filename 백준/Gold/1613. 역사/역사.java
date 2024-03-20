import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 987654321;
    static boolean[][] adjAry;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        adjAry = new boolean[n + 1][n + 1];
        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            adjAry[a][b] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int l = 1; l <= n; l++) {
                    if (adjAry[j][i] && adjAry[i][l]) {
                        adjAry[j][l] = true;
                    }
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            if (adjAry[a][b]) {
                sb.append(-1).append('\n');
            } else if (adjAry[b][a]) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.print(sb);
    }
}
