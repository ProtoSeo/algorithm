import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int m = Integer.parseInt(br.readLine());

        long answer = 0;
        for (int i = 0; i < m; i++) {
            final StringTokenizer stk = new StringTokenizer(br.readLine());
            long n = Long.parseLong(stk.nextToken());
            long s = Long.parseLong(stk.nextToken());
            long gcd = gcd(s, n);
            n /= gcd;
            s /= gcd;
            answer += (exp(n, MOD - 2) * s) % MOD;
            answer %= MOD;
        }
        System.out.println(answer);
    }

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static long exp(long a, int r) {
        if (r == 1) {
            return a;
        }
        long x = exp(a, r / 2) % MOD;
        if (r % 2 == 0) {
            return x * x % MOD;
        }
        return x * x % MOD * a % MOD;
    }
}