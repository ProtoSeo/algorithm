import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Line> lines = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            lines.add(new Line(s, e));
        }
        int answer = 0;
        while (!lines.isEmpty()) {
            Line line = lines.poll();
            int start = line.s;
            int end = line.e;
            while (!lines.isEmpty() && end >= lines.peek().s) {
                end = Math.max(end, lines.poll().e);
            }
            answer += end - start;
        }
        System.out.println(answer);
    }
}

class Line implements Comparable<Line> {
    int s;
    int e;

    public Line(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Line o) {
        if (this.s == o.s) {
            return this.e - o.e;
        }
        return this.s - o.s;
    }
}
