package Section5;

import java.util.LinkedList;
import java.util.Scanner;

public class Q6 {
    /**
     * 내가 구현한 방법
     * 못풀어서, 강의들음.
     * 강의에서 1~K까지는 poll하고 offer로 다시 queue의 뒷부분에
     * 삽입한다. 이후 K번째는 그냥 poll한다. 이 과정을 size가 1일때
     * 까지 반복한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        while (queue.size() != 1) {
            for (int i = 1; i < K; i++) queue.offer(queue.poll());
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
