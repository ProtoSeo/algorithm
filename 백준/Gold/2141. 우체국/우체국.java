import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> villages = new ArrayList<>();
        long peopleCount = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int a = Integer.parseInt(stk.nextToken());
            villages.add(new int[]{x, a});
            peopleCount += a;
        }
        villages.sort((o1, o2) -> o1[0] - o2[0]);

        int answer = 0;
        long sum = 0;
        for (int[] village : villages) {
            sum += village[1];
            if (sum >= (peopleCount + 1) / 2) {
                answer = village[0];
                break;
            }
        }
        System.out.println(answer);
    }
}
