import java.io.*;

public class Main {

    static int[] ary;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int n = Integer.parseInt(br.readLine());

        final String[] split = br.readLine().split(" ");
        ary = new int[n];
        
        int size = 0;
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(split[i]);
            final int idx = lowerBound(0, size, now);

            if (ary[idx] < now) {
                ary[size++] = now;
            } else {
                ary[idx] = now;
            }
        }
        System.out.println(size);
    }

    static int lowerBound(int l, int r, int now) {
        while (l < r) {
            int m = (l + r) >> 1;
            if (now <= ary[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
