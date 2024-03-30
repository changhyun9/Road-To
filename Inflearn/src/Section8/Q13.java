package Section8;

import java.util.Scanner;

public class Q13 {
    /**
     * 나의 구현방법
     * board에 지도에 관한 정보를 저장하고, visited에 탐색을 했는지에 관한 정보를 저장한다.
     * 만약, board[i][j] ==1이고, visited[i][j] ==0인 경우에만 DFS를 접근하고
     * DFS 안에서는 상하좌우 + 대각선하여 총 8가지의 방향을 접근하여 방문하지 않은 섬을 탐색한다.
     * 그렇게 한번의 DFS 재귀가 끝나면 answer을 증가시키고, 총 n X n 이중 반복문을 수행한다.
     *
     * 강의 해설에서는 내가만든 visited 2차원 배열을 만들지 않고, 그냥 board에서 방문한 곳을
     * 0으로 만들고, 다음 번에 방문을 하지 못하게 만듦. 만약 n의 크기가 이것보다 더 크게 주어졌다면
     * 공간복잡도 부분에서 틀렸을수도 있을 것같음. 이것도 참고해서 코테문제 풀기
     */
    static int n;
    static int[][] board, visited;
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, 1, -1, 1, 1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        visited = new int[n][n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && visited[i][j] == 0) {
                    DFS(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);


    }

    public static void DFS(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1 && visited[nx][ny] == 0) {
                visited[nx][ny] = 1;
                DFS(nx, ny);
            }
        }
    }
}




