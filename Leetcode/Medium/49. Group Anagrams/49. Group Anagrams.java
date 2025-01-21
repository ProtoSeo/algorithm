class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (!group.containsKey(sorted)) {
                group.put(sorted, new ArrayList<>());
            }
            List<String> list = group.get(sorted);
            list.add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : group.keySet()) {
            result.add(group.get(key));
        }
        return result;
    }
}
