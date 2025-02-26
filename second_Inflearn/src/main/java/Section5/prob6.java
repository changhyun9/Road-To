package Section5;

import java.io.*;
import java.util.*;

public class prob6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();


        // 너무 비효율. 딱 m번째만 빼내고, 다시 집어넣는 로직이 없는 코드를 짜야 효율적이다.
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int cnt = 0;
        while (queue.size() != 1) {
            Integer poll = queue.poll();
            cnt++;
            if (cnt == m) {
                cnt = 0;
                continue;
            }
            queue.offer(poll);
        }

        // 강의 해설 마찬가지로 앞에서 꺼내서 뒤로 넣어줌. m-1 까지 넣고, 뒤는 무조건 poll. 이 과정을 queue 사이즈가 1이 될 때까지 반복.
        while (!queue.isEmpty()) {
            for (int i = 1; i < m; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
            if(queue.size() == 1) break;
        }

        System.out.println(queue.poll());







    }
}
