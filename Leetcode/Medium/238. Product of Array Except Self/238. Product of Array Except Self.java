class Solution {
    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
                continue;
            }
            total *= num;
        }

        int n = nums.length;
        int[] answer = new int[n];
        if (zeroCount > 1) {
            return answer;
        }
        for (int i = 0; i < n; i++) {
            if (zeroCount == 1 && nums[i] != 0) {
                answer[i] = 0;
                continue;
            }
            if (nums[i] == 0) {
                answer[i] = total;
            } else {
                answer[i] = total / nums[i];
            }
        }
        return answer;
    }
}
