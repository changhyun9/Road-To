package Section2;

import java.io.*;
import java.util.*;

public class prob9 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] map = new int[n][n];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            int row =0;
            int col = 0;
            for (int j = 0; j < n; j++) {
                row += map[i][j];
                col += map[j][i];
            }
            max = Math.max(max, Math.max(row, col));
        }

        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j) left += map[i][j];
                if(i+j ==n) right = map[i][j];
            }
        }

        // 강의 해설 로직은 같은데, 왼쪽 대각선, 오른쪽 대각선을 접근하는 방법이 다름.

        for (int i = 0; i < n; i++) {
            left += map[i][i];
            right += map[i][n - i - 1];
        }
        max = Math.max(max, Math.max(left, right));
        System.out.println(max);
    }
}
