class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int n = nums1.length, m = nums2.length;
        int l = 0, r = 0;
        while (l < n && r < m) {
            int id1 = nums1[l][0], id2 = nums2[r][0];
            int val1 = nums1[l][1], val2 = nums2[r][1];
            if (id1 == id2) {
                result.add(new int[]{id1, val1 + val2});
                l++;
                r++;
            } else if (id1 < id2) {
                result.add(new int[]{id1, val1});
                l++;
            } else if (id1 > id2) {
                result.add(new int[]{id2, val2});
                r++;
            }
        }
        while (l < n) {
            result.add(new int[]{nums1[l][0], nums1[l][1]});
            l++;
        }
        while (r < m) {
            result.add(new int[]{nums2[r][0], nums2[r][1]});
            r++;
        }

        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
