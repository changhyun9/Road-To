package Section5;

import java.io.*;
import java.util.*;

public class prob5 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        Stack<Character> stack = new Stack<>();
        char prior =' ';
        int answer = 0;
        for (char ch : input.toCharArray()) {
            if (ch == ')') {
                stack.pop();
                if (prior == '(') answer += stack.size();
                else answer++;
            } else {
                stack.push('(');
            }
            prior = ch;
        }

        // 강의에서는 forEach 가 아니라 index 기반으로 접근해서 i-1이 '('인지, '('인지 판단
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ')') {
                stack.pop();
                if (input.charAt(i-1) == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            } else {
                stack.push('(');
            }
        }
        System.out.println(answer);
    }
}
