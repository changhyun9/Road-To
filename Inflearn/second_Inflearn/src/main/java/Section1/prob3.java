package Section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String[] words = input.split(" ");
        int max = Integer.MIN_VALUE;
        int idx = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > max) {
                max = word.length();
                idx = i;
            }
        }

        System.out.println(words[idx]);
    }
}
