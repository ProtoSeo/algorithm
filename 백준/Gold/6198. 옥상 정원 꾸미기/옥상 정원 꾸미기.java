import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer=  0;
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());
            while (!stk.isEmpty() && stk.peek() <= h) {
                stk.pop();
            }
            answer += stk.size();
            stk.push(h);
        }
        System.out.println(answer);
    }
}
