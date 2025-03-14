class Solution {
    public int maximumCandies(int[] candies, long k) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < candies.length; i++) {
            r = Math.max(candies[i], r);
        }
        int answer = 0;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (mid == 0) {
                break;
            }
            long count = 0;
            for (int i = 0; i < candies.length; i++) {
                count += (candies[i] / mid);
            }
            if (count >= k) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
