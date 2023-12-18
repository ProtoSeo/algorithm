import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[][] board = new int[n][m];
        int[][] group = new int[n][m];
        HashMap<Integer,Integer> groupSize = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
        int num = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]==0&&!visited[i][j]){
                    int size = 1;
                    visited[i][j] = true;
                    group[i][j] = ++num;
                    ArrayDeque<Node> q = new ArrayDeque<>();
                    q.add(new Node(j,i));
                    while(!q.isEmpty()){
                        Node node = q.poll();
                        int x = node.x;
                        int y = node.y;
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(nx<0||ny<0||nx>=m||ny>=n) continue;
                            if(!visited[ny][nx]&&board[ny][nx]==0){
                                visited[ny][nx] = true;
                                group[ny][nx] = num;
                                size++;
                                q.add(new Node(nx,ny));
                            }
                        }
                    }
                    groupSize.put(num,size);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = 0;
                if(board[i][j]==1){
                    cnt++;
                    HashSet<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nx = j + dx[k];
                        int ny = i + dy[k];
                        if(ny<0||nx<0||ny>=n||nx>=m) continue;
                        if(board[ny][nx]==0){
                            set.add(group[ny][nx]);
                        }
                    }
                    for (Integer g : set) {
                        cnt += groupSize.get(g);
                    }
                }
                sb.append(cnt%10);
            }
            sb.append('\n');
        }
        System.out.print(sb);
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