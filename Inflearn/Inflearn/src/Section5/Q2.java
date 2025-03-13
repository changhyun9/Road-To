package Section5;

import java.util.Scanner;
import java.util.Stack;

public class Q2 {
    /**
     * 내가 구현한 방법
     * 입력받은 문자열을 하나씩 돌면서 '(', 여는 괄호면 stack에 push
     * ')', 닫는 괄호면 pop한다. 만약 괄호가 아닌 문자이면 stack의 사이즈를
     * 확인한다. 만약 stack의 사이즈가 0 이면 StringBulider로 + (더하기)연산을
     * 진행하고, 1 이상이면 다음 단계로 넘어간다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                stack.pop();
            } else {
                if (stack.isEmpty()) {
                    sb.append(ch);
                }
            }
        }
        System.out.println(sb.toString());
    }

    /**
     * 모든 문자열을 돌면서, '(', 문자 면 stack에 push를 하고
     * ')'를 만나면 '('를 만날때 까지 pop을 한다. 이렇게 모든 문자열에
     * 대해 연산을 진행하고 난뒤 stack에 남은 값의 역순이 결과값이다.
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Stack<Character> stack = new Stack<>();
        String answer = "";
        for (char ch : input.toCharArray()) {
            if (ch == ')') {
                while (stack.pop() != '(');
            }
            else stack.push(ch);
        }
        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }
        System.out.println(answer);
    }*/
}
