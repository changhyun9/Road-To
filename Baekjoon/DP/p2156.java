package DP;

import java.util.Scanner;

public class p2156 {
    /**
     * 나의 구현방법 -> 못풀어서 검색해서 정답 확인함.
     * 처음에 계단 오르는 문제와 비슷하다는 것을 보고 접근을 해보았는데
     * 점화식이 떠오르지 않았다. 그래서 정답을 보고 문제를 해결함.
     * 우선 3가지의 경우를 정의하기 때문에 Index가 0,1,2 를 미리 정의를 한다.
     * 그 다음엔 XOO, OXO, OOX 3가지 경우 중 가장 큰 값을 해당 index에 저장을 함.
     * 구조적으로 3개의 연속적인 값을 가질 수 없음. 연속적인 값이 저장되었을 경우를 대비하여, (연속적인)dp[i-1]를 확인.
     * 그리고 한칸 띄어서 (연속적인)dp[i-2] + arr[i]를 구함. 마지막으로 둘다 연속적이지 않을 경우엔 dp[i-3] + arr[i-1] + arr[i]를 구함.
     * 여기서 연속적인 값을 만들어버림.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        dp[1] = arr[1];
        if (N > 1) {
            dp[2] = arr[1] + arr[2];
        }
        for (int i = 3; i <= N; i++) {
            // dp[i-1] -> ?OX (비연속), 이전 값이 혹시나 연속일수도 있기에 현재 값을 안더함.
            // dp[i-2] + arr[i] -> OXO (비연속), 두칸 전이기 때문에 해당 dp값이 연속인 것과 관계없이 현재 값을 더해도 됨, 근데 두칸 전이 연속일수도 있기에 i-1은 안함
            // dp[i-3] + arr[i-1] + arr[i] -> XOO (연속), 세칸 전이기 때문에 해당 dp값이 연속이든, 비연속이든 ,현재 값에서 무조건 연속을 만듦.
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i])); // OOX, XOO, OXO 3가지 경우 중 가장 큰값
        }

        System.out.println(dp[N]);

    }
}
