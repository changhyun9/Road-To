package Section7;

import java.io.*;
import java.util.*;

public class prob8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        int L = 0;
        boolean flag = false;

        while (!queue.isEmpty()) {
            if(flag) break;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll == e) {
                    answer = L;
                    flag = true;
                    break;
                }
                if (e - poll >= 3) {
                    queue.offer(poll + 5);
                } else if (e - poll > 0) {
                    queue.offer(poll + 1);
                } else {
                    queue.offer(poll - 1);
                }
            }
            L++;
        }

        // 강의 해설 check 배열을 하나 만들어서 기존에 들어갔던 값은 다시 Queue에 안들어가도록 설정.
        // BFS는 항상 최단 거리를 반환하기 때문에
        int[] ch = new int[10001];
        int[] dx = {-1, 1, 5};
        ch[s] = 1;
        while (!queue.isEmpty()) {
            if(flag) break;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer poll = queue.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = poll + dx[j];
                    if (nx == e) {
                        answer = L + 1;
                        flag = true;
                        break;
                    }
                    if (nx >= 0 && nx <= 10000 && ch[nx] == 0) {
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }
        System.out.println(answer);
    }
}
