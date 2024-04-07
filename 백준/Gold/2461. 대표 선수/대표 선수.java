import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        var pointer = new int[n];
        var students = new int[n][m];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                students[i][j] = Integer.parseInt(stk.nextToken());
            }
            Arrays.sort(students[i]);
        }

        int answer = Integer.MAX_VALUE;
        while (true) {
            int idx = -1;
            int min = -1;
            int max = -1;
            for (int i = 0; i < n; i++) {
                if (pointer[i] >= m) {
                    System.out.println(answer);
                    return;
                }
                int val = students[i][pointer[i]];
                if (min == -1 || min > val) {
                    min = val;
                    idx = i;
                }
                if (max == -1 || max < val) {
                    max = val;
                }
            }
            pointer[idx]++;
            answer = Math.min(answer, max - min);
        }
    }
}
