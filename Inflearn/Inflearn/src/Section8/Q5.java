package Section8;

import java.util.Scanner;

public class Q5 {
    /**
     * 나의 구현방법
     * Q4에서 풀었던 방법과 마찬가지로 3개 이상의 가지로
     * 뻗게 되면 반복문을 수행한다.
     * 계속해서 count, 즉 동전의 개수와 반환되는 돈의 금액을 누적시키면서
     * DFS를 수행한다. 이때 answer보다 count가 커지면 최소 반환 개수를
     * 구하는 문제이기 때문에 의미가 없어지므로 return하고, 총 금액보다 반환되는
     * 돈의 크기가 커지면 그것도 return한다. 또한, 배열을 정렬해서 큰 값부터
     * 해서 탐색의 범위를 줄여서 시간 초과를 뜨지 않게 했다.
     */
    static int N, price, answer = Integer.MAX_VALUE;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        price = sc.nextInt();

        DFS(0,0);
        System.out.println(answer);
    }

    public static void DFS(int count, int sum) {
        if(sum > price) return;
        if(answer < count) return;
        if (sum == price) {
            answer = Math.min(answer, count);
        } else {
            for (int i = N-1; i >= 0; i--) {
                DFS(count + 1, sum + arr[i]);
            }
        }
    }
}
