package 탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2178 {
    /**
     * 나의 구현방법
     * 단순히 BFS 문제로 품. 문제 분석 없이 간단하게 품
     * 처음에 String으로 받아서 하나씩 배열에 입력해줌
     * 그리고 BFS 로직 실행. 이때 최소 값을 구하는 것이기 때문에
     * 옮겨온 지점의 값에서 + 1한 것을 저장 -> 이것이 최소를 보장
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] map = new int[N][M];
        int[][] visited = new int[N][M];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Coord2> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input.charAt(j)+"");
            }
        }

        queue.offer(new Coord2(0, 0));
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Coord2 poll = queue.poll();
            if (poll.x == N - 1 && poll.y == M - 1) break;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == 0 && map[nx][ny] == 1) {
                    queue.offer(new Coord2(nx, ny));
                    visited[nx][ny] = visited[poll.x][poll.y] + 1;
                }
            }
        }

        System.out.println(visited[N-1][M-1]);

    }
}

class Coord2 {
    int x;
    int y;

    public Coord2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
