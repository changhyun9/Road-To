package Section8;

import java.io.*;
import java.util.*;

public class prob4 {
    static int n, m;
    static int[] ch;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ch = new int[m];

        for (int i = 1; i <= n; i++) {
            ch[0] = i;
            DFS(i, 1);
        }

    }

    static void DFS(int idx, int L) {
        if (L == m) {
            for (int num : ch) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                ch[L] = i;
                DFS(i, L + 1);
            }

        }
    }
}
