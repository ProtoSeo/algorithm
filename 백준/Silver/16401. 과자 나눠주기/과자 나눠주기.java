import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());

        var snack = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            snack[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(snack);

        int l = 1;
        int r = snack[n - 1] + 1;
        int answer = 0;
        while (l < r) {
            int mid = (l + r) / 2;
            long count = 0;
            for (int i = 0; i < n; i++) {
                count += snack[i] / mid;
            }
            if (count >= m) {
                l = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                r = mid;
            }
        }
        System.out.println(answer);
    }
}