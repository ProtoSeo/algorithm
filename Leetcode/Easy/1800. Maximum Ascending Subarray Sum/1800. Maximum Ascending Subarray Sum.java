class Solution {
    public int maxAscendingSum(int[] nums) {
        int result = 0;
        int sum = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length) {
                result = Math.max(sum, result);
                break;
            }
            if (nums[i - 1] < nums[i]) {
                sum += nums[i];
            } else {
                result = Math.max(sum, result);
                sum = nums[i];
            }
        }
        return result;
    }
}
