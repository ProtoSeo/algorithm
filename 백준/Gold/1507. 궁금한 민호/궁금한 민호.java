import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] ary, result;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ary = new int[n][n];
        result = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                result[i][j] = ary[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        boolean canBuild = true;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    if (ary[i][k] + ary[k][j] == ary[i][j]) {
                        result[i][j] = 0;
                    } else if (ary[i][k] + ary[k][j] < ary[i][j]) {
                        canBuild = false;
                    }
                }
            }
        }
        if (canBuild) {
            int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    answer += result[i][j];
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}
