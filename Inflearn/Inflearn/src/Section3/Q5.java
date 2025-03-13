package Section3;

import java.util.Scanner;

public class Q5 {
    /**
     * 내가 구현한 방법
     * Q4. 연속 부분수열 과 똑같은 로직으로 접근하였다
     * 하지만, 연속된 자연수의 합이므로 탐색 범위를 반 +1 로 줄였다
     * Q4와 마찬가지로 N보다 작을 경우 back 뒤쪽 포인터를 옮기며 값을 더해주고
     * N보다 클 경우에는 front 앞쪽 포인터를 옮기며 값을 빼준다.
     * 마지막으로 뒤쪽 포인터가 범위를 넘어갔을 때 N보다 크거나 같은 경우에
     * front 앞쪽 포인터만 옮기며 값을 빼면서 예외 케이스를 탐색한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int temp =0;
        int answer =0;
        int front = 1, back = 1;
        while (back <= (N / 2 + 1)) {
            if (temp < N) {
                temp += back++;
            } else if (temp > N) {
                temp -= front++;
            } else {
                temp -= front++;
                answer++;
            }
        }
        while (temp >= N) {
            if (temp == N) {
                answer++;
            }
            temp -= front++;
        }
        System.out.println(answer);
    }

    /**
     * two pointer가 아닌 수학적 논리 사용
     * 연속된 자연수의 합이기 때문에 자리수를 하나씩 늘려가면서
     * 자리수에 해당하는 값을 미리 빼놓고, 남은 수가 자리수에 맞게 동등하게
     * 분배가 되는지 확인, 분배가 된다면 (남은수 % 자리수 ==0) 결과값 증가
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt =1;
        int answer =0;
        N--;
        while (N > 0) {
            cnt++;
            N = N - cnt;
            if (N % cnt == 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }*/
}
