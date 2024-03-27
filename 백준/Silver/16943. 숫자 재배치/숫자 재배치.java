import java.io.*;
import java.util.*;

public class Main {
    static String a;
    static int n, b;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stk = new StringTokenizer(br.readLine());
        a = stk.nextToken();
        b = Integer.parseInt(stk.nextToken());
        n = a.length();
        find(0, new int[n], new boolean[n]);
        System.out.println(answer);
    }

    static void find(int idx, int[] ary, boolean[] isSelected) {
        if (idx >= n) {
            int result = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0 && ary[i] == 0) {
                    return;
                }
                result = result * 10 + ary[i];
            }
            if (result < b) {
                answer = Math.max(answer, result);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSelected[i]) {
                continue;
            }
            isSelected[i] = true;
            ary[idx] = a.charAt(i) - '0';
            find(idx + 1, ary, isSelected);
            isSelected[i] = false;
        }
    }
}
