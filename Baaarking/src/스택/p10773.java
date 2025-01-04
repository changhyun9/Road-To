package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p10773 {
    /**
     * 나의 풀이 방법 : 간단하게 Stack을 이용해서 문제 해결
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) stack.pop();
            else stack.push(num);
        }

        int answer =0;
        for (int num : stack) {
            answer += num;
        }
        System.out.println(answer);
    }
}
