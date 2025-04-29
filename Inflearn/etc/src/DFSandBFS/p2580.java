package DFSandBFS;

import java.io.*;
import java.util.*;
public class p2580 {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0);
    }

    static void DFS(int row, int col) {
        if (col == 9) { // 한 줄 다봤는데 빈칸이 없으면 다음 줄 탐색
            DFS(row + 1, 0);
            return;
        }
        if (row == 9) { // 모든 줄 탐색이 끝났으면 스도쿠 맵 출력
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

            System.exit(0);
        }

        if (map[row][col] == 0) { // 빈칸있으면 들어갈 수 있는 숫자 탐색
            for (int i = 1; i <= 9; i++) {
                if (check(row, col, i)) {
                    map[row][col] = i;
                    DFS(row, col + 1);
                }
            }
            map[row][col] = 0;
            return;
        }
        DFS(row, col + 1);
    }

    static boolean check(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (map[i][col] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (map[row][i] == value) {
                return false;
            }
        }

        int rowLocation = (row / 3) * 3;
        int colLocation = (col / 3) * 3;
        for (int i = rowLocation; i < rowLocation + 3; i++) {
            for (int j = colLocation; j < colLocation + 3; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
