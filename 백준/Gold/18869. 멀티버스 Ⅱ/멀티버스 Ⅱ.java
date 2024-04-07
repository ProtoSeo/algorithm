import java.io.*;
import java.util.*;

public class Main {

    static int m, n;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());

        int[][] zip = new int[m][n];
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int[] ary = new int[n];
            for (int j = 0; j < n; j++) {
                ary[j] = Integer.parseInt(stk.nextToken());
            }
            int[] sorted = Arrays.stream(ary)
                    .distinct()
                    .sorted()
                    .toArray();
            for (int j = 0; j < n; j++) {
                zip[i][j] = Arrays.binarySearch(sorted, ary[j]);
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            int[] a = zip[i];
            for (int j = i + 1; j < m; j++) {
                int[] b = zip[j];
                if (Arrays.equals(a, b)) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
