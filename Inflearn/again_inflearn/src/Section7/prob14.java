package Section7;

import java.io.*;
import java.util.*;

public class prob14 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1];
        int[] visited = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s][e] = 1;
        }

        queue.offer(1);
        visited[1] = 1;

        int L = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer poll = queue.poll();
                for (int k = 1; k <= n; k++) {
                    if (graph[poll][k] == 1 && visited[k] == 0) {
                        visited[k] = L;
                        queue.offer(k);
                    }
                }
            }
            L++;
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + visited[i]);
        }
    }
}
