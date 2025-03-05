package Section8;

import java.io.*;
import java.util.*;

public class prob7 {
    static int n, r;
    static int[][] mem;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        mem = new int[n+1][r+1];

        DFS(n, r);

        System.out.println(mem[n][r]);

    }

    static int DFS(int n, int r) {
        if(mem[n][r] > 0) return mem[n][r];
        if (n == r || r==0) {
            return mem[n][r] = 1;
        }
        else if (r == 1 || n-r == 1) {
            return mem[n][r] = n;
        } else {
            return mem[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }
}
