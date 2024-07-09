package etc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class p1874 {
    /**
     * 풀이 방법을 떠올리지 못해 서치해서 문제를 품.
     * 자료구조에 대한 정확한 파악을 했는가를 묻는 문제 같음.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        int start = 0;

        while (n-- > 0) {
            int value = sc.nextInt();

            if (value > start) {
                for (int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    list.add("+");
                }
                start = value;
            } else if (stack.peek() != value) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            list.add("-");
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}
