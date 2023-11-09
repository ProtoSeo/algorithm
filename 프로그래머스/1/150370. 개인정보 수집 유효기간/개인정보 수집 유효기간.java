import java.util.*;

class Solution {
    int monthToDay = 28;
    int yearToDay = 28 * 12;
    int[] termToMonth = new int[26];
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        for (String term : terms) {
            String[] split = term.split(" ");
            termToMonth[split[0].charAt(0) - 'A'] = Integer.parseInt(split[1]);
        }
        
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            
            if (isValid(convertDateToInt(today), privacy)) {
                answerList.add(i + 1);    
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    boolean isValid(int today, String privacy) {
        String[] split = privacy.split(" ");
        int validDay = convertDateToInt(split[0]) + termToMonth[split[1].charAt(0) - 'A'] * monthToDay;
        return today >= validDay;
    }
    
    int convertDateToInt(String date) {
        String[] split = date.split("\\.");
        return Integer.parseInt(split[0]) * yearToDay + Integer.parseInt(split[1]) * monthToDay + Integer.parseInt(split[2]);
    }
}