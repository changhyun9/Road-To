package DP;

import java.util.Scanner;

public class p1932 {
    /**
     * 나의 구현방법
     * 처음엔 DFS, 즉 완전탐색으로 문제를 접근하려 했지만, 알고리즘 분류에 따르면 DP라고 나와있어서
     * DP로 풀었다. 그 다음 문제를 분석했을 때, 1차원 배열로 DP를 수행하는 방법과 2차원 배열로 수행하는 방법이
     * 떠올랐는데 1차원 배열은 변화하는 Index 접근 방법이 마땅히 떠오르지 않아, 2차원 배열로 진행하였다.
     * 처음엔 Index 접근하는 방식에서 애를 먹었는데, 층 별로 인덱스가 같거나 -1, +1 차이 나는 것을 보고
     * 규칙을 찾은 후 구현을 하였다. 근데 양 끝 값은 쉽게 했는데 가운데은 두개의 길이 있다는 것을 확인하지
     * 못하고 구현하다가 틀렸다. 그래서 top-down으로 구현하던 방식을 bottom-up으로 바꿔서 구현하였다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] tri = new int[N][];

        for (int i = 0; i < N; i++) {
            tri[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                tri[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    tri[i][j] = tri[i][j] + tri[i - 1][j];
                } else if (j == i) {
                    tri[i][j] = tri[i][j] + tri[i - 1][j-1];
                } else {
                    tri[i][j] = Math.max(tri[i][j]+tri[i-1][j-1], tri[i][j]+tri[i-1][j]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i : tri[N - 1]) {
            if (max < i) {
                max = i;
            }
        }
        System.out.println(max);
    }
}
