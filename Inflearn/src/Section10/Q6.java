package Section10;

import java.util.Scanner;

public class Q6 {
    /**
     * 나의 구현방법 -> 소요시간과 획득점수를 가지고 있는 Problem 객체를 만들어 배열로 생성.
     * 정렬을 진행한 뒤, 문제를 한번만 풀어 점수를 획득하는 범위인 (소요시간 * 2 - 1)를 하여
     * 해당 범위까지 진행. dy[j - time] + score를 하여 점수획득 배열에 저장. -> 시간 초과 발생
     *
     * 강의해설 -> 시간과 점수를 받으면 최대 시간부터 역순으로 접근. 점수를 획득한 문제는 중복으로
     * 값이 들어가면 안되기 때문에. 최대 시간 부터 해당 문제 소요시간까지 오면서 최대값을 바꿈.
     * 즉, 나와 차이점은 나는 앞에서 부터 시작하였고, 범위를 (소요시간 * 2 - 1)까지 설정하였고,
     * 강의에서는 M부터 해당 소요시간까지 역순으로 오면서 문제를 풀었다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] dy = new int[M + 1];

        for (int i = 0; i < N; i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();
            for (int j = M; j >= time; j--) {
                dy[j] = Math.max(dy[j], dy[j - time] + score);
            }
        }
        
        System.out.println(dy[M]);
    }
}