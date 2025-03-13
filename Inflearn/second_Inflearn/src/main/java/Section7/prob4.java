package Section7;

import java.io.*;
import java.util.*;

public class prob4 {
    static int[] fibo;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        fibo = new int[n+1];
        DFS(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i]+ " ");
        }
    }

    static int DFS(int n) {
        if(fibo[n] > 0) return fibo[n];
        if (n==1) return fibo[n] = 1;
        else if (n==2) return fibo[n] = 1;
        else return fibo[n] = DFS(n-2) + DFS(n-1);
    }
}
