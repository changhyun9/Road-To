package Section7;

import java.io.*;
import java.util.*;

public class prob11 {
    static int n, m, answer;
    static List<Integer> list = new ArrayList<>();
    static int[][] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }

        list.add(1);
        DFS(1);
        System.out.println(answer);
    }

    static void DFS(int L) {
        if (L == n) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (graph[L][i] == 1 &&!list.contains(i)) {
                    list.add(i);
                    DFS(i);
                    list.remove((Integer)i); // int 값 넘기면 index로 삭제, Object 값으로 삭제
                }
            }
        }

    }
}
