class Solution {
    public String simplifyPath(String path) {
        Deque<String> stk = new ArrayDeque<>();
        String[] token = path.split("/");
        StringBuilder sb = new StringBuilder("/");
        for (String t : token) {
            if (t.isBlank() || t.equals(".")) {
                continue;
            } else if (t.equals("..")) {
                if (!stk.isEmpty()) {
                    stk.pollLast();
                }
                continue;
            }
            stk.addLast(t);
        }
        while (!stk.isEmpty()) {
            String t = stk.pollFirst();
            sb.append(t);
            if (stk.isEmpty()) {
                break;
            }
            sb.append("/");
        }
        return sb.toString();
    }
}
