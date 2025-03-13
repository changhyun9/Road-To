package Section7;

import java.io.*;
import java.util.*;

public class prob1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        recur(n);
    }

    public static void recur(int n) {
        if (n == 0) return;
        else {
            recur(n - 1);
            System.out.print(n+ " ");
        }
    }
}
