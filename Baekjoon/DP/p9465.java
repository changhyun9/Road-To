package DP;

import java.util.Scanner;

public class p9465 {
    /**
     * 나의 구현방법
     * 못풀어서, 해답 봄.
     * 모든 경우를 찾아, 점화식 세우는 것이 핵심포인트.
     * 해당 문제에서는 2가지 경우가 있음.
     * OXO                  OXX
     * XOX <- 1번경우 2번경우 ->XXO 그래서 -2 까지 범위를 확인함.
     * 대각선 값을 확인해서 최대값이 되는 값을 선택하여 더함.
     * DP 문제를 접근할 때 점화식과 해당 인덱스가 최대값이 될 수 있는 값을
     * 찾는다는 생각으로 문제풀이 할 것.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int k = 0; k < T; k++) {
            int N = sc.nextInt();

            int[][] dp = new int[2][N + 1];
            int[][] arr = new int[2][N + 1];

            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= N; j++) {
                    int num = sc.nextInt();
                    arr[i][j] = num;
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int i = 2; i <= N; i++) {
                dp[0][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + arr[1][i];
            }

            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i++) {
                max = Math.max(Math.max(dp[0][i], dp[1][i]), max);
            }

            System.out.println(max);

        }
    }
}
