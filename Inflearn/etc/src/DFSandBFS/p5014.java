package DFSandBFS;

import java.io.*;
import java.util.*;

public class p5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] min = new int[F+1];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(min, Integer.MAX_VALUE);
        queue.offer(S);
        min[S] = 0;


        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            if (poll == G) {
                System.out.println(min[G]);
                return;
            }

            int tx = poll + U;
            if (tx >= 1 && tx <= F && min[tx] > min[poll] + 1) {
                queue.offer(tx);
                min[tx] = min[poll] + 1;
            }


            tx = poll - D;
            if (tx >= 1 && tx <= F && min[tx] > min[poll] + 1) {
                queue.offer(tx);
                min[tx] = min[poll] + 1;
            }
        }

        System.out.println("use the stairs");

    }
}
