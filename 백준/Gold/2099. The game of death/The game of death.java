import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static boolean[][] canSelected;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        canSelected = new boolean[n + 1][n + 1];
        int k = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            canSelected[i][a] = true;
            canSelected[i][b] = true;
        }
        
        boolean[][] result = exp(k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            if (result[a][b]) {
                sb.append("death").append('\n');
            } else {
                sb.append("life").append('\n');
            }
        }
        System.out.println(sb);
    }

    static boolean[][] exp(int k) {
        if (k == 1) {
            return canSelected;
        }
        boolean[][] x = exp(k / 2);
        if (k % 2 == 0) {
            return find(x, x);
        }
        return find(find(x, x), canSelected);
    }

    static boolean[][] find(boolean[][] a, boolean[][] b) {
        boolean[][] c = new boolean[n + 1][n + 1];
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (a[i][k] && b[k][j]) {
                        c[i][j] = true;
                    }
                }
            }
        }
        return c;
    }
}
