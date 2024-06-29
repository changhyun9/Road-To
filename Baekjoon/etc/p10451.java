package etc;

import java.util.Scanner;

public class p10451 {
    /**
     * 처음엔 Queue와 List를 사용하여 확인을 하려고 했는데, 구현방법이 떠오르지 않아
     * 다른 방법인 현재 작성된 코드 방법으로 구현하였다. 우선 숫자 배열과 check 배열을
     * 만들고, 배열의 처음부터 끝까지 모두 확인하여 순열 사이크를 확인한다.
     * 이때, check 배열의 값이 1이면 이미 다른 순열 사이클에 포함된 것이기 때문에 넘어간다.
     * 그래서 check 배열의 값이 0이라면, 해당 배열이 가리키는 다음 배열을 저장하고,
     * 다음 배열이 가리키는 배열을 따라가는 식으로 구현하였다. 이때, 사이클이라는 특징을 이용하여
     * 무조건 사이클을 만들기 위해서는 시작과 끝이 같다는 것이다. 그래서 다음 가리키는 값이 현자 k값이라면
     * 반복문을 종료하고, answer을 하나 증가하는 로직으로 구현하였다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            int[] check = new int[n + 1];

            for (int j = 1; j <= n; j++) {
                int num = sc.nextInt();
                arr[j] = num;
            }

            int answer =0;
            for (int k = 1; k <= n; k++) {
                int value = arr[k];
                while (check[k] != 1) {
                    if (k == value) {
                        answer++;
                        break;
                    }
                    check[value] = 1;
                    value = arr[value];
                }
                check[k] = 1;
            }
            System.out.println(answer);
        }
    }
}
