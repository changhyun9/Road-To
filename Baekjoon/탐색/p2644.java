package 탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p2644 {
    /**
     * 인접리스트, 인접그래프 형식으로 문제를 푸는 방법은 생각했다.
     * 하지만, 정확히 답을 구하는 즉, DFS를 떠올리고 구현하는 로직을
     * 생각해내지 못했다. 그래도 간단한 로직 정도는 떠올렸는데 구현을 하지 못함.
     */
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int answer = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();
        int e = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            list.get(x).add(y);
            list.get(y).add(x);
        }

        DFS(s, e, 0);

        System.out.println(answer);

    }

    static void DFS(int s, int e, int cnt) {
        visited[s] = true;

        for(int i : list.get(s)){
            if (!visited[i]) {
                if (i == e) {
                    answer = cnt + 1;
                    return;
                }

                DFS(i, e, cnt + 1);
            }
        }
    }
}
