package Section8;

import java.util.Scanner;

public class Q6 {
    /**
     * 나의 구현방법
     * 중복 순열과 마찬가지로 레벨을 기준으로 DFS를 수행하고
     * 3개 이상의 가지로 뻗기 때문에 반복문을 수행한다.
     * 이때, 출력 배열에 중복되는 값이 있으면 안되기 때문에
     * 반복문을 수행할 때 그동안 저장된 값에 현재 값이 있는지 확인한다.
     * 없으면 DFS를 진행하고, 아니면 break로 해당 반복문을 빠져나온다.
     * L == M이 되면 출력 배열에 저장된 값을 모두 출력한다.
     */
    static int N,M;
    static int[] arr, pm, ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        pm = new int[M];
        ch = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0);
    }

    public static void DFS(int L) {
        if (L == M) {
            for (int i : pm) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < N; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }
}
