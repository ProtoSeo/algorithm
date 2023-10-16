import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0,1,0,1},dy={1,0,-1,0};
    static char[] d = {'D','R','U','R'};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[][] board = new int[n][m];
        int x = 1, y = 0;
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(stk.nextToken());
                if ((i + j) % 2 == 1 && board[y][x] > board[i][j]) {
                    y = i;
                    x = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m - 1; j++) {
                    if (i % 2 == 0) {
                        sb.append('R');
                    } else {
                        sb.append('L');
                    }
                }
                if (i < n - 1) {
                    sb.append('D');
                }
            }
        } else if (m % 2 == 1) {
            for (int j = 0; j < m; j++) {
                for (int i = 0; i < n - 1; i++) {
                    if (j % 2 == 0) {
                        sb.append('D');
                    } else {
                        sb.append('U');
                    }
                }
                if (j < m - 1) {
                    sb.append('R');
                }
            }
        } else {
            for (int i = 0; i < (y / 2) * 2; i++) {
                for (int j = 0; j < m-1; j++) {
                    if (i % 2 == 0) {
                        sb.append('R');
                    } else {
                        sb.append('L');
                    }
                }
                sb.append('D');
            }
            int x1 = 0;
            int y1 = (y / 2) * 2;
            for (int i = 0,j=0; i < 2 * m - 2; i++) {
                int nx = x1+dx[j];
                int ny = y1+dy[j];
                if(nx==x&&ny==y){
                    if(j==0){
                        sb.append('R');
                        j=0;
                    }else if(j==2){
                        sb.append('R');
                        j=2;
                    }
                    x1 +=1;
                }else{
                    x1 = nx;
                    y1 = ny;
                    sb.append(d[j]);
                    j = (j+1)%4;
                }
            }
            for (int i = (y / 2) * 2 + 2; i < n; i++) {
                sb.append('D');
                for (int j = 0; j < m-1; j++) {
                    if (i % 2 == 0) {
                        sb.append('L');
                    } else {
                        sb.append('R');
                    }
                }

            }
        }
        System.out.println(sb);
    }
}