package Section5;

import java.util.Scanner;
import java.util.Stack;

public class Q5 {
    /**
     * 내가 구현한 방법
     * 문자열을 받아서 '(', 여는 괄호면 stack에 push를 한다.
     * ')', 닫는 괄호면 stack에서 pop을 하고, 여는 괄호 바로 다음으로
     * 나왔다면, 해당 닫힌 괄호는 점을 나타내는 것이기 때문에 해당 점으로 인해
     * 생기는 부분 막대의 개수를 더한다. x2를 하지 않고, 막대의 개수 정도만 더하는
     * 이유는 뒤의 막대가 어떠한 점을 지나는지 모르기 때문이다. 또한, 닫힌 괄호가 여는
     * 괄호 직후에 나오는 것이 아니면 , 막대의 끝을 나타내는 것이기 때문에 +1을 더한다.
     * 이유는 잘린 막대의 뒷부분을 의미하기 때문이다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        int result = 0;
        for (char ch : input.toCharArray()) {
            if (ch == '(') {
                flag = true;
                stack.push(ch);
            } else {
                stack.pop();
                if (flag) {
                    result += stack.size();
                } else {
                    result += 1;
                }
                flag = false;
            }
        }
        System.out.println(result);
    }
}
