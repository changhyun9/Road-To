package Section7;

import java.io.*;
import java.util.*;

public class prob12 {
    static int n, m, answer;
    static int[][] map;
    static int[] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            map[s][e] = 1;
        }

        ch[1] = 1;
        DFS(1);

        System.out.println(answer);

    }

    static void DFS(int L) {
        if (L == n) {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if(map[L][i] == 1){
                    if (ch[i] == 0) {
                        ch[i] = 1;
                        DFS(i);
                        ch[i] = 0;
                    }
                }

            }
        }
    }
}
