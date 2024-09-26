package DP;

import java.util.Scanner;

public class p12865 {
    /**
     * 나의 구현방법
     * 처음에 knapsack 알고리즘을 떠올렸는데, 어떻게 푸는지 개념이 정확히 잡히지 않았다.
     * 그래도 Prod 클래스 작성하고, List로 정렬한 후 dp[i-w] + v를 했지만
     * 배낭에 제품이 중복으로 들어갈 수없다는 조건을 확인하지 못해서 틀렸다.
     * 이후, 1~w*2-1 까지 했지만 틀렸고, 인프런에서 풀었던 문제를 참고해서 해결함.
     *
     * 강의해설 -> 무게랑 가치를 받으면 최대 무게부터 역순으로 접근. 가치를 획득한 제품은 중복으로
     * 값이 들어가면 안되기 때문에. 최대 무게 부터 해당 제품 무게까지 오면서 최대값을 바꿈.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            for (int j = K; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        System.out.println(dp[K]);
    }
}

