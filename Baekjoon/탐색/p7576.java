package 탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p7576 {
    /**
     * 나의 구현방법
     * 처음에 단순 BFS로 접근했는데, 처음부터 토마토가 익어있는 경우, 모두 익지 못하는 경우를 생각하고자
     * boolean 형 변수를 두어 케이스 분류를 진행함. 그리고 메서드를 구현하여 BFS로 구현했는데 그럴 필요가 없을 것 아서
     * 메인함수 안에 포함시켜 진행함.
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        Queue<Coord4> queue = new LinkedList();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] map = new int[N][M];
        int[][] visited = new int[N][M];
        boolean comp = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int num = sc.nextInt();
                map[i][j] = num;
                if (num == 1) {
                    queue.offer(new Coord4(i,j));
                    visited[i][j] = 1;
                } else if(num == 0) comp = false;
            }
        }

        while (!queue.isEmpty()) {
            Coord4 poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0 && visited[nx][ny] == 0) {
                    map[nx][ny] = map[poll.x][poll.y] +1;
                    visited[nx][ny] = 1;
                    queue.offer(new Coord4(nx,ny));
                }
            }
        }
        boolean flag = true;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) flag = false;
                else max = Math.max(max, map[i][j]);
            }
        }
        if (comp) {
            System.out.println("0");
        } else {
            if (flag) {
                System.out.println(max-1);
            } else {
                System.out.println("-1");
            }
        }
    }
}

class Coord4 {
    int x;
    int y;

    public Coord4(int x, int y) {
        this.x = x;
        this.y = y;
    }
}