package Section5;

import java.io.*;
import java.util.*;

public class prob5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        int answer = 0;

        Stack<Character> stack = new Stack<>();
        char prior = ' ';
        for (char ch : input.toCharArray()) {
            if (ch == '(') {
                prior = '(';
                stack.push(ch);
            } else {
                if (prior == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    answer++;
                    stack.pop();
                }
                prior = ')';
            }
        }

        System.out.println(answer);
    }

}
