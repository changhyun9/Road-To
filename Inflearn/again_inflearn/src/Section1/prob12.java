package Section1;

import java.io.*;
import java.util.*;

public class prob12 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String input = bf.readLine();
        input = input.replace("*", "0");
        input = input.replace("#", "1");

        String answer = "";

        for (int i = 0; i < n; i++) {
            int idx = 7 * i;
            String word = input.substring(idx, idx + 7);
            answer += (char) Integer.parseInt(word, 2);
            // parseInt(바꿀 String, 바꿀 String의 진수)
        }

        System.out.println(answer);

    }
}
