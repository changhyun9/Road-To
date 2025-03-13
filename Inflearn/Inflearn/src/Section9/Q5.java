package Section9;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q5 {
    /**
     * 나의 구현방법 2차원 배열을 통해 그래프 정보를 저장하고, 이전 노드에서의 가중치 즉, answer에서의 값을 과 현재 노드까지의 거리를 더해서 값을 구함. 그 중 최소 값을 answer에 저장.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n + 1][n + 1];
        int[] answer = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int f = sc.nextInt();
            arr[s][e] = f;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] > 0) {
                    if (i == 1) {
                        answer[j] = arr[i][j];
                    } else {
                        if (answer[i] != 0) {
                            if (answer[j] == 0)
                                answer[j] = answer[i] + arr[i][j];
                            else
                                answer[j] = Math.min(answer[j], answer[i] + arr[i][j]);
                        }
                    }

                }
            }
        }

        for (int i = 2; i < answer.length; i++) {
            if (answer[i] == 0) {
                System.out.println(i + " : impossible");
            } else {
                System.out.println(i + " : " + answer[i]);
            }
        }
    }
}

    /**
     * 강의해설
     * 저장된 배열의 최소값을 찾아 n*n을 n*logn으로 변경
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] answer = new int[n + 1];
        ArrayList<ArrayList<Edge>> list = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Edge>());
        }
        Arrays.fill(answer, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int c = sc.nextInt();
            list.get(s).add(new Edge(e, c));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        answer[1] = 0;
        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            int vex = poll.vex;
            int cost = poll.cost;
            if (cost > answer[vex]) {
                continue;
            }
            for (Edge ob : list.get(vex)) {
                if (answer[ob.vex] > cost + ob.cost) {
                    answer[ob.vex] = cost + ob.cost;
                    pq.offer(new Edge(ob.vex, ob.cost));
                }
            }
        }

        for (int i = 2; i < answer.length; i++) {
            if (answer[i] == 0) {
                System.out.println(i + " : impossible");
            } else {
                System.out.println( i + " : " + answer[i]);
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int vex;
    int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}*/