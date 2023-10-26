import java.io.*;

public class Main {

    static boolean[][] d = new boolean[31][40001];
    static int[] weights = new int[31];
    static int n;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            weights[i + 1] = Integer.parseInt(split[i]);
        }

        d[0][0] = true;
        for (int i = 1; i <= n; i++) {
            int weight = weights[i];
            for (int j = 0; j <= 40000; j++) {
                d[i][j] = d[i - 1][j] || d[i - 1][Math.abs(j - weight)];
                if (j + weight < 40001) {
                    d[i][j] = d[i][j] || d[i - 1][j + weight];
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        split = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (d[n][Integer.parseInt(split[i])]) {
                sb.append('Y').append(' ');
                continue;
            }
            sb.append('N').append(' ');
        }
        System.out.println(sb);
    }
}
