class Solution {
    public int solution(int[] picks, String[] minerals) {
        return find(picks, 0, minerals, 0);
    }

    private int find(int[] picks, int idx, String[] minerals, int fatigue) {
        if ((picks[0] == 0 && picks[1] == 0 && picks[2] == 0) || idx >= minerals.length) {
            return fatigue;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (picks[i] == 0) {
                continue;
            }
            picks[i] -= 1;
            int addFatigue = 0;
            int duration = 5;
            int j = idx;
            for (; j < minerals.length && duration > 0; j++, duration--) {
                String mineral = minerals[j];
                if (i == 2 && mineral.equals("diamond")) {
                    addFatigue += 25;
                } else if ((i == 2 && mineral.equals("iron")) || (i == 1 && mineral.equals("diamond"))) {
                    addFatigue += 5;
                } else {
                    addFatigue += 1;
                }
            }
            result = Math.min(result, find(picks, j, minerals, fatigue + addFatigue));
            picks[i] += 1;
        }
        return result;
    }
}
