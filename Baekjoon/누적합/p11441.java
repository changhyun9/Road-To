package 누적합;

import java.util.Scanner;

public class p11441 {
    /**
     * 해당 구간까지 누적되는 값을 구해서 배열에 저장한다.
     * 이후, 구간의 앞쪽 front와 구간의 뒤쪽 end를 받아서
     * 저장된 배열인 sum을 통해 sum[end] - sum[front-1]를
     * 진행한다. 이때, -1을 하는 이유는 배열이 1부터 시작하기도하고
     * front 값을 포함하기 위해서 이다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            sum[i] = sum[i - 1] + num;
        }

        int m = sc.nextInt();
        for (int j = 0; j < m; j++) {
            int front = sc.nextInt();
            int end = sc.nextInt();
            long temp = sum[end] - sum[front-1];
            System.out.println(temp);
        }
    }
}
