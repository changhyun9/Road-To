package 탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p11725 {
    /**
     * 나의 구현방법
     * 노드간의 정보가 주어지면, 이중리스트로 받아서 저장한다.
     * 이후, 리스트의 1번에 저장되어 있는 값부터 시작한다.
     * 1번이 루트노드라고 했기에, 안에 있는 값은 모두 자식 노드가 된다.
     * DFS를 이용하여 1번에 저장된 값을 순차적으로 들어가서 부모 노드에 저장된
     * 값을 넣는다. 1번 루트노드 -> 안에 있는 값은 무조건 자식 -> DFS로 들어가서
     * 또 그안에 있는 저장된 값들은 무조건 자식 노드
     */
    static int N;
    static List<List<Integer>> list;
    static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        list = new ArrayList<>();
        answer = new int[N + 1];
        answer[1] = 1;

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int j = 1; j < N; j++) {
            int front = sc.nextInt();
            int back = sc.nextInt();

            list.get(front).add(back);
            list.get(back).add(front);
        }

        for (Integer integer : list.get(1)) {
            answer[integer] = 1;
            DFS(integer);
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void DFS(int index) {
        for (Integer integer : list.get(index)) {
            if (answer[integer] == 0) {
                answer[integer] = index;
                DFS(integer);
            }
        }
    }
}
