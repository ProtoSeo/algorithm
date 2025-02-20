class Solution {
    Set<String> binary = new HashSet<>();
    public String findDifferentBinaryString(String[] nums) {
        for (String num : nums) {
            binary.add(num);
        }
        int[] ary = new int[nums[0].length()];
        find(0, ary);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ary.length; i++) {
            sb.append(ary[i]);
        }
        return sb.toString();
    }

    private boolean find(int cnt, int[] ary) {
        if (cnt == ary.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ary.length; i++) {
                sb.append(ary[i]);
            }
            return !binary.contains(sb.toString());
        }

        if (find(cnt + 1, ary)) {
            return true;
        }
        ary[cnt] = 1;
        if (find(cnt + 1, ary)) {
            return true;
        }
        return false;
    }
}
