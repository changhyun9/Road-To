package 스택의활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p10799 {
    /**
     * 나의 풀이 방법 : 레이저가 나올 경우 스택 사이즈 만큼의 막대가 잘리고, 일반 막대의 괄호가 닫힐 경우 +1을 한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        stack.push(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(input.charAt(i));
            } else {
                if (input.charAt(i - 1) == '(' && input.charAt(i) == ')') {
                    stack.pop();
                    answer += stack.size();
                } else if(input.charAt(i-1) == ')' && input.charAt(i) == ')'){
                    stack.pop();
                    answer ++;
                }
            }
        }

        System.out.println(answer);
    }
}
