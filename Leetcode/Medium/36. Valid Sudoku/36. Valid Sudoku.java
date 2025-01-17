class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] vertical = new int[10];
            int[] horizontal = new int[10];
            int[] sqaure = new int[10];

            for (int j = 0; j < 9; j++) {
                char v = board[j][i];
                char h = board[i][j];
                char s = board[(i / 3) * 3 + (j / 3)][(i % 3) * 3 + (j % 3)];
                if (h != '.' && horizontal[(int)h - '0']++ > 0) {
                    return false;
                }
                if (v != '.' && vertical[(int)v - '0']++ > 0) {
                    return false;
                }
                if (s != '.' && sqaure[(int)s - '0']++ > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
