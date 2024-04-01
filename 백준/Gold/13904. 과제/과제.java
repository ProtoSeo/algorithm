import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var pq = new PriorityQueue<Task>();
        var tasks = new Task[n];
        var process = new boolean[1001];

        for (int i = 0; i < n; i++) {
            var stk = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            tasks[i] = new Task(i + 1, d, w);
            pq.add(tasks[i]);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            var task = pq.poll();
            for (int j = task.d; j > 0; j--) {
                if (!process[j]) {
                    process[j] = true;
                    answer += task.w;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}

class Task implements Comparable<Task> {
    int i;
    int d;
    int w;

    public Task(int i, int d, int w) {
        this.i = i;
        this.d = d;
        this.w = w;
    }

    @Override
    public int compareTo(Task t) {
        if (this.w == t.w) {
            return this.d - t.d;
        }
        return t.w - this.w;
    }
}
