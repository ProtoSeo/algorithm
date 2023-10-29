import java.io.*;
import java.util.*;

public class Main {

    static List<Node>[] adjList;
    static PriorityQueue<Node>[] visitedRoad;
    static int[] inDegree;
    static int[] result;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        adjList = new ArrayList[n + 1];
        visitedRoad = new PriorityQueue[n + 1];
        inDegree = new int[n + 1];
        result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
            visitedRoad[i] = new PriorityQueue<>();
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            adjList[s].add(new Node(e, w));
            inDegree[e]++;
        }
        final String[] split = br.readLine().split(" ");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        for (int i = 1; i < n; i++) {
            int now = q.poll();

            for (Node nextNode : adjList[now]) {
                int next = nextNode.e;
                int nextWeight = nextNode.w;
                if (result[next] <= nextWeight + result[now]) {
                    result[next] = nextWeight + result[now];
                    visitedRoad[next].add(new Node(now, result[next]));
                }
                if (--inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        int answer = 0;
        q.clear();
        q.add(end);
        while (!q.isEmpty()) {
            final int now = q.poll();
            if (now == start || visitedRoad[now].isEmpty()) {
                continue;
            }
            int maxWeight = visitedRoad[now].peek().w;
            while (!visitedRoad[now].isEmpty()) {
                Node next = visitedRoad[now].poll();
                if (next.w == maxWeight) {
                    answer++;
                    q.add(next.e);
                }
            }
        }
        System.out.println(result[end]);
        System.out.println(answer);
    }
}

class Node implements Comparable<Node> {

    int e;
    int w;

    public Node(final int e, final int w) {
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(final Node o) {
        return o.w - this.w;
    }
}
