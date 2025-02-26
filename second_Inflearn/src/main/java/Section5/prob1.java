package Section5;

import java.io.*;
import java.util.Stack;

public class prob1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        Stack<Character> stack = new Stack<>();
        String answer = "YES";
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(') stack.add(input.charAt(i));
            else{
                if (!stack.empty()) {
                    stack.pop();
                } else {
                    answer = "NO";
                    break;
                }
            }
        }
        if (!stack.empty()) {
            answer = "NO";
        }

        System.out.println(answer);



    }
}
