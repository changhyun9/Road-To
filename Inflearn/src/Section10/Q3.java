package Section10;

import java.util.Scanner;

public class Q3 {
    /**
     * 나의 구현방법
     * 첫번째 요소부터 n까지 순차적으로 증가하면서 최대 증가 수열을 구현하였다.
     * 다양한 증가 부분 수열이 있을 수 있기에 이중 for문을 통해 처음부터
     * 해당 요소까지 최대 부분 증가 수열을 구했다. 해당 요소보다 값이 작고, 현재까지
     * 구한 최대 부분 증가 수 보다 큰 경우에만 + 1를 해주었다.
     *
     * 강의해설
     * 나와 로직이 같음. 다만, 최대 값을 구할 때 나는 for문
     * 강의에서는 Math.max()를 이용함.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            arr[i] = data;
        }


        value[0] = 1;

        for (int i = 1; i < n; i++) {
            int max = value[0];
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && max <= value[j]) max = value[j]+1;
            }
            value[i] = max;
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (value[i] > answer) {
                answer = value[i];
            }
        }

        System.out.println(answer);
    }
}
