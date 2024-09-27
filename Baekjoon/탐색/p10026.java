package 탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p10026 {
    /**
     * 나의 구현방법
     * 단순하게 BFS로 문제를 풀었을 때, 정상 구역을 나누는 것에 대해서는 문제가 없었음.
     * 근데 R과 G를 하나로 묶어야 했을 때, 어떠한 방법을 생각해내지 못함. 그래서 검색을 통해서
     * 해답을 얻었음. 모든 map을 돌면서 기존 G였던 값을 R로 바꾼다음에 다시 모든 값들을 초기화 후
     * BFS를 도는 방법이다. 시간초과가 날줄 알았지만, 나지 않았다.
     */
    static int N;
    static char[][] map;
    static int[][] visited;
    static Queue<Coord5> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        visited = new int[N][N];
        int cnt=0;

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'R' && visited[i][j] == 0) {
                    queue.offer(new Coord5(i, j));
                    visited[i][j] = 1;
                    BFS('R');
                    cnt++;
                }
                if (map[i][j] == 'G' && visited[i][j] == 0) {
                    queue.offer(new Coord5(i, j));
                    visited[i][j] = 1;
                    BFS('G');
                    cnt++;
                }
                if (map[i][j] == 'B' && visited[i][j] == 0) {
                    queue.offer(new Coord5(i, j));
                    visited[i][j] = 1;
                    BFS('B');
                    cnt++;
                }
            }
        }

        System.out.print(cnt +" ");
        visited = new int[N][N];
        cnt=0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'R' && visited[i][j] == 0) {
                    queue.offer(new Coord5(i, j));
                    visited[i][j] = 1;
                    BFS('R');
                    cnt++;
                }

                if (map[i][j] == 'B' && visited[i][j] == 0) {
                    queue.offer(new Coord5(i, j));
                    visited[i][j] = 1;
                    BFS('B');
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }

    public static void BFS(char ch) {
        while (!queue.isEmpty()) {
            Coord5 poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == ch && visited[nx][ny] == 0) {
                    queue.offer(new Coord5(nx, ny));
                    visited[nx][ny] = 1;
                }
            }
        }
    }
}

class Coord5 {
    int x;
    int y;

    public Coord5(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
