class Solution {
    public boolean checkPowersOfThree(int n) {
        List<Integer> power = new ArrayList<>();
        int num = 1;
        while (num <= n) {
            power.add(num);
            num *= 3;
        }
        for (int i = power.size() - 1; i >= 0; i--) {
            int p = power.get(i);
            if (n - p < 0) {
                continue;
            }
            n -= p;
            if (n == 0) {
                return true;
            }
        }
        return false;
    }
}
