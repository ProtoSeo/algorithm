class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hash.containsKey(nums[i])) {
                hash.put(nums[i], new ArrayList<>());
            }
            List<Integer> index = hash.get(nums[i]);
            index.add(i);
            hash.put(nums[i], index);
        }
        for (int key : hash.keySet()) {
            if (hash.containsKey(target - key)) {
                if (key + key == target) {
                    return new int[] {hash.get(key).get(0), hash.get(key).get(1)};
                }
                return new int[] {hash.get(key).get(0), hash.get(target - key).get(0)};
            }
        }
        return null;
    }
}
