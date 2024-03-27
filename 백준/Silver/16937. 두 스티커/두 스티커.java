import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(stk.nextToken());
        int w = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(br.readLine());

        Sticker[] stickers = new Sticker[n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            stickers[i] = new Sticker(r, c);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Sticker a = stickers[i];
                Sticker b = stickers[j];
                answer = Math.max(answer, check(h, w, a, b));
            }
        }
        System.out.println(answer);
    }

    static int check(int h, int w, Sticker a, Sticker b) {
        int h1, h2, w1, w2;

        if (h >= a.r && w >= a.c) {
            h1 = h - a.r;
            w1 = w;
            h2 = h;
            w2 = w - a.c;

            if (Math.max(b.r, b.c) <= Math.max(h1, w1) && Math.min(b.r, b.c) <= Math.min(h1, w1)) {
                return a.r * a.c + b.r * b.c;
            }
            if (Math.max(b.r, b.c) <= Math.max(h2, w2) && Math.min(b.r, b.c) <= Math.min(h2, w2)) {
                return a.r * a.c + b.r * b.c;
            }
        }
        if (w >= a.r && h >= a.c) {
            h1 = h - a.c;
            w1 = w;
            h2 = h;
            w2 = w - a.r;

            if (Math.max(b.r, b.c) <= Math.max(h1, w1) && Math.min(b.r, b.c) <= Math.min(h1, w1)) {
                return a.r * a.c + b.r * b.c;
            }
            if (Math.max(b.r, b.c) <= Math.max(h2, w2) && Math.min(b.r, b.c) <= Math.min(h2, w2)) {
                return a.r * a.c + b.r * b.c;
            }
        }
        return 0;
    }
}

class Sticker {
    int r;
    int c;

    public Sticker(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
