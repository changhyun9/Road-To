package Section5;

import java.io.*;
import java.util.*;

public class prob7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String pre = bf.readLine();
        String course = bf.readLine();

        Queue<Character> queue = new LinkedList<>();
        for (char ch : pre.toCharArray()) {
            queue.offer(ch);
        }


        for (char ch : course.toCharArray()) {
            if (!queue.isEmpty() && queue.peek() == ch) {
                queue.poll();
            }
        }
        if (queue.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
