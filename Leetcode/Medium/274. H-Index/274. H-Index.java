class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int h = 0;
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
            h = Math.max(h, Math.min(citations[i], n - i));
        }
        return h;
    }
}
