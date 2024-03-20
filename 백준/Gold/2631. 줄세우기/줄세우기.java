import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] ary = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (ary[i] > ary[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(n - max);
    }
}
