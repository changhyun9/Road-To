package Section8;

import java.util.Scanner;

public class Q10 {
    /**
     * 나의 구현방법
     * 미로를 세팅하고, 갈 수 있는 방향을 배열로 설정한 뒤 반복문을 통해 접근한다.
     * 재귀의 종료조건은 좌표가 7,7이 되면 answer를 증가시킨다.
     * 그렇지 않으면 미리 설정해둔 좌표배열을 통해 갈 수 있는 가지를 설정하고
     * 좌표 범위가 유효하거나 방문을 하지 않거나, 벽이 아닌 곳을 좌표가 가리키면
     * 해당 가지로 DFS를 접근한다. 그리고 해당 좌표를 방문했다고 표시하고
     * 해당 DFS가 끝나면 다음 가지에서의 방문을 위해 다시 미방문으로 변경한다.
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
        DFS(1, 1);
        System.out.println(answer);
    }

    public static void DFS(int x, int y) {
        if (x == size - 1 && y == size - 1) {
            answer++;
        } else {
            for (int i = 0; i < dx.length; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx < size && nx > 0 && ny <size && ny > 0 && visited[ny][nx] == 0) {
                    visited[y][x] = 1;
                    DFS(nx, ny);
                    visited[y][x] = 0;
                }
            }
        }
    }
}
