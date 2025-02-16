class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] sequence = new int[n * 2 - 1];
        find(0, sequence, new boolean[n + 1], n);
        return sequence;
    }

    boolean find(int idx, int[] sequence, boolean[] isVisited, int target) {
        if (idx == sequence.length) {
            return true;
        }
        if (sequence[idx] != 0) {
            return find(idx + 1, sequence, isVisited, target);
        }
        for (int i = target; i >= 1; i--) {
            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            sequence[idx] = i;
            if (i == 1) {
                if (find(idx + 1, sequence, isVisited, target)) {
                    return true;
                }
            } else if (idx + i < sequence.length && sequence[idx + i] == 0) {
                sequence[idx + i] = i;
                if (find(idx + 1, sequence, isVisited, target)) {
                    return true;
                }
                sequence[idx + i] = 0;
            }
            sequence[idx] = 0;
            isVisited[i] = false;
        }
        return false;
    }
}
