package Section5;

import java.util.Scanner;
import java.util.Stack;

public class Q4 {
    /**
     * 내가 구현한 방법
     * 문자열을 입력받고, 문자열 요소를 하나씩 탐색하면서
     * 숫자면 stack에 push, 숫자가 아니면 stack에서
     * pop을 두번하여 피연산자를 구한뒤 해당 문자열의 요소로
     * 연산을 진행. 연산 결과는 다시 stack에 저장한다.
     * 모든 문자열 요소를 판별하고, stack의 마지막 값을
     * 추출하여 결과값으로 저장.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Stack<Integer> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch-'0');
            } else {
                int exp1 = stack.pop();
                int exp2 = stack.pop();
                switch (ch) {
                    case '+' :
                        stack.push(exp2 + exp1);
                        break;
                    case '-' :
                        stack.push(exp2 - exp1);
                        break;
                    case '*' :
                        stack.push(exp2 * exp1);
                        break;
                    default:
                        stack.push(exp2 / exp1);
                }
            }
        }
        System.out.println(stack.peek());
    }
}
