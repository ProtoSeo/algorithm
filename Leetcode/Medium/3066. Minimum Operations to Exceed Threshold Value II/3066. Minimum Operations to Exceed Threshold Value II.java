class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int num : nums) {
            q.add((long) num);
        }
        int result = 0;
        while (q.peek() < k) {
            result++;
            long a = q.poll();
            long b = q.poll();
            q.add(a * 2 + b);
        }
        return result;
    }
}
