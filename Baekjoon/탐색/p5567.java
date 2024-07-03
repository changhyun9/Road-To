package 탐색;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p5567 {
    /**
     * 처음엔 a -> b 관계만 체크하여 하였다. 이후 바로 a <-> b로 양방향 관계를
     * 체크해서 값을 구했는데, 이 관계를 체크하는 로직 구현에 많은 시간이 들었다.
     * List를 이용했기 때문에 두개의 List를 만들어 친구가 앞에 있는 경우,
     * 뒤에 있는 경우를 체크하는 로직을 구하였다. 이때, 두 리스트에 중복으로 들어가는
     * 경우가 생겨 중복을 체크하여 넣는 코드를 작성하여 해결하였다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> front_visited = new ArrayList<>();
        List<Integer> back_visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        front_visited.add(1);

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.get(start).add(end);
            if (start == 1) {
                front_visited.add(end);
                queue.offer(end);
            }
            if (end == 1) {
                if (!front_visited.contains(start)) {
                    front_visited.add(start);
                    queue.offer(start);
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            List<Integer> list1 = list.get(i);
            for (Integer num : front_visited) {
                if (list1.contains(num) && !front_visited.contains(i) && !back_visited.contains(i)) {
                    back_visited.add(i);
                }
            }
        }


        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer integer : list.get(poll)) {
                if (!front_visited.contains(integer) && !back_visited.contains(integer)) {
                    front_visited.add(integer);
                }
            }
        }

        int sum = back_visited.size() + front_visited.size();
        System.out.println(sum-1);
    }
}
