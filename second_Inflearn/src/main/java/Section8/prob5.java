package Section8;

import java.io.*;
import java.util.*;

// 강의 해설 DFS로 풀었는데, 처음 보자마자 최소, 개수 라는 단어들이 보여 BFS로 접근했음.
// DFS로 풀 경우,coins 내림차순 정렬을 해야하는 번거로움이 있기에. BFS가 더 효율적이라 판단.

public class prob5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(bf.readLine());
        int[] ch = new int[m + 1];
        Queue<Integer> queue = new LinkedList<>();
        int L = 1;
        for (int num : coins) {
            queue.offer(num);
        }
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer poll = queue.poll();
                for (int num : coins) {
                    int nx = num + poll;
                    if (nx <= m && ch[nx] == 0) {
                        ch[nx] = L+1;
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }
        System.out.println(ch[m]);
    }
}
