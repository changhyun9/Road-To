package Section7;

import java.io.*;
import java.util.*;

public class prob4 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        arr = new int[n+1];
        DFS(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static int DFS(int L) {
        if(arr[L] != 0) return arr[L];
        if(L==1) return arr[L] =1;
        if(L==2) return arr[L] =1;
        else {
            return arr[L] = DFS(L - 1) + DFS(L - 2);
        }
    }

}
