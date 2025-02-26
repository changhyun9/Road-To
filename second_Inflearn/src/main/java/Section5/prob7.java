package Section5;

import java.io.*;
import java.util.*;

public class prob7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String course = bf.readLine();
        String plan = bf.readLine();
        String answer = "YES";


        // 강의 해설 필수로 들어야하는 과목은 Queue에 넣고, 과목 계획을 순서대로 접근한다.
        // 해당 과목이 필수 과목인지 확인하고, 필수 과목이면 지금 들어도 되는지, 선수 과목이 있는지 확인
        // 선수 과목이 없다는 건 Queue 의 맨 앞에 있다는 것이니까 peek() 비교
        Queue<Character> queue = new LinkedList<>();
        for (char x : course.toCharArray()) {
            queue.offer(x);
        }

        for (char x : plan.toCharArray()) {
            if (queue.contains(x)) {
                if (queue.poll() != x) {
                    answer = "NO";
                    break;
                }
            }
        }
        if (!queue.isEmpty()) {
            answer = "NO";
        }

        System.out.println(answer);
    }
}
