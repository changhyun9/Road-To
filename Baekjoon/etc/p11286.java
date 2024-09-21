package etc;

import java.util.PriorityQueue;
import java.util.Scanner;

public class p11286 {
    /**
     * 나의 구현방법
     * 처음엔 단순하게 List를 생성해서 해결하려고 했는데, 문제 알고리즘 분류를 보니 우선순위 큐를
     * 사용해서 문제를 푸는 것이었음. 그래서 우선순위 큐로 방향을 잡고, 문제 분석을 해보니
     * 클래스를 만들어서 original value랑 absolute value를 저장함.
     * 또한, Comparable 인터페이스를 상속받아. 절대값으로 값을 비교하여 오름차순 정렬을 진행한다.
     * 이떄, 절대값이 같으면 original 값으로 정렬을 진행한다. 이후 우선순위 큐를 만들어서 문제의
     * 조건대로 구현해주면 끝.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if (queue.isEmpty()) {
                    System.out.println("0");
                } else {
                    Pair poll = queue.poll();
                    System.out.println(poll.origin);
                }
            } else {
                queue.offer(new Pair(num, Math.abs(num)));
            }
        }

    }
}

class Pair implements Comparable<Pair> {
    int origin;
    int abs;

    public Pair(int origin, int abs) {
        this.origin = origin;
        this.abs = abs;
    }


    public int compareTo(Pair obj) {
        if (obj.abs != this.abs) {
            return this.abs - obj.abs;
        } else {
            return this.origin - obj.origin;
        }
    }

}