package Section8;

import java.util.Scanner;

public class Q3 {
    /**
     * 나의 구현방법
     * 시험 점수와, 풀이 시간을 가진 Sub이라는 클래스를 정의하고
     * 부분집합 문제를 풀때와 마찬가지로 포함한다, 포함하지 않는다로 DFS를 진행한다.
     * 이번엔 DFS인자로 시험 점수와, 소요시간의 합을 같이 넘기고
     * 만약 소요시간의 누적합이 M보다 크면 의미가 없으므로 return한다.
     * 말단노드 까지 갔을 때 answer에는 점수의 누적합을 현재 answer와 비교하여
     * 더 큰 값을 저장한다.
     */
    static int N;
    static int M;
    static int answer = 0;
    static Sub[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new Sub[N];

        for (int i = 0; i < N; i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();
            arr[i] = new Sub(score, time);
        }

        DFS(0, 0, 0);
        System.out.println(answer);
    }

    public static void DFS(int L, int score_sum, int time_sum) {
        if(time_sum > M) return;
        if (L == N) {
            answer = Math.max(answer, score_sum);
        } else {
            DFS(L + 1, score_sum + arr[L].score, time_sum + arr[L].time);
            DFS(L + 1, score_sum, time_sum);
        }
    }
}

class Sub{
    int score;
    int time;

    public Sub(int score, int time) {
        this.score = score;
        this.time = time;
    }
}
