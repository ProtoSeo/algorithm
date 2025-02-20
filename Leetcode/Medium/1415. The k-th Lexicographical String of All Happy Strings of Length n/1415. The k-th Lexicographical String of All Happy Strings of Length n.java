class Solution {
    char[] l = {'a', 'b', 'c'};
    int cnt = 0;
    public String getHappyString(int n, int k) {
        char[] result = new char[n];
        if (find(0, n, k, result)) {
            return new String(result);
        }
        return "";
    }

    boolean find(int idx, int n, int k, char[] result) {
        if (idx == n) {
            if (++cnt == k) {
                return true;
            }
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (idx > 0 && result[idx - 1] == l[i]) {
                continue;
            }
            result[idx] = l[i];
            if (find(idx + 1, n, k, result)) {
                return true;
            }
        }
        return false;
    }
}
