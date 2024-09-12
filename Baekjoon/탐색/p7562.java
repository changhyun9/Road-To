package 탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p7562 {
    /**
     * 나의 구현방법
     * 한번에 8개의 방향으로 이동할 수 있고, 미리 dx,dy를 정의해놓고
     * N만큼 로직을 실행한다. 이후, BFS를 실행하면 된다.
     * 일반적인 BFS를 실행하는데, visited 이차원배열에 이전 옮겨온 값에 +1를 하여
     * 값을 저장한다. 해당 값은 처음 좌표로 부터 이동한 횟수이기 때문에
     * 마지막에 목표 좌표에 대한 출력을 한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
        int[][] visited;
        Queue<Coord1> queue;


        for (int i = 0; i < N; i++) {

            int l = sc.nextInt();
            queue = new LinkedList<>();

            visited = new int[l][l];

            int start_x = sc.nextInt();
            int start_y = sc.nextInt();
            Coord1 start = new Coord1(start_x, start_y);
            queue.offer(start);


            int goal_x = sc.nextInt();
            int goal_y = sc.nextInt();
            visited[start_y][start_x] = 0;

            while (!queue.isEmpty()) {
                Coord1 poll = queue.poll();
                if(poll.x == goal_x && poll.y == goal_y) break;
                for (int k = 0; k < 8; k++) {
                    int nx = dx[k] + poll.x;
                    int ny = dy[k] + poll.y;
                    if (nx >= 0 && nx < l && ny >= 0 && ny < l && visited[ny][nx] == 0) {
                        visited[ny][nx] = visited[poll.y][poll.x]+1;
                        queue.offer(new Coord1(nx, ny));
                    }
                }
            }
            System.out.println(visited[goal_y][goal_x]);
        }
    }
}

class Coord1 {
    int x;
    int y;

    public Coord1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}