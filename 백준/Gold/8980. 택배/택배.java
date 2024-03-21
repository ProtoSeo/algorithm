import java.io.*;
import java.util.*;

public class Main {

    static List<Box>[] boxes;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(br.readLine());

        boxes = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            boxes[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            boxes[s].add(new Box(s, e, w));
        }

        PriorityQueue<Box> truck = new PriorityQueue<>((o1, o2) -> o1.e - o2.e);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            while (!truck.isEmpty() && truck.peek().e == i) {
                Box box = truck.poll();
                answer += box.w;
            }

            PriorityQueue<Box> pq = new PriorityQueue<>((o1, o2) -> o2.e - o1.e);
            int sum = 0;
            while (!truck.isEmpty()) {
                Box box = truck.poll();
                pq.add(box);
                sum += box.w;
            }
            for (Box box : boxes[i]) {
                pq.add(box);
                sum += box.w;
            }
            
            while (!pq.isEmpty() && sum > c) {
                Box box = pq.poll();
                if (sum - box.w <= c) {
                    truck.add(new Box(box.s, box.e, box.w - (sum - c)));
                    break;
                }
                sum -= box.w;
            }
            while (!pq.isEmpty()) {
                truck.add(pq.poll());
            }
        }
        System.out.println(answer);
    }
}

class Box {
    int s;
    int e;
    int w;

    public Box(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
}
