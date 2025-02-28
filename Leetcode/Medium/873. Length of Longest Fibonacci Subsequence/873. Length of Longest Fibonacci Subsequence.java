class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int n = arr.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i];
                int b = arr[j];
                int c = 2;
                while (set.contains(a + b)) {
                    b += a;
                    a = b - a;
                    c++;
                }
                if (c == 2) {
                    c = 0;
                }
                result = Math.max(result, c);
            }
        }
        return result;
    }
}
