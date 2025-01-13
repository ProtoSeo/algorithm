class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int[] index = new int[words.length];
        int idx = 0;
        int width = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (width + word.length() > maxWidth) {
                idx++;
                width = 0;
            }
            index[i] = idx;
            width += (word.length() + 1);
        }

        List<String> result = new ArrayList<>();
        int now = 0;
        for (int i = 0; i <= idx; i++) {
            List<String> nowWords = new ArrayList<>();
            int lengthSum = 0;
            int count = 0;
            for (; now < words.length && index[now] == i; now++) {
                String word = words[now];
                nowWords.add(word);
                lengthSum += word.length();
                count++;
            }
            int gap = maxWidth - lengthSum;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < nowWords.size(); j++, count--) {
                sb.append(nowWords.get(j));
                if (count <= 1) {
                    break;
                }
                if (i == idx) {
                    sb.append(' ');
                    continue;
                }
                int whitespace = (int) Math.ceil(gap / (count - 1.0));
                for (int k = 0; k < whitespace; k++) {
                    sb.append(' ');
                }
                gap -= whitespace;
            }
            if (sb.length() < maxWidth) {
                int temp = maxWidth - sb.length();
                while (temp-- > 0) {
                    sb.append(' ');
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
}
