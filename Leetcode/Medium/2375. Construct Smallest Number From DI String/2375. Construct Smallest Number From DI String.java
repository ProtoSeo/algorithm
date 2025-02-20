class Solution {
    public String smallestNumber(String pattern) {
        int[] result = new int[pattern.length() + 1];
        find(0, new boolean[10], pattern, result);
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num);
        }
        return sb.toString();
    }

    private boolean find(int idx, boolean[] isVisited, String pattern, int[] result) {
        if (idx == pattern.length() + 1) {
            return true;
        }
        for (int now = 1; now <= 9; now++) {
            if (isVisited[now]) {
                continue;
            }
            if (idx == 0) {
                result[idx] = now;
                isVisited[now] = true;
                if (find(idx + 1, isVisited, pattern, result)) {
                    return true;
                }
                isVisited[now] = false;
                continue;
            }
            char c = pattern.charAt(idx - 1);
            int prev = result[idx - 1];
            if ((c == 'I' && prev < now) || (c == 'D' && prev > now)) {
                result[idx] = now;
                isVisited[now] = true;
                if (find(idx + 1, isVisited, pattern, result)) {
                    return true;
                }
                isVisited[now] = false;
            }
        }
        return false;
    }
}
