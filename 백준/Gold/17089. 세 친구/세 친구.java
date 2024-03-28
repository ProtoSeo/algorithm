import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        Set<Integer>[] friends = new Set[n + 1];
        for (int i = 0; i <= n; i++) {
            friends[i] = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        int answer = -1;
        for (int i = 1; i <= n; i++) {
            if (friends[i].size() < 2) {
                continue;
            }
            for (int j = i + 1; j <= n; j++) {
                if (!friends[i].contains(j) || friends[j].size() < 2) {
                    continue;
                }
                for (int k = j + 1; k <= n; k++) {
                    if (!friends[j].contains(k) || !friends[k].contains(i) || friends[k].size() < 2) {
                        continue;
                    }
                    int sum = friends[i].size() + friends[j].size() + friends[k].size() - 6;
                    if (answer == -1 || answer > sum) {
                        answer = sum;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
