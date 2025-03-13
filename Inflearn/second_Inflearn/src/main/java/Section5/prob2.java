package Section5;

import java.io.*;
import java.util.*;

public class prob2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char x : input.toCharArray()) {
            if(x == '(') stack.push(x);
            else if (x== ')') stack.pop();
            else {
                if(stack.empty()) sb.append(x);
            }
        }

        // 강의 해설은 ')' 만나면, '(' 가 pop 될 때까지 반복
        for (char ch : input.toCharArray()) {
            if(ch == ')') while(stack.pop() != '(');
            else stack.push(ch);
        }
        for(int i=0; i<stack.size(); i++) sb.append(stack.get(i));

        System.out.println(sb);
    }
}
