class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        Map<Integer, Integer> ballsColor = new HashMap<>();
        Map<Integer, Integer> countColor = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            if (ballsColor.containsKey(x)) {
                int nowColor = ballsColor.get(x);
                if (nowColor != y) {
                    if (countColor.get(nowColor) == 1) {
                        countColor.remove(nowColor);
                    } else {
                        countColor.put(nowColor, countColor.get(nowColor) - 1);
                    }
                    ballsColor.put(x, y);
                    countColor.merge(y, 1, Integer::sum);
                }
            } else {
                ballsColor.put(x, y);
                countColor.merge(y, 1, Integer::sum);
            }
            result[i] = countColor.size();
        }
        return result;
    }
}
