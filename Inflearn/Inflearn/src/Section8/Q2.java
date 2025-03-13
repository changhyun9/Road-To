package Section8;

import java.util.Scanner;

public class Q2 {
    /**
     * 나의 구현방법
     * 부분집합을 구했던 것 처럼 포함을 한다, 안한다로 나눠 DFS를 진행한다.
     * 포함하는 경우에는 sum에 계속해서 값을 더하면서 진행하고
     * 포함하지 않은 경우에는 sum에 아무런 값을 더하지 않고 진행한다.
     * 0부터 시작해서 N까지 도달했을 때 DFS는 멈추고, 현재 저장된 answer보다
     * sum이 크면 answer에 새 값을 저장한다.
     */
    static int C;
    static int[] arr;
    static int N;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0,0);
        System.out.println(answer);
    }

    public static void DFS(int L, int sum) {
        if(sum > C) return;
        if (L == N) {
            if (answer < sum) answer = sum;

        } else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }
}
