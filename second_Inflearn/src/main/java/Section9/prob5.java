package Section9;

import java.io.*;
import java.util.*;

public class prob5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[s][e] = c;
        }


        for (int i = 1; i <= n; i++) {
            if (arr[1][i] > 0) {
                int cost = arr[1][i];
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] > 0) {
                        if (arr[1][j] == 0) {
                            arr[1][j] = cost + arr[i][j];
                        } else {
                            arr[1][j] = Math.min(arr[1][j], cost + arr[i][j]);
                        }

                    }
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (arr[1][i] == 0) {
                System.out.println("impossible");
            } else {
                System.out.println(arr[1][i]);
            }
        }
    }
}

