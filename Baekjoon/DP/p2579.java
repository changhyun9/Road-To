package DP;

import java.util.Scanner;

public class p2579 {
    /**
     * 탐색으로 풀어봤지만, 시간초과로 실패
     */
    /*static Integer[] mem;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        mem = new Integer[n + 1];

        mem[0] = 0;
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            mem[i] = num;
        }

        recur(n,0, true);
        System.out.println(max);
    }

    static void recur(int n, int result, boolean flag) {
        if (n == 1 || n == 0) {
            max = Math.max(max, result+mem[n]);
            return;
        } else {
            if (flag) { // true인 경우, -2인 경우
                recur(n - 1, result + mem[n], false);
                recur(n - 2, result + mem[n], true);
            } else {
                recur(n-2, result + mem[n], true);
            }
        }
    }*/

    static Integer dp[];
    static int arr[];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        dp = new Integer[N + 1];
        arr = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = in.nextInt();
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        if(N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(N));

    }

    static int find(int N) {
        if(dp[N] == null) {
            dp[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N];
            // -2에서 올라오는 것과, -1에서 올라오는 것을 커버하기 위한 코드
            // -1에서 올라오는 것은 연속되는 값을 가질 수 없기 때문에 -2에서 올라오는 값을 구함.
        }

        return dp[N];
    }
}
