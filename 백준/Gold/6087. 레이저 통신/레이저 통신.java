import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());
        char[][] board = new char[n][m];
        int[][] count = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(count[i],-1);
        }
        ArrayDeque<Node> q = new ArrayDeque<>();
        int endX = 0, endY = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'C') {
                    if (q.isEmpty()) {
                        q.add(new Node(j, i));
                        count[i][j]=0;
                    } else {
                        endX = j;
                        endY = i;
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                while(nx >= 0 && ny >= 0 && nx < m && ny < n){
                    if(board[ny][nx]=='*') break;
                    if(count[ny][nx]==-1){
                        count[ny][nx] = count[y][x] + 1;
                        q.add(new Node(nx,ny));
                    }
                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }
        System.out.println(count[endY][endX]-1);
    }

    static class Node  {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}