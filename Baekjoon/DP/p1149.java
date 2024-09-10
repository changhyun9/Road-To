package DP;

import java.util.Scanner;

public class p1149 {
    /**
     * 나의 구현방법 -> 도저히 떠오르지 않아 검색해서 품
     * 검색 풀이는 주석으로 작성
     * 결국 DP는 점화식 찾는 문제다.
     * 문제 해결 알고리즘으로 DP를 떠올렸으면 점화식을 찾을 것
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] rgb = new int[N][3];

        for (int i = 0; i < N; i++) {
            rgb[i][0] = sc.nextInt(); // 빨간색으로 칠할 때 비용 저장
            rgb[i][1] = sc.nextInt(); // 초록색으로 칠할 때 비용 저장
            rgb[i][2] = sc.nextInt(); // 파란색으로 칠할 때 비용 저장
        }

        for (int i = 1; i < N; i++) { // 모든 줄을 돌면서 모든 경우의 수를 판독
            rgb[i][0] += Math.min(rgb[i - 1][1], rgb[i - 1][2]); // 해당 중에서 빨간 집을 칠하겠다. 그럼 이전의 초록, 파란 줄과 더한 것중 작은 값을 선택
            rgb[i][1] += Math.min(rgb[i - 1][0], rgb[i - 1][2]); // 해당 줄에서 초록 집을 칠하겠다. 그럼 이전의 빨간 + 현재 초록, 이전의 파랑 + 현재초록 중 작은 값을 선택
            rgb[i][2] += Math.min(rgb[i - 1][0], rgb[i - 1][1]); // 이전의 빨강 + 현재의 파랑, 이전의 초록 + 현재의 파랑
        }

        System.out.println(Math.min(Math.min(rgb[N-1][0], rgb[N-1][1]), rgb[N-1][2])); // 마지막 줄에서 가장 최소값을 출력
    }
}
