class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int result = 1;
        int inc = 1;
        int dec = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            } else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;
            } else {
                inc = dec = 1;
            }
            result = Math.max(result, Math.max(inc, dec));
        }
        return result;
    }
}
