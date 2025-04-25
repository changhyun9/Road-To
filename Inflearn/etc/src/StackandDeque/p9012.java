package StackandDeque;

import java.io.*;
import java.util.*;

public class p9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            String input = bf.readLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            for (char ch : input.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        flag = true;
                        break;
                    }
                    stack.pop();
                }
            }

            if(!stack.isEmpty()) flag =true;
            if (flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
