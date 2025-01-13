class Solution {
    public int minimumLength(String s) {
        int answer = 0;
        int[] index = new int[26];
        for (char c : s.toCharArray()) {
            index[(int)(c - 'a')]++;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            int cnt = index[(int)(c - 'a')];
            if (cnt < 3) {
                answer += cnt;
                continue;
            }
            if (cnt % 2 == 0) {
                answer += 2;
            } else {
                answer += 1;
            }
        }
        return answer;
    }
}
