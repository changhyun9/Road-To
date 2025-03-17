package Section5;

import java.io.*;
import java.util.*;

public class prob7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String ess = bf.readLine();
        String time = bf.readLine();

        Queue<Character> queue = new LinkedList<>();
        for (char ch : ess.toCharArray()) {
            queue.add(ch);
        }

        String answer = "NO";
        for (char ch : time.toCharArray()) {
            if (!queue.isEmpty() && ch == queue.peek()) {
                queue.poll();
            }
        }
        if (queue.isEmpty()) {
            answer = "YES";
        }
        System.out.println(answer);
    }
}
