package DFSandBFS;

import java.io.*;
import java.util.*;

public class p14889 {
    static int n, answer = Integer.MAX_VALUE;
    static int[][] map;
    static int[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        map = new int[n][n];
        ch = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0,0);

        System.out.println(answer);

    }

    static void DFS(int L, int idx) {
        if (L == n / 2) {
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();
            int aSum = 0;
            int bSum = 0;

            for (int i = 0; i < n; i++) {
                if (ch[i] == 1) {
                    aList.add(i);
                } else {
                    bList.add(i);
                }
            }

            for (int i = 0; i < n / 2 - 1; i++) {
                for (int j = i + 1; j < n / 2; j++) {
                    aSum += (map[aList.get(i)][aList.get(j)] + map[aList.get(j)][aList.get(i)]);
                    bSum += (map[bList.get(i)][bList.get(j)] + map[bList.get(j)][bList.get(i)]);
                }
            }

            answer = Math.min(answer, Math.abs(aSum - bSum));

        } else {
            for (int i = idx; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    DFS(L + 1, i);
                    ch[i] = 0;
                }
            }
        }
    }
}
