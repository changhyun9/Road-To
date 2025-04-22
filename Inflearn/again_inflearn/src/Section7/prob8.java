package Section7;

import java.io.*;
import java.util.*;

public class prob8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        int[] mem = new int[100001];
        int[] dx = {5, 1, -1};

        int cnt = 0;
        boolean flag = false;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer poll = queue.poll();
                if (poll == e) {
                    flag = true;
                    break;
                }
                for (int k = 0; k < 3; k++) {
                    int nx = poll + dx[k];
                    if (nx >= 0 && nx <= 10000 && mem[nx] == 0) {
                        queue.offer(nx);
                        mem[nx] = 1;
                    }
                }
            }
            if(flag) break;
            cnt++;
        }
        System.out.println(cnt);

    }
}
