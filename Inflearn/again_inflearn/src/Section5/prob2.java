package Section5;

import java.io.*;
import java.util.*;

public class prob2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (stack.isEmpty() && Character.isAlphabetic(ch)) {
                System.out.print(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if(ch == ')') {
                stack.pop();
            }
        }
    }
}
