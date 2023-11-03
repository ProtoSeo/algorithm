import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int[] target : targets) {
            pq.add(target);
        }
    
        while (!pq.isEmpty()) {
            answer++;
            int[] temp = pq.poll();
            int r = temp[1];
            while (!pq.isEmpty() && pq.peek()[0] < r) {
                pq.poll();
            }
        }
        
        return answer;
    }
}