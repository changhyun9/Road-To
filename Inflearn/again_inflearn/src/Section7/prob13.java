package Section7;

import java.io.*;
import java.util.*;

public class prob13 {
    static int n,m,answer;
    static List<List<Integer>> map = new ArrayList<>();
    static int[] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ch = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            map.get(s).add(e);
        }

        ch[1] = 1;
        DFS(1);
        System.out.println(answer);

    }

    static void DFS(int L) {
        if (L == n) {
            answer++;
        } else {
            for (Integer num : map.get(L)) {
                if (ch[num] == 0) {
                    ch[num] = 1;
                    DFS(num);
                    ch[num] = 0;
                }
            }
        }
    }
}
