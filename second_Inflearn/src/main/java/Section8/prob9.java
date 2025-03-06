package Section8;

import java.io.*;
import java.util.*;

public class prob9 {
    static int n, m;
    static int[] comb, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        comb = new int[m];
        arr = new int[n + 1];

        DFS(0, 1);


    }

    static void DFS(int L, int idx) {
        if (L == m) {
            for (int num : comb) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (int i = idx; i <= n; i++) {
                comb[L] = i;
                DFS(L + 1, i+1);
            }
        }
    }
}
