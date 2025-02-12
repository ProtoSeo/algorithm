class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> maximum = new HashMap<>();
        int result = -1;
        for (int num : nums) {
            int sum = getSumOfDigits(num);
            if (maximum.containsKey(sum)) {
                result = Math.max(result, maximum.get(sum) + num);
            }
            maximum.put(sum, Math.max(maximum.getOrDefault(sum, 0), num));
        }
        return result;
    }

    public int getSumOfDigits(int num) {
        int result = 0;
        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }
}
