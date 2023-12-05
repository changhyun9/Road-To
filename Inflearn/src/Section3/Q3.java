package Section3;

import java.util.Scanner;

public class Q3 {
    /**
     * 내가 구현한 방법
     * N을 K만큼 잘라서 모두 더한 뒤에
     * 최대값을 구하는 로직
     * 해당 로직은 마지막 예제 케이스에서
     * 시간 초과가 뜸.
     * Sliding window는 계속해서 값을 더해서 새로운 값을 만드는 것이 아니라
     * 기존의 값을 이용하는 것. 기존애 0~K 를 더해서 창문을 구성했다면, 창문 바로 다음 값을
     * 더하고, 기존 창문의 첫번째 값을 뺌으로써 창문을 이동시키는 듯한 움직임을 보여준다.
     * 그래서 Sliding window 라고 한다. 그래서 처음에 K만큼 반복문을 돌아 첫번째 창문을
     * 구성한 뒤 반복문을 N만큼 돈다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        int temp = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < K; i++) {
            temp += arr[i];
        }
        int max = temp;
        for (int i = K; i < N; i++) {
            temp -= arr[i - K];
            temp += arr[i];
            max = Math.max(max, temp);
        }
        System.out.println(max);
    }
}
