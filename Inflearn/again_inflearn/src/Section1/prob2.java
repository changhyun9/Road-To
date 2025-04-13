package Section1;

import java.io.*;
import java.util.*;

public class prob2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        StringBuilder sb = new StringBuilder();


        for (char ch : input.toCharArray()) {
            if (ch >= 97 && ch <= 133) {
                ch -= 32;
            } else {
                ch += 32;
            }
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
