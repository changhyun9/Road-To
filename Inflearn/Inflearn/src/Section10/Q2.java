package Section10;

import java.util.Scanner;

public class Q2 {
    /**
     * 나의 구현방법
     * Section10_1번 문제와 동일
     * 앞 문제와 차이점은 돌의 개수이기 때문에 온전히 건너는 경우는 돌 개수 +1 일때 이다.
     * 그래서 배열의 개수를 하나 더 증가시켜서 값을 구해야 한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 2];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n + 1; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }

        System.out.println(arr[n+1]);
    }
}
