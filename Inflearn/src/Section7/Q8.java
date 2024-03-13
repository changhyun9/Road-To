package Section7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q8 {
    /**
     * 나의 구현방법
     * Queue를 이용하여 같은 레벨에서 이동할 수 있는 모든 위치를 탐색
     * List를 이용하여 이미 갔던 위치는 탐색하지 않음
     * 또한 경우의 수를 나눠 효율적으로 탐색
     * 목적지 / 현재 위치를 했을 때, 1이상이면 +5 만 진행
     * 목적지 / 현재 위치를 했을 때, 1이면 두 위치간의 사이거리(나머지)를 보고 +1과 +5만 진행
     * 목적직 / 현재 위치를 했을 때, 0이면 두 위치간의 대소를 비교하여 +1 혹은 -1을 진행
     */
    static int[] dis = {1, -1, 5};
    static int[] ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int E = sc.nextInt();
        int answer = BFS(S, E);
        System.out.println(answer);

    }

    /*public static int BFS(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> mem = new ArrayList<>();
        q.offer(start);
        int count = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Integer poll = q.poll();
                mem.add(poll);
                if (poll == end) {
                    return count;
                }
                if (end / poll > 1) {
                    if (!mem.contains(poll + 5)) q.offer(poll + 5);
                } else if (end / poll > 0) {
                    if (end % poll <= 2) {
                        if(!mem.contains(poll +1 )) q.offer(poll+1);
                    }
                    if (!mem.contains(poll + 5)) q.offer(poll + 5);
                } else {
                    if (poll > end) {
                        if (!mem.contains(poll-1)) q.offer(poll - 1);
                    } else {
                        if (!mem.contains(poll+1)) q.offer(poll + 1);
                    }
                }
            }
            count++;
        }
        return count;
    }*/

    public static int BFS(int s, int e) {
        Queue<Integer> Q = new LinkedList<>();
        ch = new int[10001];
        Q.offer(s);
        ch[s] = 1;
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if(x == e) return L;
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return L;
    }
}
