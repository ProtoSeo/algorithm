class Solution {
    public boolean isHappy(int n) {
        Set<Integer> isVisited = new HashSet<>();
        while (n != 1) {
            isVisited.add(n);
            n = calculate(n);
            if (isVisited.contains(n)) {
                return false;
            }
        }
        return true;
    }

    public int calculate(int n) {
        int result = 0;
        while (n > 0) {
            int t = n % 10;
            result += t * t;
            n /= 10;
        }
        return result;
    }
}
