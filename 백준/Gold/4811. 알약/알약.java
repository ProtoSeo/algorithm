import java.io.*;
import java.util.*;

public class Main {
    static long[][] dp = new long[31][31];

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <= 30; i++) {
            Arrays.fill(dp[i], -1);
        }
        find(30, 30);
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            sb.append(dp[n][n]).append('\n');
            n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }

    static long find(int w, int h) {
        if (dp[w][h] > 0) {
            return dp[w][h];
        }
        if (w == 0) {
            return 1;
        }
        long result = 0;
        if (w == h) {
            result = find(w - 1, h);
        } else if (w < h) {
            result = find(w - 1, h) + find(w, h - 1);
        }
        return dp[w][h] = result;
    }
}