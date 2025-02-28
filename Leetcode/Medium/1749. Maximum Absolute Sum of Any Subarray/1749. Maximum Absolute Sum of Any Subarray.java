class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int resultMax = nums[0];
        int resultMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max + nums[i]);
            min = Math.min(nums[i], min + nums[i]);

            resultMax = Math.max(max, resultMax);
            resultMin = Math.min(min, resultMin);
        }
        return Math.max(Math.abs(resultMin), Math.abs(resultMax));
    }
}
