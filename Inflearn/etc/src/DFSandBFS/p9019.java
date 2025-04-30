package DFSandBFS;

import java.io.*;
import java.util.*;

public class p9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());


        for (int i = 0; i < T; i++) {
            int[] visited = new int[10000];
            String[] command = new String[10000];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(A);
            visited[A] = 1;
            Arrays.fill(command, "");

            while (!queue.isEmpty() && visited[B] == 0) {
                Integer now = queue.poll();
                int D = (now * 2) % 10000;
                int S = now == 0 ? 9999 : now - 1;
                int L = (now % 1000) *10 + now / 1000;
                int R = (now % 10) * 1000 + now / 10;

                if (visited[D] == 0) {
                    queue.add(D);
                    visited[D] = 1;
                    command[D] = command[now] + "D";
                }

                if (visited[S] == 0) {
                    queue.add(S);
                    visited[S] = 1;
                    command[S] = command[now] + "S";
                }

                if (visited[L] == 0) {
                    queue.add(L);
                    visited[L] = 1;
                    command[L] = command[now] + "L";
                }

                if (visited[R] == 0) {
                    queue.add(R);
                    visited[R] = 1;
                    command[R] = command[now] + "R";
                }
            }

            System.out.println(command[B]);
        }
    }
}