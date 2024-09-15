package 탐색;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1697 {
    /**
     * 나의 구현방법
     * 간단하게 BFS 로직으로 풀이. 근데 처음에 while안 if 조건으로 (arr == 접근안함)을 하지않아
     * 메모리 초과 발생하였음.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[100001];

        Arrays.fill(arr, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(N);
        arr[N] = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll == K) break;
            if (poll - 1 >= 0 && arr[poll-1] == Integer.MAX_VALUE) {
                arr[poll - 1] = arr[poll] + 1;
                queue.offer(poll - 1);
            }
            if (poll + 1 <= 100000 && arr[poll+1] == Integer.MAX_VALUE) {
                arr[poll + 1] = arr[poll] + 1;
                queue.offer(poll + 1);
            }
            if (2 * poll <= 100000 && arr[2*poll] == Integer.MAX_VALUE) {
                arr[2 * poll] =arr[poll] + 1;
                queue.offer(2*poll);
            }
        }

        System.out.println(arr[K]);

    }
}
