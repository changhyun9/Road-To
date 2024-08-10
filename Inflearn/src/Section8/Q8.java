package Section8;

import java.util.Scanner;

public class Q8 {
    /**
     * 나의 구현방법
     * 못품.
     * 강의보면서 해설을 찾고, 따라서 구현함.
     * 해당 문제는 규칙이 있음. 등장하는 순서대로 총 더해지는 수가 정해져 있음.
     * 해당 규칙은 n-1Cr 이고, r은 0부터 n-1까지 하나씩 증가한다.
     * 결국 순열과 등장하는 순서대로 값을 곱해서 더해서 r이 나오면 되는 문제임.
     * 먼저 n이 주어졌을 때, 순열을 구하는 것이 중요함. 그래서 combi 메서드를
     * 구현하여 순열을 값을 구해서 저장. 이후, DFS 메서드를 구현하여, 값을 구함.
     * DFS는 체크 배열을 생성하여 순서를 하나씩 사용해보고, 값을 구하는 방법.
     */
    static int[] b, p, ch;
    static int n, f;
    boolean flag = false;
    int[][] dy = new int[35][35];

    public int combi(int n, int r) {
        if(dy[n][r] >0) return dy[n][r];
        if(n==r || r==0) return 1;
        else return dy[n][r]=combi(n-1, r-1) + combi(n-1, r);
    }

    public static void main(String[] args) {
        Q8 T = new Q8();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];
        for (int i = 0; i < n; i++) {
            b[i] = T.combi(n - 1, i);
        }
        T.DFS(0,0);
    }

    public void DFS(int L, int sum) {
        if(flag) return;
        if (L == n) {
            if (sum == f) {
                for (int x : p) {
                    System.out.print(x + " ");
                    flag = true;
                }
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[L] =i;
                    DFS(L + 1, sum + (p[L] * b[L]));
                    ch[i] = 0;
                }
            }
        }
    }
}
