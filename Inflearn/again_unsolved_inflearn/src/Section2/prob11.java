package Section2;

import java.io.*;
import java.util.*;

public class prob11 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[][] arr = new int[n][5];
        int[] tmp = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        tmp[i]++;
                        tmp[j]++;
                        break;
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (max < tmp[i]) {
                max = tmp[i];
                idx = i;
            }
        }

        System.out.println(idx+1);

    }
}
