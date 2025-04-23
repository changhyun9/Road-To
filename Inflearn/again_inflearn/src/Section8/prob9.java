package Section8;

import java.io.*;
import java.util.*;

public class prob9 {
    static int n, m;
    static int[] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ch = new int[n+1];
        DFS(0, 0);
    }

    static void DFS(int L, int idx) {
        if (L == m) {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            for (int i = idx + 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    DFS(L + 1, i);
                    ch[i] = 0;
                }
            }

        }
    }
}
