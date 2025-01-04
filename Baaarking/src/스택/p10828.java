package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p10828 {
    /**
     * 나의 풀이 방법 : 단순하게 Stack 사용해서 구현
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < count; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            String cmd = st.nextToken();
            if (cmd.equals("push")) {
                int data = Integer.parseInt(st.nextToken());
                stack.push(data);
            } else if (cmd.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.pop());
                }
            } else if (cmd.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.peek());
                }
            } else if (cmd.equals("size")) {
                System.out.println(stack.size());
            } else {
                if (stack.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }

        }
    }
}
