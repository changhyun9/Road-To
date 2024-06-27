package etc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p2606 {
    /**
     * 처음엔 단방향 그래프로 생각하고 풀어서 틀렸다.
     * 그래서 양방향 arr[front][back] 이외에도, arr[back][front]로 양방향 그래프로 만들어줬다.
     * 해당 행동의 결과로 1번 컴퓨터도 list도 포함되는 문제가 발생했는데, 단순하게 마지막에 -1을 하여
     * 1번 컴퓨터를 무시하는 방향으로 진행하였다. 근데, 1이 안들어가는 경우도 있기에 이런 경우에는
     * 무고한 다른 컴퓨터가 하나 사라지는 것이기 때문에 무조건적으로 list.add(1)을 하고
     * 마지막에 -1을 하는 방향으로 진행하였다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n + 1][n + 1];
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            int front = sc.nextInt();
            int back = sc.nextInt();
            arr[front][back] = 1;
            arr[back][front]= 1;
        }
        list.add(1);
        for (int j = 1; j <= n; j++) {
            if (arr[1][j] == 1 && !list.contains(j)) {
                queue.offer(j);
                list.add(j);
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int k = 1; k <= n; k++) {
                if (arr[poll][k] == 1 && !list.contains(k)) {
                    queue.offer(k);
                    list.add(k);
                }
            }
        }
        System.out.println(list.size()-1);
    }
}
