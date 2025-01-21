class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int s = intervals[0][0];
        int e = intervals[0][1];
        List<int[]> merged = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int ns = intervals[i][0];
            int ne = intervals[i][1];
            if (ns <= e) {
                e = Math.max(e, ne);
                continue;
            }
            merged.add(new int[]{s, e});
            s = ns;
            e = ne;
        }
        merged.add(new int[]{s, e});
        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }
        return result;
    }
}
