import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var stk = new StringTokenizer(br.readLine());
        var want = new int[n];
        int l = 1, r = 0;
        for (int i = 0; i < n; i++) {
            want[i] = Integer.parseInt(stk.nextToken());
            r = Math.max(want[i] + 1, r);
        }
        int total = Integer.parseInt(br.readLine());

        int answer = 0;
        while (l < r) {
            int mid = (l + r) / 2;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.min(want[i], mid);
            }
            if (sum <= total) {
                l = mid + 1;
                answer = Math.max(mid, answer);
            } else {
                r = mid;
            }
        }
        System.out.println(answer);
    }
}
