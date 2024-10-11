package etc;

import java.util.Scanner;
import java.util.Stack;

public class p9935 {
    /**
     * 나의 구현방법 -> 못품
     * 입력받은 문자열을 하나씩 stack에 집어넣음. 이때 스택에 집어넣은 문자이 개수가 폭탄 문자열 길이와
     * 같아지면 스택 상단에서부터 폭탄 문자열 길이만큼 떨어진 곳부터 폭탄 문자열과 같은지 확인함.
     * 만약에 같으면 스택 상단에서부터 폭탄 문자열 길이만큼 pop을 진행함.
     * 매번 스택에 문자가 들어올 때마다 폭탄의 문자열 만큼 확인한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        String input = sc.nextLine();
        String bomb = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));

            if (stack.size() >= bomb.length()) {
                boolean isSame = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) {
                    for (int j = 0; j < bomb.length(); j++)
                        stack.pop();
                }
            }
        }

        for (char ch : stack)
            sb.append(ch);

        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");


    }
}
