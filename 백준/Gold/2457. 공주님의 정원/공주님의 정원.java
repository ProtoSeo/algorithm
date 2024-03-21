import java.io.*;
import java.util.*;

public class Main {

    static final int wantedStart = convert(3, 1);
    static final int wantedEnd = convert(11, 31);

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            int d = Integer.parseInt(stk.nextToken());

            int s = convert(a, b);
            int e = convert(c, d);
            flowers[i] = new Flower(s, e);
        }
        Arrays.sort(flowers);

        int startTime = wantedStart;
        int answer = 0;
        int limit = 0;
        int idx = 0;
        while (startTime < wantedEnd) {
            boolean isFind = false;
            for (int i = idx; i < n; i++) {
                if (flowers[i].s > startTime) {
                    break;
                }
                if (limit < flowers[i].e) {
                    isFind = true;
                    limit = flowers[i].e;
                    idx = i + 1;
                }
            }
            if (isFind) {
                answer++;
                startTime = limit;
            } else {
                break;
            }
        }

        if (limit < wantedEnd) {
            System.out.println(0);
            return;
        }
        System.out.println(answer);

    }

    static int convert(int month, int day) {
        int result = day;
        for (int i = 1; i < month; i++) {
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                result += 30;
            } else if (i == 2) {
                result += 28;
            } else {
                result += 31;
            }
        }
        return result;
    }
}

class Flower implements Comparable<Flower> {
    int s;
    int e;

    public Flower(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Flower o) {
        if (this.s == o.s) {
            return o.e - this.e;
        }
        return this.s - o.s;
    }
}
