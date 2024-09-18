package etc;

import java.util.Scanner;

public class p1389 {
    static final int INF = 987654321;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N + 1][N + 1]; // 플로이드-워셜 알고리즘을 사용하기 위해 이차원배열 생성

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = INF; // 나머지 값들은 초기값으로 INF로 초기화

                if (i == j) {
                    arr[i][j] = 0; // 자기 자신은 0으로 초기화
                }
            }
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x][y] = arr[y][x] = 1; // 입력받은 친구 관계를 양방향으로 설정
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    // 최단경로 초기화
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int res = INF;
        int idx = -1;

        for (int i = 1; i <= N; i++) { // 최소값을 찾는 반복문
            int total = 0;
            for (int j = 1; j <= N; j++) {
                total += arr[i][j];
            }

            if (res > total) {
                res = total;
                idx = i;
            }
        }

        System.out.println(idx);
    }
}
