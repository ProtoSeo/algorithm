// First Solution
import java.util.*;

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] isVisited = new boolean[n];
        q.add(0);
        isVisited[0] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now >= n - 1) {
                return true;
            }
            for (int i = now; i <= now + nums[now] && i < n; i++) {

                if (isVisited[i]) {
                    continue;
                }
                q.add(i);
                isVisited[i] = true;
            }
        }
        return false;
    }
}
// Second Solution
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maximum = 0;
        for (int i = 0; i < n; i++) {
            int now = nums[i];
            if (i > maximum) {
                return false;
            }
            maximum = Math.max(maximum, i + now);
            if (maximum >= n - 1) {
                return true;
            }
        }
        return false;
    }
}
