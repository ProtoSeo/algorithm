class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 1, count = 1;
        int val = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val + 1) {
                result = Math.max(result, ++count);
            } else if (nums[i] == val) {
                continue;
            } else {
                count = 1;
            }
            val = nums[i];
        }
        return result;
    }
}
