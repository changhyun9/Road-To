package StackandDeque;

import java.io.*;
import java.util.*;

public class p10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = bf.readLine();
            String[] str = input.split(" ");
            String cmd = str[0];
            int value = 0;
            if (str.length > 1) {
                value = Integer.parseInt(str[1]);
            }

            switch (cmd) {
                case "push_front":
                    deque.offerFirst(value);
                    break;
                case "push_back":
                    deque.offerLast(value);
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.pollFirst());
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.pollLast());
                    }
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.getFirst());
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.getLast());
                    }
                    break;
            }
        }
    }
}
