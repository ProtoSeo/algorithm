class Solution {
    public int subsetXORSum(int[] nums) {
        return find(0, 0, nums);
    }

    public int find(int n, int value, int[] nums) {
        if (n == nums.length) {
            return value;
        }
        int result = value;
        for (int i = n; i < nums.length; i++) {
            result += find(i + 1, value ^ nums[i], nums);
        }
        return result;
    }
}
