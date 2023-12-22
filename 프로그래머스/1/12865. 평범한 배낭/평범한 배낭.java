import java.io.*;

public class Main {

    static int[][] d = new int[101][100001];

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] split = br.readLine().split(" ");

        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            w[i + 1] = Integer.parseInt(input[0]);
            v[i + 1] = Integer.parseInt(input[1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                d[i][j] = d[i - 1][j];
                if (j - w[i] >= 0) {
                    d[i][j] = Math.max(d[i][j], d[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(d[n][k]);
    }
}
