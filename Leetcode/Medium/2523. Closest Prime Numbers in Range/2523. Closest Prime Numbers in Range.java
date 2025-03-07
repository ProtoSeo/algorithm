class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int gap = Integer.MAX_VALUE;
        int prev = -1;
        int l = -1;
        int r = -1;
        for (int i = left; i <= right; i++) {
            if (!isPrime[i]) {
                continue;
            }
            if (prev != -1) {
                if (gap > i - prev) {
                    l = prev;
                    r = i;
                    gap = r - l;
                }
            }
            prev = i;
        }
        return new int[]{l, r};
    }
}
