package Section5;

import java.io.*;
import java.util.*;

public class prob4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        Stack<Integer> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int b = stack.pop();
                int a = stack.pop();
                int answer = 0;
                switch (ch) {
                    case '+' :
                        answer = a + b;
                        break;
                    case '-':
                        answer = a - b;
                        break;
                    case '*':
                        answer = a * b;
                        break;
                    case '/':
                        answer = a / b;
                }
                stack.push(answer);
            } else {
                stack.push(Character.getNumericValue(ch));
            }
        }
        System.out.println(stack.pop());
    }
}
