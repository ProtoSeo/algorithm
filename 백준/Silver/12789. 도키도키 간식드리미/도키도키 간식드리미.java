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
        int line = 1;
        Deque<Integer> wait = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int now = ary[i];
            boolean isOut = false;
            if (line == now) {
                line++;
                isOut = true;
            }
            while (!wait.isEmpty() && wait.peekFirst() == line) {
                line++;
                wait.pollFirst();
            }
            if (!isOut) {
                wait.push(now);
            }
        }
        while (!wait.isEmpty()) {
            int now = wait.pollFirst();
            if (now == line) {
                line++;
            } else {
                break;
            }
        }
        System.out.println(wait.isEmpty() ? "Nice" : "Sad");
    }
}
