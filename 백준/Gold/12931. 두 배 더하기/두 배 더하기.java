import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] ary;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ary = new int[n];
        var stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(stk.nextToken());
        }
        System.out.println(findAnswer());
    }

    static int findAnswer() {
        int result = 0;
        while (true) {
            boolean canMultiply = true;
            for (int i = 0; i < n; i++) {
                if (ary[i] % 2 != 0) {
                    canMultiply = false;
                    break;
                }
            }
            if (canMultiply) {
                boolean isStop = true;
                for (int i = 0; i < n; i++) {
                    ary[i] /= 2;
                    if (isStop && ary[i] != 0) {
                        isStop = false;
                    }
                }
                if (isStop) {
                    return result;
                }
                result++;
            } else {
                for (int i = 0; i < n; i++) {
                    if (ary[i] % 2 != 0) {
                        ary[i] -= 1;
                        result++;
                    }
                }
            }
        }
    }
}
