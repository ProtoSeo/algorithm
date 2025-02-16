class Solution {
    public int punishmentNumber(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (parse(String.valueOf(i * i), i)) {
                result += i * i;
            }
        }
        return result;
    }

    boolean parse(String num, int target) {
        if (num.length() == 0 && target == 0) {
            return true;
        } else if (target < 0) {
            return false;
        }
        for (int i = 1; i <= num.length(); i++) {
            if (parse(num.substring(i), target - Integer.parseInt(num.substring(0, i)))) {
                return true;
            }
        }
        return false;
    }
}
