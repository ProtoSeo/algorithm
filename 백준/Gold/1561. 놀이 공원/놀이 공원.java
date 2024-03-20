import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] times;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        times = new int[m];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            times[i] = Integer.parseInt(stk.nextToken());
        }

        long targetTime = binarySearch();
        int useTicket = 0;
        for (int i = 0; i < m; i++) {
            useTicket += (int) Math.ceil((targetTime - 1.0) / times[i]);
        }

        int remainTicket = n - useTicket;
        for (int i = 0; i < m; i++) {
            if ((targetTime - 1) % times[i] == 0) {
                remainTicket--;
            }
            if (remainTicket == 0) {
                System.out.println(i + 1);
                break;
            }
        }
    }

    static long binarySearch() {
        long l = 0;
        long r = 30 * 2_000_000_000L;
        while (l < r) {
            long mid = (l + r) / 2;
            long count = 0;
            for (int i = 0; i < m; i++) {
                count += (long) Math.ceil((double) mid / times[i]);
            }

            if (count < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
