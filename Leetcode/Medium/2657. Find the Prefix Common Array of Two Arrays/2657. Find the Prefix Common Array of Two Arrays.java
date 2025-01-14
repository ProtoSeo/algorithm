class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int max = 0;
        int[] count = new int[n + 1];
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (++count[A[i]] == 2) {
                max++;
            }
            if (++count[B[i]] == 2) {
                max++;
            }
            answer[i] = max;
        }
        return answer;
    }
}
