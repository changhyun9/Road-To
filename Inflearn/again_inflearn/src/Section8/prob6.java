package Section8;

import java.io.*;
import java.util.*;

public class prob6 {
    static int n, m;
    static int[] arr, ch, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ch = new int[n];
        tmp = new int[m];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);
    }

    static void DFS(int L) {
        if (L == m) {
            for (int num : tmp) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    tmp[L] = arr[i];
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }

    }

}
