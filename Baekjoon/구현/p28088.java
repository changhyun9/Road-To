package 구현;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p28088 {
    /**
     * Queue로 응애하는 인덱스를 저장하고, 배열에는 영향을 받는 응애를 저장
     * 이때, 배열 값이 2일 경우에는 0으로 초기화. -> 양옆에서 응애를 하는 경우이기 때문
     * 그리고 응애 인덱스를 통해 영향받는 인덱스를 계산할 때, 언더플로우, 오버플로우 경우의 수 계산
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        int k = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            arr[num] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] == 1) {
                    queue.offer(j);
                    arr[j] = 0;
                }
            }

            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                if (poll - 1 == -1) {
                    arr[n - 1]++;
                    arr[poll + 1]++;
                } else if (poll + 1 == n) {
                    arr[0]++;
                    arr[poll - 1]++;
                } else {
                    arr[poll - 1]++;
                    arr[poll + 1]++;
                }
            }
            for (int j = 0; j < n; j++) {
                if (arr[j] == 2) {
                    arr[j] = 0;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                result++;
            }
        }
        System.out.println(result);
    }
}