import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int answer = 0;
        for (int e : enemy) {
            if (n - e < 0 && k == 0) {
                break;
            }
            pq.add(e);
            if (n - e < 0) {
                k--;
                n += pq.poll();
            }
            n -= e;
            answer++;
        }
        return answer;
    }
}