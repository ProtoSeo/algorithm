import java.io.*;
import java.util.*;

public class Main {
    static int[][] a = new int[501][501];
    static int[][][] block = {
            {{0, 1}, {0, 2}, {0, 3}},
            {{1, 0}, {2, 0}, {3, 0}},
            {{1, 0}, {1, 1}, {1, 2}},
            {{0, 1}, {1, 0}, {2, 0}},
            {{0, 1}, {0, 2}, {1, 2}},
            {{1, 0}, {2, 0}, {2, -1}},
            {{0, 1}, {0, 2}, {-1, 2}},
            {{1, 0}, {2, 0}, {2, 1}},
            {{0, 1}, {0, 2}, {1, 0}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{0, 1}, {1, 0}, {1, 1}},
            {{0, 1}, {-1, 1}, {-1, 2}},
            {{1, 0}, {1, 1}, {2, 1}},
            {{0, 1}, {1, 1}, {1, 2}},
            {{1, 0}, {1, -1}, {2, -1}},
            {{0, 1}, {0, 2}, {-1, 1}},
            {{0, 1}, {0, 2}, {1, 1}},
            {{1, 0}, {2, 0}, {1, 1}},
            {{1, 0}, {2, 0}, {1, -1}},
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 19; k++) {
                    boolean ok = true;
                    int sum = a[i][j];
                    for (int l = 0; l < 3; l++) {
                        int x = i + block[k][l][0];
                        int y = j + block[k][l][1];
                        if (0 <= x && x < n && 0 <= y && y < m) {
                            sum += a[x][y];
                        } else {
                            ok = false;
                            break;
                        }
                    }

                    if (ok && ans < sum) {
                        ans = sum;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}