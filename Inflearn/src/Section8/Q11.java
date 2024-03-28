package Section8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q11 {
    /**
     * 나의 구현방법
     * 기본적인 BFS 방법인 Queue를 사용하여 구현한다.
     * 방향 배열을 통해서 4방향을 모두 검토하고, 조건에 맞는
     * 좌표값만 Queue에 삽입한다. 이때, 방문한 좌표에는 1로 변경하여
     * 재방문을 못하도록 한다. 여기서는 방문한 곳을 다시 미방문으로 변경할
     * 필요가 없다. 어차피 넓이 우선 탐색이기 때문이다. 해당 좌표로 다시 돌아올 일이
     * 없기 때문이다. 그리고 다음 이동할 좌표가 목표값이면 이동했던 횟수를 반환하고
     * Queue가 빌때 까지 목표값에 도달하지 못하면 -1을 반환한다.
     */
    static int size = 8;
    static int[][] arr, visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[size][size];
        visited = new int[size][size];
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                arr[i][j] = sc.nextInt();
                visited[i][j] = arr[i][j];
            }
        }
        int bfs = BFS(new Point(1, 1));
        System.out.println(bfs);
    }

    public static int BFS(Point pt) {
        Queue<Point> q = new LinkedList<>();
        q.offer(pt);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point poll = q.poll();
                for (int j = 0; j < dx.length; j++) {
                    int nx = dx[j] + poll.x;
                    int ny = dy[j] + poll.y;
                    if (nx < size && nx > 0 && ny <size && ny > 0 && visited[ny][nx] == 0) {
                        visited[poll.y][poll.x] = 1;
                        q.offer(new Point(nx, ny));
                    }
                    if(nx == size-1 && ny == size-1){
                        return ++answer;
                    }

                }
            }
            answer++;

        }
        return -1;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}



