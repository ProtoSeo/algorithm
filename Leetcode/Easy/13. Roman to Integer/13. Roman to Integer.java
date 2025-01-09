class Solution {
    public int romanToInt(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            char next = ' ';
            if (i < s.length() - 1) {
                next = s.charAt(i + 1);
            }
            if (now == 'I' && next == 'V') {
                answer += 4;
                i++;
                continue;
            } else if (now == 'I' && next == 'X') {
                answer += 9;
                i++;
                continue;
            }  else if (now == 'X' && next == 'L') {
                answer += 40;
                i++;
                continue;
            }  else if (now == 'X' && next == 'C') {
                answer += 90;
                i++;
                continue;
            }  else if (now == 'C' && next == 'D') {
                answer += 400;
                i++;
                continue;
            }  else if (now == 'C' && next == 'M') {
                answer += 900;
                i++;
                continue;
            }
            if (now == 'I') {
                answer += 1;
            } else if (now == 'V') {
                answer += 5;
            } else if (now == 'X') {
                answer += 10;
            } else if (now == 'L') {
                answer += 50;
            } else if (now == 'C') {
                answer += 100;
            } else if (now == 'D') {
                answer += 500;
            } else if (now == 'M') {
                answer += 1000;
            }
        }
        return answer;
    }
}
