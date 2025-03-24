class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        int result = 0;
        int prev = 0;
        for (int[] meeting : meetings) {
            int s = meeting[0];
            int e = meeting[1];

            if (s > prev + 1) {
                result += s - prev - 1;
            }
            prev = Math.max(prev, e);
        }
        return result + (days - prev);
    }
}
