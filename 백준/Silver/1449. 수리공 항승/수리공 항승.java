import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int l = Integer.parseInt(stk.nextToken());
        var pipes = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pipes[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(pipes);

        int answer = 1;
        int min = pipes[0];
        int max = pipes[0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, pipes[i]);
            max = Math.max(max, pipes[i]);
            if (max - min > l - 1) {
                min = pipes[i];
                max = pipes[i];
                answer++;
            }
        }
        System.out.println(answer);
    }
}