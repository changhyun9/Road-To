package Section7;

import java.io.*;
import java.util.*;

public class prob3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int answer = DFS(n);
        System.out.println(answer);
    }

    static int DFS(int L) {
        if (L == 1) {
            return 1;
        } else {
            return L * DFS(L - 1);
        }
    }
}
