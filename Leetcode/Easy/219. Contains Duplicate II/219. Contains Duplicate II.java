class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, new ArrayList<>());
            }
            List<Integer> index = map.get(num);
            index.add(i);
            map.put(num, index);
        }
        for (int key : map.keySet()) {
            List<Integer> index = map.get(key);
            for (int i = 0; i < index.size() - 1; i++) {
                if (index.get(i + 1) - index.get(i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
