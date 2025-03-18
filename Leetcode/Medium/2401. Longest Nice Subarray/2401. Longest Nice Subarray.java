class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l = 0, r = 0;
        int bit = 0;
        int result = 0;
        while (r < nums.length) {
            int num = nums[r];
            while (l < r && (bit & num) > 0) {
                bit ^= nums[l++];
            }
            bit |= num;
            r++;
            result = Math.max(result, r - l);
        }
        return result;
    }
}
