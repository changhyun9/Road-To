package 스택의활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p4949 {
    /**
     * 나의 풀이 방법 : 스택을 이용하여 문제를 풀었고, 여는 괄호 일때는 삽입만
     * 닫는 괄호일떄에는 스택이 비어 있지 않고, 맨 위의 괄호가 대응이 될 때만 pop한다.
     * 그렇지 않으면 false로 값을 설정하고 종료.
     * 마지막 부분에 여는 괄호 하나를 입력받는 예외 케이스를 생각하지 못함.
     * 여는 괄호는 삽입만 하기 때문에 true, false 로직을 거치지 않아서 무조건 true로 설정됨
     * 그래서 마지막 부분에 스택이 비어있는지 아닌지 확인하는 로직을 두어 해결.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String input = bf.readLine();
            if(input.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(' || input.charAt(i) == '[') {
                    stack.push(input.charAt(i));
                } else if(input.charAt(i) == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                    else{
                        flag = false;
                        break;
                    }
                } else if (input.charAt(i) == ']') {
                    if(!stack.isEmpty() &&stack.peek() == '[') stack.pop();
                    else{
                        flag = false;
                        break;
                    }
                }
            }

            if(!stack.isEmpty()) flag = false;
            if (!flag) {
                System.out.println("no");
            } else{
                System.out.println("yes");
            }

        }

    }
}
