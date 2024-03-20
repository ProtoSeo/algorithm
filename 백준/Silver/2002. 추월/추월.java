import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputNumber = new String[n];
        Map<String, Integer> outputs = new HashMap<>();

        for (int i = 0; i < n; i++) {
            inputNumber[i] = br.readLine();
        }
        for (int i = 0; i < n; i++) {
            outputs.put(br.readLine(), i);
        }

        Set<String> carNumbers = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int inputIndex = outputs.get(inputNumber[i]);
            for (int j = i + 1; j < n; j++) {
                int outputIndex = outputs.get(inputNumber[j]);
                if (outputIndex < inputIndex) {
                    carNumbers.add(inputNumber[j]);
                }
            }
        }
        System.out.println(carNumbers.size());
    }
}
