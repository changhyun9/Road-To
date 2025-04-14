package Section1;

import java.io.*;
import java.util.*;

public class prob6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        String answer = "";

        for (char ch : input.toCharArray()) {
            if (answer.indexOf(ch) == -1) {
                answer += ch;
            }
        }

        System.out.println(answer);
    }
}
