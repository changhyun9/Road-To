package Section7;

import java.io.*;
import java.util.*;

public class prob13 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dis = new int[n + 1];
        int[][] graph = new int[n + 1][n + 1];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }
        dis[1] = 0;
        queue.offer(1);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int j = 1; j <= n; j++) {
                if (graph[poll][j] == 1 && dis[j] == 0) {
                    dis[j] = dis[poll] + 1;
                    queue.offer(j);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
