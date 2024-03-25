package Section8;

import java.util.Scanner;

public class Q7 {
    /**
     * 나의 구현방법
     * nCr = n-1Cr-1 + n-1Cr 공식을 재귀로 구현한다.
     * n==r이거나 r==0이면 1을 리턴하고,
     * 한번 nCr에 대해서 값을 구했을 때 mem[n][r]에 저장을 한다.
     * 이후 mem[n][r]에 대해서 값이 있는지 확인을 하고,
     * 값이 있으면 재귀를 진행하지 않고, 이전 과정에서 구해진 값을 사용한다.
     * 똑같은 과정을 반복하지 않고 ,이전에 구해지는 값을 그대로 사용해서
     * 시간복잡도를 낮추는 것이 메모이제이션이다.
     */
    static int [][] mem;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        mem = new int[n+1][r+1];
        int sum = DFS(n, r);
        System.out.println(sum);

    }
    public static int DFS(int n, int r) {
        if (mem[n][r] > 0) {
            return mem[n][r];
        }
        if(n==r || r == 0) {
            return 1;
        }
        else {
            return mem[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }
}
