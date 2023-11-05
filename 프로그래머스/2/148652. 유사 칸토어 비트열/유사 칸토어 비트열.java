class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        for (long i = l - 1; i < r; i++) {
            if (isBit(i)) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isBit(long i) {
        if (i / 5 == 2 || i % 5 == 2) {
            return false;
        }
        if (i >= 5) {
            return isBit(i / 5);
        }
        return true;
    }
}