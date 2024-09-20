package DP;

import java.util.Scanner;

public class p11052 {
    /**
     * 나의 구현방법
     * 이전에 인프런 강의에서 풀었던 동전교환 문제가 떠오름. 그래서 바로 dp로 접근했음.
     * N크기의 2개의 배열을 생성하고, 하나는 dp를 max 값을 저장하고, 나머지 하나는 카드팩의
     * 가격을 저장함. 이후, 이중 for문을 사용해서 무조건 하나의 카드팩을 뽑는다고 가정한 후
     * dp값을 최신화한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[N + 1];
        int[] pack = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int price = sc.nextInt();
            pack[i] = price;
        }

        dp[1] = pack[1];

        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                dp[j] = Math.max(dp[j], dp[j - i] + pack[i]);
            }
        }


        int max = 0;
        for (int number : dp) {
            max = Math.max(max, number);
        }

        System.out.println(max);
    }
}
