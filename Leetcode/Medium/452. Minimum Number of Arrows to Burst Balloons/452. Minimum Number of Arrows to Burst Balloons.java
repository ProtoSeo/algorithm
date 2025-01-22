class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int result = 0, i = 0;
        while (i < n) {
            result++;
            int e = points[i++][1];
            while (i < n && points[i][0] <= e) {
                i++;
            }
        }
        return result;
    }
}
