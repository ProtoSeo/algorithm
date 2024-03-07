import java.io.*;
import java.util.*;

public class Main {

    static int[] d, t, p;
    static int n;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            t[i] = Integer.parseInt(split[0]);
            p[i] = Integer.parseInt(split[1]);
        }

        d = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            if (i + t[i] > n) {
                d[i] = d[i + 1];
                continue;
            }
            d[i] = Math.max(d[i + 1], d[i + t[i]] + p[i]);
        }
        System.out.println(d[0]);
    }
}
