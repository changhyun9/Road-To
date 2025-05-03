package DFSandBFS;

import java.io.*;
import java.util.*;

public class p1780 {
    static int zero=0, minus=0, one = 0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }

    static void partition(int row, int col, int size){
        if (check(row, col, size)) {
            int num = map[row][col];
            if (num == 0) {
                zero++;
            }
            if (num == -1) {
                minus++;
            }
            if (num == 1) {
                one++;
            }
            return;
        }

        int newSize = size / 3;
        for (int i = row; i < row + size; i += newSize) {
            for (int j = col; j < col + size; j += newSize) {
                partition(i, j, newSize);
            }
        }
    }

    static boolean check (int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[row][col] != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


}
