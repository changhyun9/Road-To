package Section1;

import java.io.*;
import java.util.*;

public class prob9 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String answer = "";

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                answer += ch;
            }
        }
        System.out.println(Long.valueOf(answer));
    }
}
