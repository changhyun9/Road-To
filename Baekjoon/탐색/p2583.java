package 탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p2583 {
    /**
     * DFS, 왼쪽하단, 오른쪽 상단 좌표를 받아서, 해당 직사각형에 포함되는
     * 좌표는 모두 1로 초기화하고, DFS를 실행한다. 상하좌우로 DFS를 진행하고,
     * size와 직사각형에 포함되지 않는 영역의 크기를 구한다.
     * 처음에는 x,y 순서를 잘못표기하여 stackoverflow error를 발생시켰고,
     * 그다음에는 출력 결과 형식을 잘못지켜 틀렸다. 사소한 문제를 정확하게 파악하는
     * 습관이 부족함. 문제를 꼼꼼하게 읽고, 파악하는 습관과 검증하는 습관.
     */
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n,m, cnt, size;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> result = new ArrayList<>();

        map = new int[m][n];

        for (int i = 0; i < k; i++) {
            int x0 = sc.nextInt();
            int y0 = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();

            for (int j = x0; j < x1; j++) {
                for (int c = y0; c < y1; c++) {
                    map[c][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    cnt =1;
                    map[i][j] = 1;
                    DFS(new Point(j, i));
                    size++;
                    result.add(cnt);
                }
            }
        }

        Object[] array = result.toArray();
        Arrays.sort(array);
        System.out.println(size);
        for (Object o : array) {
            System.out.print(o +" ");
        }

    }

    static void DFS(Point p) {
        for (int i = 0; i < 4; i++) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[ny][nx] == 0) {
                map[ny][nx] = 1;
                cnt++;
                DFS(new Point(nx, ny));
            }
        }
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
