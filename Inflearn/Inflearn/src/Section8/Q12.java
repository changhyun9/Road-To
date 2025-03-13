package Section8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q12 {
    /**
     * 나의 구현방법
     * Board 배열을 생성하여, 값을 넣으면서 1인 경우에는 Queue에 삽입 -> 첫날에 익은 토마토를 찾기위해
     * 0인 경우에는 visited 값을 ++1 증가 시켜준다 -> 익지 않은 토마토의 개수를 찾기위해
     * 그리고 BFS(0)부터 시작한다 -> 0인 이유는 첫날은 0으로 취급하기 때문에
     * Queue에 있는 요소 개수만큼 반복문을 돌고, 해당 좌표를 기준으로 상하좌우를 보면서 0인 경우에만 Queue에 넣는다
     * 해당 조건을 만족하는 경우가 있으면 Queue에 해당 좌표를 넣고, visited 값을 --1 진행한다.
     * 해당 레벨에 해당하는 요소롤 모두 탐색했다면 레벨을 ++1진행하여 다음 BFS 탐색
     * 모든 BFS가 끝나고 visited 값을 본다. 만약 visited ==0 이면 모든 토마토가 익었다는 뜻이고
     * 그렇지 않으면 모든 탐색에도 불구하고 토마토가 모두 익지 않는다는 뜻이니까 -1을 리턴한다.
     */
    static int[][] board;
    static int n,m, visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
                if(board[i][j] == 0) visited++;
            }
        }
        int bfs = BFS(0);
        if (visited == 0) {
            System.out.println(bfs-1);
        } else {
            System.out.println(-1);
        }
    }

    public static int BFS(int d) {
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point poll = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = poll.x + dx[j];
                    int ny = poll.y + dy[j];
                    if (nx < m && nx >= 0 && ny < n && ny >= 0 && board[nx][ny] == 0) {
                        queue.offer(new Point(nx, ny));
                        board[nx][ny] =1;
                        visited--;
                    }
                }

            }
            ++d;
        }
        return d;
    }
}
