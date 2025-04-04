package Section7;

import java.io.*;
import java.util.*;

public class prob4 {
    static int[] mem;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        mem = new int[n+1];

        DFS(n);

        for (int i = 1; i <= n; i++) {
            System.out.print(mem[i] + " ");
        }
    }

    public static int DFS(int n) {
        if(mem[n] != 0) return mem[n];
        if (n == 2 || n==1) {
            return mem[n] = 1;
        } else {
            return mem[n] = DFS(n - 1) + DFS(n - 2);
        }
    }
}
