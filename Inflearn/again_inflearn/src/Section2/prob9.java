package Section2;

import java.io.*;
import java.util.*;

public class prob9 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
            answer = Math.max(answer, sum);
        }
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += map[j][i];
            }
            answer = Math.max(answer, sum);
        }

        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            left += map[i][i];
            right += map[i][n-i-1];
        }
        answer = Math.max(answer, Math.max(left, right));

        System.out.println(answer);
    }
}
