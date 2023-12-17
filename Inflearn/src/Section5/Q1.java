package Section5;

import java.util.Scanner;
import java.util.Stack;

public class Q1 {
    /**
     * 내가 구현한 방법
     * 입력받은 문자열을 하나씩 접근하면서 '(', 여는 괄호면 stack에 push
     * ')', 닫는 괄호면 stack의 사이즈를 보고 비어있지 않으면 pop을 하고
     * 비어 있으면 반복연산을 종료하고, flag을 false로 변경. 이러한 예외 상황이
     * 없으면 마지막에 flag와 stack 사이즈가 0인지를 비교하여 연산 결과를 출
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        boolean flag = true;
        String answer = "NO";

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if (flag && stack.isEmpty()) {
            answer = "YES";
        }

        System.out.println(answer);
    }
}
