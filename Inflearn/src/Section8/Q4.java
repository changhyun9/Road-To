package Section8;

import java.util.Scanner;

public class Q4 {
    /**
     * 나의 구현방법
     * 레벨에 대해 재귀를 돈다.
     * L=0 일때, 1~N까지 돌고,
     * L=1 일때, 1~N까지 돌고,
     * L=M 일때, 출력 배열에 저장된 값을 출력한다.
     */
    static int N;
    static int M;
    static int[] K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = new int[M];
        DFS(0);
    }

    public static void DFS(int L) {
        if (L == M) {
            for (int i : K) {
                System.out.print(i+ " ");
            }
            System.out.println();
            return;
        } else {
            for (int j = 1; j <= N; j++) {
                K[L] = j;
                DFS(L+1);
            }
        }
    }
}
