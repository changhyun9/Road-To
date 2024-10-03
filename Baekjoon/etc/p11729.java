package etc;

import java.util.Scanner;

public class p11729 {
    /**
     * 나의 구현방법 -> 못풀어서 다른 사람 풀이 참조해서 공부
     * 그리고 처음에 Scanner + System.out.print로 풀었을 때 시간초과 발생
     * StringBuilder 랑 Buffered 시리즈 공부해서 사용해야겠음.
     */
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sb.append((int) (Math.pow(2, N) - 1)).append('\n');

        Hanoi(N, 1, 2, 3);

        System.out.println(sb);
    }


    // start : 시작점
    // mid : 옮기기 위한 중간 지점
    // to : 목적지
    public static void Hanoi(int N, int start, int mid, int to) {
        if (N == 1) {
            sb.append(start + " " + to + "\n");
        } else {
            // N-1개를 start 에서 mid 옮김 -> A에서 B
            Hanoi(N - 1, start, to, mid);
            // 1개 남은 원판을 start 에서 3으로 이동 -> A에서 C
            sb.append(start + " " + to + "\n");
            //N-1개를 mid에서 3으로 이동 -> B에서 C
            Hanoi(N - 1, mid, start, to);
        }

    }
}
