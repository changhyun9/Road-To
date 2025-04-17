package Section5;

import java.io.*;
import java.util.*;

public class prob4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        Stack<Integer> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int answer =0;
                Integer first = stack.pop();
                Integer second = stack.pop();
                if (ch == '+') answer = second + first;
                if (ch == '*') answer = second * first ;
                if (ch == '-') answer = second - first;
                if (ch == '/') answer = second / first;
                stack.push(answer);
            }
        }
        System.out.println(stack.pop());
    }

}
