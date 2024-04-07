import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        var ary = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ary);

        int l = 0;
        int r = 0;
        int answer = -1;
        while (l <= r && r < n) {
            int diff = ary[r] - ary[l];
            if (diff >= m) {
                l++;
                if (answer == -1 || answer > diff) {
                    answer = diff;
                }
            } else {
                r++;
            }
        }
        System.out.println(answer);
    }
}
