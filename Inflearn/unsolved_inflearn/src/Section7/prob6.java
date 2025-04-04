package Section7;

import java.io.*;
import java.util.*;

public class prob6 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        arr = new int[n];

        DFS(0);
    }

    public static void DFS(int L) {
        if (L == n) {
            String tmp = "";
            for (int i = 0; i < n; i++) {
                if(arr[i] == 1) tmp+=(i+1) + " ";
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
        } else {
            arr[L] = 1;
            DFS(L + 1);
            arr[L] = 0;
            DFS(L + 1);
        }
    }
}
