import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        var stk = new StringTokenizer(br.readLine());
        var ary = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(stk.nextToken());
        }
        if (n == 1) {
            System.out.println(0);
            return;
        }

        int answer = -1;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int count = 0;
                if (i != 0) {
                    count++;
                }
                if (j != 0) {
                    count++;
                }

                int diff = (ary[1] + j) - (ary[0] + i);
                int prev = ary[1] + j;
                boolean canSequence = true;
                for (int k = 2; k < n; k++) {
                    int now = ary[k];
                    if (now - prev == diff) {
                        prev = now;
                    } else if (now - 1 - prev == diff) {
                        count++;
                        prev = now - 1;
                    } else if (now + 1 - prev == diff) {
                        count++;
                        prev = now + 1;
                    } else {
                        canSequence = false;
                        break;
                    }
                }
                if (canSequence && (answer == -1 || answer > count)) {
                    answer = count;
                }
            }
        }
        System.out.println(answer);
    }
}
