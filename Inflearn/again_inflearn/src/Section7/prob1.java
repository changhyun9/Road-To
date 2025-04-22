package Section7;

import java.io.*;
import java.util.*;

public class prob1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        DFS(n);
    }

    static void DFS(int L) {
        if (L == 0) {
            return;
        } else {
            DFS(L - 1);
            System.out.print(L+ " ");
        }
    }
}
