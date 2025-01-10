class Solution {
    int[] dx = {0, 1};
    int[] dy = {1, -1};
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int numCols = getNumCol(s, numRows);
        char[][] ary = new char[numRows][numCols];

        int idx = 0;
        int x = 0;
        int y = 0;
        ary[y][x] = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            int yy = y + dy[idx];
            int xx = x + dx[idx];
            ary[yy][xx] = s.charAt(i);
            y = yy;
            x = xx;
            if (yy == numRows - 1) {
                idx = 1;
            } else if (yy == 0) {
                idx = 0;
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (ary[i][j] != '\0') {
                    answer.append(ary[i][j]);
                }
            }
        }
        return answer.toString();
    }

    private int getNumCol(String s, int numRows) {
        int idx = 0;
        int numCols = 0;
        for (int i = 0; i < s.length(); idx++, numCols++) {
            if (idx % (numRows - 1) == 0) {
                i += numRows;
                continue;
            }
            i++;
        }
        return numCols;
    }
}
