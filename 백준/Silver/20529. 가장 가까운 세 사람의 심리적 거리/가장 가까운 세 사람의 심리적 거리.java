import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        final StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            final StringTokenizer stk = new StringTokenizer(br.readLine());
            if (n > 32) {
                sb.append(0).append('\n');
                continue;
            }
            final List<String> mbti = new ArrayList<>();
            while (stk.hasMoreTokens()) {
                mbti.add(stk.nextToken());
            }
            int result = find(0, 0, mbti, new String[3], new boolean[n]);
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    private static int find(int n, int idx, List<String> mbti, String[] selected, boolean[] isVisited) {
        if (idx == 3) {
            return getDistance(selected[0], selected[1]) + getDistance(selected[2], selected[0]) + getDistance(selected[1], selected[2]);
        }
        int result = Integer.MAX_VALUE;
        for (int i = n; i < mbti.size(); i++) {
            if (isVisited[i]) {
                continue;
            }
            selected[idx] = mbti.get(i);
            isVisited[i] = true;
            result = Math.min(result, find(n + 1, idx + 1, mbti, selected, isVisited));
            isVisited[i] = false;
        }
        return result;
    }

    private static int getDistance(String a, String b) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                result++;
            }
        }
        return result;
    }
}
