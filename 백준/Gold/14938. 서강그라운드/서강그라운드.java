import java.io.*;
import java.util.*;

public class Main {

    static int[] itemCount;
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int r = Integer.parseInt(split[2]);

        itemCount = new int[n + 1];
        int[][] result = new int[n + 1][n + 1];
        split = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            itemCount[i] = Integer.parseInt(split[i - 1]);
            Arrays.fill(result[i], INF);
            result[i][i] = 0;
        }

        for (int i = 0; i < r; i++) {
            split = br.readLine().split(" ");
            final int a = Integer.parseInt(split[0]);
            final int b = Integer.parseInt(split[1]);
            final int c = Integer.parseInt(split[2]);

            result[a][b] = c;
            result[b][a] = c;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (result[i][j] > result[i][k] + result[k][j]) {
                        result[i][j] = result[i][k] + result[k][j];
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int getItem = 0;
            for (int j = 1; j <= n; j++) {
                if (result[i][j] <= m) {
                    getItem += itemCount[j];
                }
            }
            answer = Math.max(answer, getItem);
        }
        System.out.println(answer);
    }
}
