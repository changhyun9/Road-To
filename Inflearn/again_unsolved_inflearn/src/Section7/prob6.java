package Section7;

import java.io.*;
import java.util.*;

public class prob6 {
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n + 1];

        DFS(1);


    }

    public static void DFS(int L) {
        if (L == n+1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (arr[i] == 1) {
                    tmp += (i+ " ");
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }

        } else {
            arr[L] = 1;
            DFS(L+1);
            arr[L] = 0;
            DFS(L+1);
        }
    }
}
