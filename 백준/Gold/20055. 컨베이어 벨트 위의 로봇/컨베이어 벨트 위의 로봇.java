import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        List<Node> belt = new LinkedList<>();
        for (int i = 0; i < 2 * n; i++) {
            belt.add(new Node(Integer.parseInt(stk.nextToken())));
        }

        int count = 0;
        int answer = 0;
        while (true) {
            answer++;
            Node prev = belt.remove(2 * n - 1);
            belt.add(0, prev);

            belt.get(n - 1).hasRobot = false;
            for (int i = n - 2; i > 0; i--) {
                Node now = belt.get(i);
                Node next = belt.get(i + 1);
                if (now.hasRobot && !next.hasRobot && next.value > 0) {
                    now.hasRobot = false;
                    next.hasRobot = true;
                    if (--next.value == 0) {
                        count++;
                    }
                }
            }
            belt.get(n - 1).hasRobot = false;

            if (prev.value > 0) {
                prev.hasRobot = true;
                if (--prev.value == 0) {
                    count++;
                }
            }
            if (count >= k) {
                break;
            }
        }

        System.out.println(answer);

    }
}

class Node {
    int value;
    boolean hasRobot;

    public Node(int value) {
        this.value = value;
    }

}
