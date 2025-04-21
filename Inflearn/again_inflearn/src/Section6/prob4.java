package Section6;

import java.io.*;
import java.util.*;

public class prob4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<String> queue = new LinkedList<>();

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            String work = st.nextToken();
            if (queue.contains(work)) {
                queue.remove(work);
                queue.offer(work);
            } else {
                if (queue.size() == n) {
                    queue.poll();
                }
                queue.offer(work);
            }
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.pollLast()+ " ");
        }

    }
}
