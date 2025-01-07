import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int maxCount = 0;
        int result = 0;
        for (int k : count.keySet()) {
            int v = count.get(k);
            if (maxCount < v) {
                maxCount = v;
                result = k;
            }
        }
        return result;
    }
}
