package Section8;

import java.io.*;
import java.util.*;

public class prob8 {
    static int n, f;
    static int[] pm, ch, b;
    static int[][] comb;
    static boolean flag = false;


    // 강의 해설 comb 경우의 수를 미리 구하고, 만들어진 순열과 곱해서 f와 같은지 비
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        ch = new int[n+1];
        pm = new int[n];
        b = new int[n];
        comb = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            b[i] = comb(n - 1, i);
        }

        DFS(0,0);

    }

    static void DFS(int L, int sum) {
        if(sum > f) return;
        if(flag) return;
        if (L == n) {
            if (sum == f) {
                for (int num : pm) {
                    System.out.print(num + " ");
                }
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = i;
                    DFS(L + 1, sum + b[L] * pm[L]);
                    ch[i] = 0;
                }
            }
        }
    }

    static int comb(int n, int r) {
        if(comb[n][r] > 0) return comb[n][r];
        if(n == r || r==0) return 1;
        else if (r==1 || n-r ==1) return n;
        else {
            return comb[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
        }
    }
}
