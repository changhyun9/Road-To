package 탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p1260 {
    /**
     * 그동안 풀었던 문제를 합쳐놓은 복합적인 문제였다.
     * 간단하게 list로 양방향 관계를 받아서 표현하였고,
     * 같은 정점에서 연결되는 것은 더 작은 정점부터 이동하라고
     * 하였기 때문에 정렬을 하여서 구현을 하였다. 이후, DFS와
     * BFS는 최근에 풀었던 문제에서 다뤄봤기 때문에 간단하게
     * DFS는 재귀, BFS는 while문을 통해서 해결할 수 있었다.
     */

    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> visited = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int j = 0; j < m; j++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int k = 0; k <= n; k++) {
            Collections.sort(list.get(k));
        }

        DFS(v);

        visited.clear();
        System.out.println();

        BFS(v);
    }


    static void DFS(int index) {
        visited.add(index);
        System.out.print(index + " ");
        for (Integer next : list.get(index)) {
            if (!visited.contains(next)) {
                DFS(next);
            }
        }
    }

    static void BFS(int index) {
        visited.add(index);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.print(poll + " ");
            for (Integer next : list.get(poll)) {
                if (!visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
    }
}
