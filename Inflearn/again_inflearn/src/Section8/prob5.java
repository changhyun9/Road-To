package Section8;

import java.io.*;
import java.util.*;

public class prob5 {
    static int n,m, answer = Integer.MAX_VALUE;
    static int[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        coins = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(bf.readLine());

        DFS(0, 0);

        System.out.println(answer);
    }

    static void DFS(int L, int sum) {
        if(sum > m) return;
        if(answer < L) return;
        if (sum == m) {
            answer = Math.min(answer, L);
        } else {
            for (int i = n-1; i >=0; i--) {
                DFS(L + 1, sum + coins[i]);
            }
        }
    }
}
