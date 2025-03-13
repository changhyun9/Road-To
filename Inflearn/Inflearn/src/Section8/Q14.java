package Section8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q14 {
    /**
     * 나의 구현방법
     * BFS 방식 그대로 사용했고, 이전에는 visited 배열을 만들어서
     * 0이었던 것을 찾고, 1로 변경해주었는데 이번에는 그냥 board 정보를
     * 0으로 변경해서 다음번에 재방문 못하게 구현
     */
    static int n;
    static int[][] board;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, 1, -1, 1, 1, -1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        int answer =0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    BFS(i,j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static void BFS(int x, int y) {
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point poll = queue.poll();
                for (int j = 0; j < 8; j++) {
                    int nx = poll.x + dx[j];
                    int ny = poll.y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                        board[nx][ny] = 0;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
