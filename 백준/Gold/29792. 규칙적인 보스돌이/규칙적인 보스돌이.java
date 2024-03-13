import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static long[] d;
    static long[] p;
    static long[] q;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        d = new long[n];
        for (int i = 0; i < n; i++) {
            d[i] = Long.parseLong(br.readLine());
        }
        p = new long[k];
        q = new long[k];
        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(br.readLine());
            p[i] = Long.parseLong(stk.nextToken());
            q[i] = Long.parseLong(stk.nextToken());
        }

        long[] result = new long[n];
        for (int i = 0; i < n; i++) {
            result[i] = find(0, d[i], 900, 0);
        }
        Arrays.sort(result);
        long answer = 0;
        for (int i = 0; i < m; i++) {
            answer += result[n - i - 1];
        }
        System.out.println(answer);
    }

    static long find(int now, long damage, long second, long sum) {
        if (now >= k) {
            return sum;
        }
        long result = find(now + 1, damage, second, sum);
        if (damage * second >= p[now]) {
            result = Math.max(result, find(now + 1, damage, second - (long) Math.ceil((double) p[now] / damage), sum + q[now]));
        }
        return result;
    }
}
