import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        Set<Integer>[] sets = new Set[n + 1];
        for (int i = 0; i <= n; i++) {
            sets[i] = new HashSet<>();
        }
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            sets[a].add(b);
            sets[b].add(a);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (sets[i].contains(j) || sets[j].contains(k) || sets[k].contains(i)) {
                        continue;
                    }
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
