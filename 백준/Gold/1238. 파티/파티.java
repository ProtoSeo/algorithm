import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        final int n = Integer.parseInt(split[0]);
        final int m = Integer.parseInt(split[1]);
        final int x = Integer.parseInt(split[2]);

        List<Node>[] adjList = new ArrayList[n + 1];
        List<Node>[] revAdjList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
            revAdjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int t = Integer.parseInt(split[2]);

            adjList[a].add(new Node(b, t));
            revAdjList[b].add(new Node(a, t));
        }

        int[] result = new int[n + 1];
        int[] revResult = new int[n + 1];
        Arrays.fill(result, INF);
        Arrays.fill(revResult, INF);
        findMinDistance(x, result, adjList);
        findMinDistance(x, revResult, revAdjList);

        int time = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            time = Math.max(time, result[i] + revResult[i]);
        }
        System.out.println(time);
    }

    public static void findMinDistance(int start, int[] result, List<Node>[] adjList) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{start, 0});
        result[start] = 0;

        while (!pq.isEmpty()) {
            final int[] p = pq.poll();
            int now = p[0];
            int weight = p[1];

            if (result[now] < weight) {
                continue;
            }
            for (Node node : adjList[now]) {
                int next = node.e;
                int nextWeight = node.w;

                if (result[next] > result[now] + nextWeight) {
                    result[next] = result[now] + nextWeight;
                    pq.add(new int[]{next, result[next]});
                }
            }
        }
    }

}

class Node {

    int e;
    int w;

    public Node(final int e, final int w) {
        this.e = e;
        this.w = w;
    }
}
