package StackandDeque;

import java.io.*;
import java.util.*;

public class p10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        Stack<Character> stack = new Stack<>();
        char prior = ' ';
        int answer = 0;

        for (char ch : input.toCharArray()) {
            if (ch == ')') {
                if (prior == '(') {
                    stack.pop();
                    answer += stack.size();

                } else {
                    stack.pop();
                    answer += 1;
                }
                prior = ')';
            } else {
                prior = '(';
                stack.push('(');
            }
        }

        System.out.println(answer);
    }
}
