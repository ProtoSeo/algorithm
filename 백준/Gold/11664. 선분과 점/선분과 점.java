import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        double ax = Double.parseDouble(stk.nextToken());
        double ay = Double.parseDouble(stk.nextToken());
        double az = Double.parseDouble(stk.nextToken());
        double bx = Double.parseDouble(stk.nextToken());
        double by = Double.parseDouble(stk.nextToken());
        double bz = Double.parseDouble(stk.nextToken());
        double cx = Double.parseDouble(stk.nextToken());
        double cy = Double.parseDouble(stk.nextToken());
        double cz = Double.parseDouble(stk.nextToken());

        double ac = dist(ax, ay, az, cx, cy, cz);
        double bc = dist(bx, by, bz, cx, cy, cz);
        double answer = 1e9;
        while (true) {
            double mx = (ax + bx) / 2.0;
            double my = (ay + by) / 2.0;
            double mz = (az + bz) / 2.0;
            double h = dist(mx, my, mz, cx, cy, cz);

            if (Math.abs(answer - h) <= 1e-6) {
                break;
            }
            answer = Math.min(answer, h);

            if (ac < bc) {
                bx = mx;
                by = my;
                bz = mz;
                bc = h;
            } else {
                ax = mx;
                ay = my;
                az = mz;
                ac = h;
            }
        }
        System.out.printf("%.10f", answer);
    }

    static double dist(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1) * (z2 - z1));
    }
}
