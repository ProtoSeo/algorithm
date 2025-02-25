class Solution {
    public int numOfSubarrays(int[] arr) {
        int count = 0;
        int prefixSum = 0;
        int odd = 0;
        int even = 1;
        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 == 0) {
                count += odd;
                even++;
            } else {
                count += even;
                odd++;
            }
            count %= 1000000007;
        }
        return count;
    }
}
