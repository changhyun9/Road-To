package Section9;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q8 {
    /**
     * 나의 구현방법
     * 2차원 배열을 통해 간선의 정보를 입력받고, 임의의 정점 '1'에서 프림 알고리즘을 시작하였다.
     * 임의의 정점 '1'에 근접한 노드를 Priority Queue에 넣는다. 이때, Comparable interface를
     * 구현하여 cost를 기준으로 오름차순 정렬이 되도록 구현한다. 이후, MST에 포함되어있지 않은 노드를
     * 만나면, 위의 과정을 반복한다.
     *
     * 강의해설
     * 나와 같은 로직으로 풀었고, 세부 사항에서 달랐음.
     * 나는 2차원 배열, List를 이용하여 프림 알고리즘을 구현
     * 강의는 인접리스트 ->이중리스트, check 배열을 이용하여 프림 알고리즘을 구현
     */

    /**
     * Prim's algorithm 동작방식
     * 1. 임의의 간선에서 출발한다.
     * 2. 간선의 근접한 노드 중 가중치가 작은 간선을 선택한다.
     * 3. 2의 과정을 MST의 요소 크기가 총 정점 노드가 될 때까지 반복한다.
     *  3-1. 이때, 이미 MST에 포함된 정점은 건너뛰고, 다음 최소 가중치를 더한다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int answer = 0;

        int[][] map = new int[v + 1][v + 1];
        List<Integer> mst = new ArrayList<>();
        PriorityQueue<Node> queue = new PriorityQueue<>();


        for (int i = 1; i <= e; i++) {
            int front = sc.nextInt();
            int back = sc.nextInt();
            int cost = sc.nextInt();

            map[front][back] = cost;
            map[back][front] = cost;
        }

        mst.add(1);

        for (int i = 1; i <= v; i++) {
            if(map[1][i] > 0) queue.offer(new Node(i, map[1][i]));
        }

        while (mst.size() != v) {
            Node poll = queue.poll();

            if(!mst.contains(poll.des)){
                mst.add(poll.des);
                answer += poll.cost;
                for (int i = 1; i <= v; i++) {
                    if (map[poll.des][i] > 0 && !mst.contains(i)) {
                        queue.offer(new Node(i, map[poll.des][i]));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}

class Node implements Comparable<Node> {
    int des;
    int cost;

    public Node(int des, int cost) {
        this.des = des;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}