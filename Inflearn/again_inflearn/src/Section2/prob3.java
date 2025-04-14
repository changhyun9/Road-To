package Section2;

import java.io.*;
import java.util.*;

public class prob3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[][] arr = new int[2][n];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[0][i] == 1) {
                if (arr[1][i] == 1)  System.out.println("D");
                else if (arr[1][i] == 2) System.out.println("B");
                else System.out.println("A");
            } else if (arr[0][i] == 2) {
                if (arr[1][i] == 1) System.out.println("A");
                else if (arr[1][i] == 2) System.out.println("D");
                else System.out.println("B");
            } else {
                if (arr[1][i] == 1)  System.out.println("B");
                else if (arr[1][i] == 2) System.out.println("A");
                else System.out.println("D");
            }
        }
    }
}
