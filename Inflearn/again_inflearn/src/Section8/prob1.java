package Section8;

import java.io.*;
import java.util.*;

public class prob1 {
    static int n, tmp;
    static int[] arr;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            tmp += arr[i];
        }

        DFS(0, 0);
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    static void DFS(int sum, int L) {
        if(flag) return;
        if (L == n ) {
            if (tmp - sum == sum) {
                flag = true;
            }
        } else {
            DFS(sum + arr[L], L + 1);
            DFS(sum, L + 1);
        }
    }
}
