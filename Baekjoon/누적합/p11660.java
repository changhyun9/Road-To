package 누적합;

import java.util.Scanner;

public class p11660 {
    /**
     * 나의 구현방법
     * 문제 접근이 단단히 잘못되어서 틀렸다. 문제를 잘못읽고 접근하다가 다른 사람 풀이를 봄
     *
     * 해결방법
     * 각 행별로 누적합을 구한다. 이후, 두개의 좌표가 주어지면, 행 차이만큼 반복문을 수행하고
     * 각 행 별로 누적합을 구했기 때문에 y2열에서 y1 열을 뺀다.
     * 각 행마다 뺀 열 값들을 모두 더하여 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] dp = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int num = sc.nextInt();
                dp[i][j] = dp[i][j-1] + num;
            }
        }

        for (int i = 0; i < M; i++) {
            int sum =0;
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for (int k = x1; k <= x2; k++) {
                sum = sum + (dp[k][y2] - dp[k][y1 - 1]);
            }
            System.out.println(sum);
        }

    }
}
