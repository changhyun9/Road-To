package DP;

import java.util.Scanner;


public class p11053 {
    /**
     * 처음엔 그냥 list에 넣어서, 오름차순 정렬 시킨다음에 Set으로 중복을 제거하고 size를 출력하였다 -> 실패
     * LIS 개념 적용
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] seq = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i <n; i++) {
            seq[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
