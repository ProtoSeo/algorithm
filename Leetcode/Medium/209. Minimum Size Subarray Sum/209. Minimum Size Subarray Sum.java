class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int l = 0;
        int r = 0;
        int result = Integer.MAX_VALUE;
        while (l <= r && r <= n) {
            int sum = preSum[r] - preSum[l];
            if (sum < target) {
                r++;
            } else if (sum >= target) {
                result = Math.min(r - l, result);
                l++;
            }
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }
}
