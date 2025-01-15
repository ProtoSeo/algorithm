class Solution {
    public int minimizeXor(int num1, int num2) {
        int bitCount = getBitCount(num2);
        int[] bitArray = getBinaryIntArray(num1);
        int[] result = new int[32];

        for (int i = 31; i >= 0 && bitCount > 0; i--) {
            if (bitArray[i] == 1) {
                result[i]++;
                bitCount--;
            }
        }
        for (int i = 0; i < 32 && bitCount > 0; i++) {
            if (result[i] == 0) {
                result[i]++;
                bitCount--;
            }
        }

        return getNumber(result);
    }

    public int getBitCount(int num) {
        int cnt = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                cnt++;
            }
            num /= 2;
        }
        return cnt;
    }

    public int[] getBinaryIntArray(int num) {
        int[] result = new int[32];
        String bin = Integer.toBinaryString(num);
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(bin.length() - i - 1) == '1') {
                result[i]++;
            }
        }
        return result;
    }

    public int getNumber(int[] bitArray) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += (bitArray[i] << i);
        }
        return result;
    }
}
