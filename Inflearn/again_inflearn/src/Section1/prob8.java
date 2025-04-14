package Section1;

import java.io.*;
import java.util.*;

public class prob8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        char[] arr = input.toLowerCase().toCharArray();

        StringBuilder sb = new StringBuilder();

        for (char ch : arr) {
            if (Character.isAlphabetic(ch)) {
                sb.append(ch);
            }
        }

        input = sb.toString();
        if (input.equals(sb.reverse().toString())) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
