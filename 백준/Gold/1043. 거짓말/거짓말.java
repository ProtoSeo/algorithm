import java.io.*;
import java.util.Arrays;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        final int n = Integer.parseInt(split[0]);
        final int m = Integer.parseInt(split[1]);
        parents = new int[n + 1];
        Arrays.fill(parents, -1);

        split = br.readLine().split(" ");

        for (int i = 1; i < split.length; i++) {
            union(0, Integer.parseInt(split[i]));
        }

        String[] inputs = new String[m];
        for (int i = 0; i < m; i++) {
            inputs[i] = br.readLine();
            split = inputs[i].split(" ");

            for (int j = 2; j < split.length; j++) {
                int a = Integer.parseInt(split[j]);
                int b = Integer.parseInt(split[j - 1]);
                union(a, b);
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            split = inputs[i].split(" ");
            boolean canTalk = true;
            for (int j = 1; j < split.length; j++) {
                if (find(0) == find(Integer.parseInt(split[j]))) {
                    canTalk = false;
                    break;
                }
            }
            if (canTalk) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static int find(int a) {
        if (parents[a] == -1) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return false;
        }
        parents[pb] = pa;
        return true;
    }
}
