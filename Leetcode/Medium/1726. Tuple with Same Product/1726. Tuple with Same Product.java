class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int mul = nums[i] * nums[j];
                counts.merge(mul, 1, Integer::sum);
            }
        }
        int result = 0;
        for (int val : counts.values()) {
            result += 4 * val * (val - 1);
        }
        return result;
    }
}
