import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, answer = Integer.MAX_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] ary;
    static int[][] commands;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        ary = new int[n][m];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        commands = new int[k][3];
        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                commands[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        find(0, new int[k], new boolean[k]);
        System.out.println(answer);
    }

    static void find(int idx, int[] order, boolean[] isSelected) {
        if (idx >= k) {
            int[][] copy = new int[n][m];
            for (int i = 0; i < n; i++) {
                System.arraycopy(ary[i], 0, copy[i], 0, m);
            }
            for (int i = 0; i < k; i++) {
                copy = rotate(copy, order[i]);
            }
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += copy[i][j];
                }
                result = Math.min(result, sum);
            }
            answer = Math.min(answer, result);
            return;
        }
        for (int i = 0; i < k; i++) {
            if (isSelected[i]) {
                continue;
            }
            isSelected[i] = true;
            order[idx] = i;
            find(idx + 1, order, isSelected);
            isSelected[i] = false;
        }
    }

    static int[][] rotate(int[][] ary, int command) {
        int cy = commands[command][0] - 1;
        int cx = commands[command][1] - 1;
        int l = commands[command][2];

        for (int i = l; i > 0; i--) {
            int x = cx - i;
            int y = cy - i;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i * 2; j++) {
                list.add(ary[y][x]);
                x += 1;
            }
            for (int j = 0; j < i * 2; j++) {
                list.add(ary[y][x]);
                y += 1;
            }
            for (int j = 0; j < i * 2; j++) {
                list.add(ary[y][x]);
                x -= 1;
            }
            for (int j = 0; j < i * 2; j++) {
                list.add(ary[y][x]);
                y -= 1;
            }
            list.add(0, list.remove(list.size() - 1));
            int idx = 0;
            for (int j = 0; j < i * 2; j++) {
                ary[y][x] = list.get(idx++);
                x += 1;
            }
            for (int j = 0; j < i * 2; j++) {
                ary[y][x] = list.get(idx++);
                y += 1;
            }
            for (int j = 0; j < i * 2; j++) {
                ary[y][x] = list.get(idx++);
                x -= 1;
            }
            for (int j = 0; j < i * 2; j++) {
                ary[y][x] = list.get(idx++);
                y -= 1;
            }
        }

        return ary;
    }
}
