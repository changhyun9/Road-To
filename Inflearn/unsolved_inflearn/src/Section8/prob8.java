package Section8;

import java.io.*;
import java.util.*;

public class prob8 {

    static int n, f;
    static int[] arr, tmp, num;
    static int[][] dy=new int[35][35];
    static boolean flag = false;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        tmp = new int[n];
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = combi(n - 1, i);
        }

        DFS(0);

    }

    public static int combi(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (r == 0 || n == r) {
            return 1;
        } else {
            return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }

    public static void DFS(int L) {
        if(flag) return;
        if (L == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (tmp[i] * num[i]);
            }

            if (sum == f) {
                for (int num : tmp) {
                    System.out.print(num + " ");
                }
                flag = true;
            }

        } else {
            for (int i = 1; i <= n; i++) {
                if (arr[i] != 1) {
                    arr[i] = 1;
                    tmp[L] = i;
                    DFS(L + 1);
                    arr[i] = 0;
                }
            }

        }
    }
}
