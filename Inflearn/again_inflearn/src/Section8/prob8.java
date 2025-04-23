package Section8;

import java.io.*;
import java.util.*;

public class prob8 {
    static int n,f;
    static int[] ch, tmp;
    static int[][] mem;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        ch = new int[n+1];
        tmp = new int[n];

        mem = new int[n][n];

        for (int i = 0; i < n; i++) {
            factorial(n-1, i);
        }

        DFS(0);

    }
    static int factorial (int n, int r) {
        if(mem[n][r] > 0) return mem[n][r];
        if(n==r || r==0) return mem[n][r] = 1;
        else if (n-r == 1 || r==1) return mem[n][r] = n;
        else{
            return mem[n][r] = factorial(n - 1, r - 1) + factorial(n - 1, r);
        }

    }

    static void DFS(int L) {
        if(flag) return;
        if (L == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (tmp[i] * mem[n - 1][i]);
            }
            if (sum == f) {
                for(int num : tmp){
                    flag = true;
                    System.out.print(num + " ");
                }
            }

        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    tmp[L] = i;
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }
}
