import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        var ary = new int[n];
        stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(stk.nextToken());
        }

        int l = 0;
        int r = 0;
        int answer = 0;
        int remove = 0;
        while (l <= r && r < n) {
            if (l == r && ary[l] % 2 == 1) {
                l++;
                r++;
                continue;
            }

            if (ary[r] % 2 == 0) {
                r++;
            } else if (ary[r] % 2 == 1 && remove < k) {
                r++;
                remove++;
            } else if (ary[r] % 2 == 1) {
                while (ary[l] % 2 == 1 || remove >= k) {
                    if (ary[l] % 2 == 1) {
                        remove--;
                    }
                    l++;
                }
            }
            if (answer < r - l - remove) {
                answer = r - l - remove;
            }
        }
        System.out.println(answer);
    }
}
