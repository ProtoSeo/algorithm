class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    result = Math.max(result, (nums[i] - nums[j]) * (long) nums[k]);
                }
            }
        }
        return result;
    }
}
