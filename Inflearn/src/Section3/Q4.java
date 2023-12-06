package Section3;

import java.util.Scanner;

public class Q4 {
    /**
     * 내가 구현한 방법
     * 두개의 포인터를 두고, M보다 값이 작은 경우 back 뒤쪽 포인터를 옮기면서
     * 가리키는 값을 계속해서 더함. 더하다가 M보다 커질 때 front 앞쪽 포인터 가리키는 값을
     * 뺴고 다음 요소를 가리키도록함. 이렇게 반복하다가 M과 같아질 때 앞쪽 포인터가 가리키는 값을 빼고 옮김.
     * 결국 계속 더해야하는데 현재 M과 같기 때문에 앞쪽 포인터가 같은 값이라면, 아무리 뒤쪽 포인터를 옮긴다고해도 의미가 없음.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int front = 0, back = 0;
        int temp =0;
        int answer = 0;
        while (back < N) {
            if (temp < M) {
                temp += arr[back++];
            } else if (temp > M) {
                temp -= arr[front++];
            } else {
                temp -= arr[front++];
                answer++;
            }
        }
        while(temp >= M){
            if (temp == M) {
                answer++;
            }
            temp -= arr[front++];
        }
        System.out.println(answer);
    }
}
