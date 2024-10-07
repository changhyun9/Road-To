package etc;

import java.util.Scanner;

public class p2447 {
    /**
     * 나의 구현방법 -> 아이디어는 생각해냈으나 구현방법에서 막힘
     * System.out.print로 출력하면 시간 초과 발생.
     */

    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr = new char[N][N];

        recur(0, 0, N, false);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void recur(int x, int y, int N, boolean blank) {

        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (N == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = N / 3;
        int count = 0;
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;
                if (count == 5) {
                    recur(i, j, size, true);
                } else {
                    recur(i, j, size, false);
                }
            }
        }
    }
}
