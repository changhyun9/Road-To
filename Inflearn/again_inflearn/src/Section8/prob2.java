package Section8;

import java.io.*;
import java.util.*;

public class prob2 {
    static int c,n, answer = Integer.MIN_VALUE;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        DFS(0, 0);

        System.out.println(answer);

    }

    static void DFS(int sum, int L) {
        if(sum > c) return;
        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(sum + arr[L], L + 1);
            DFS(sum, L + 1);
        }
    }
}
