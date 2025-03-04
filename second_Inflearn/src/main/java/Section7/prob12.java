package Section7;

import java.io.*;
import java.util.*;

public class prob12 {
    static int n, m, answer;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ch = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        ch[1] = 1;
        DFS(1);
        System.out.println(answer);
    }

    static void DFS(int v) {
        if (v == n) {
            answer++;
        } else {
            for (Integer num : graph.get(v)) {
                if (ch[num] == 0) {
                    ch[num] = 1;
                    DFS(num);
                    ch[num] = 0;
                }
            }
        }
    }
}
