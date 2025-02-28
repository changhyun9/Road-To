package Section7;

import java.io.*;
import java.util.*;

public class prob3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bf.readLine());
        System.out.println(DFS(input));
    }

    static int DFS(int n) {
        if(n == 1) return 1;
        else {
            return n * DFS(n - 1);
        }
    }
}
