class Solution {
    public String intToRoman(int num) {
        StringBuilder answer = new StringBuilder();
        if (num >= 1000) {
            for (int i = 0; i < num / 1000; i++) {
                answer.append("M");
            }
            num %= 1000;
        }
        if (num >= 100) {
            if (num >= 900) {
                answer.append("CM");
            } else if (num >= 800) {
                answer.append("DCCC");
            } else if (num >= 700) {
                answer.append("DCC");
            } else if (num >= 600) {
                answer.append("DC");
            } else if (num >= 500) {
                answer.append("D");
            } else if (num >= 400) {
                answer.append("CD");
            } else if (num >= 300) {
                answer.append("CCC");
            } else if (num >= 200) {
                answer.append("CC");
            } else if (num >= 100) {
                answer.append("C");
            }
            num %= 100;
        }
        if (num >= 10) {
            if (num >= 90) {
                answer.append("XC");
            } else if (num >= 80) {
                answer.append("LXXX");
            } else if (num >= 70) {
                answer.append("LXX");
            } else if (num >= 60) {
                answer.append("LX");
            } else if (num >= 50) {
                answer.append("L");
            } else if (num >= 40) {
                answer.append("XL");
            } else if (num >= 30) {
                answer.append("XXX");
            } else if (num >= 20) {
                answer.append("XX");
            } else if (num >= 10) {
                answer.append("X");
            }
            num %= 10;
        }
        if (num >= 1) {
            if (num == 9) {
                answer.append("IX");
            } else if (num == 8) {
                answer.append("VIII");
            } else if (num == 7) {
                answer.append("VII");
            } else if (num == 6) {
                answer.append("VI");
            } else if (num == 5) {
                answer.append("V");
            } else if (num == 4) {
                answer.append("IV");
            } else if (num == 3) {
                answer.append("III");
            } else if (num == 2) {
                answer.append("II");
            } else if (num == 1) {
                answer.append("I");
            }
        }
        return answer.toString();
    }
}
