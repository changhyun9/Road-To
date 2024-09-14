package 탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p2667 {
    /**
     * 나의 구현방법
     * 간단하게 BFS 로직을 이용하여 문제를 풀었다.
     * String으로 숫자를 받은 후, 한자리씩 다시 배열에 저장했다.
     * 간단하게 BFS 로직을 이용하여 가정의 수를 확인하였고, 이를
     * list에 저장했다. list에 저장된 가정의 수를 오름차순으로 정렬하였고
     * 사이즈를 출력하고, 정렬된 값을 하나씩 출력하였다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] map = new int[N][N];
        int[][] visited = new int[N][N];
        Queue<Coord3> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input.charAt(j) + "");
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    int cnt=1;
                    queue.offer(new Coord3(i, j));
                    visited[i][j] = 1;
                    while (!queue.isEmpty()) {
                        Coord3 poll = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = dx[k] + poll.x;
                            int ny = dy[k] + poll.y;
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1 && visited[nx][ny] == 0) {
                                cnt++;
                                queue.offer(new Coord3(nx, ny));
                                visited[nx][ny] = 1;
                            }
                        }
                    }
                    list.add(cnt);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}

class Coord3 {
    int x;
    int y;

    public Coord3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
