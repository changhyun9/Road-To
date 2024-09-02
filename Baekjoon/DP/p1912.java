package DP;

import java.util.Scanner;

public class p1912 {
    /**
     * 나의 구현방법
     * 최대의 합이라고 해서, 처음엔 LIS 증가 부분수열을 떠올랐는데
     * '연속적인'에 초점을 맞춰 이전까지 더한 값이 음수만 아니면
     * 모두 증가하는데 기여한다고 생각했다. 그래서 N의 크기의 배열을
     * 생성하여 순서대로 더하면서 로직을 진행하였고, 해당 데이터 이전의 값이
     * 음수 인 경우에는 더하는 게 아니라 해당 데이터 값으로 대치해서
     * 해당 데이터 값부터 다시 연속적인 합을 구하는 식의 로직을 작성하였다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] dy = new int[N];

        for (int i = 0; i < N; i++) {
            int nextInt = sc.nextInt();
            arr[i] = nextInt;
        }
        dy[0] = arr[0];
        int max = dy[0];

        for (int i = 1; i < N; i++) {
            if (dy[i - 1] < 0) {
                dy[i] = arr[i];
            } else {
                dy[i] = dy[i-1] + arr[i];
            }
            max = Math.max(max, dy[i]);
        }

        System.out.println(max);
    }
}
