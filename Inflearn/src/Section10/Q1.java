package Section10;

import java.util.Scanner;

public class Q1 {
    /**
     * 나의 구현방법 못품
     * 강의해설
     * 계단 1까지 가는 방법 ->1
     * 계단 2까지 가는 방법 -> 2
     * 그럼 계단 3까지 가는 방법은 1,2에서 오는 방법이 있다.
     * 그렇기에 1까지 오는 방법 1과 2까지 오는 방법 2를 더하면
     * 계단 3까지 오는 가지 수를 구할 수 있다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
        int[] dy = new int[n + 1];

        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i-2] + dy[i-1];
        }

        System.out.println(dy[n]);
    }
}
