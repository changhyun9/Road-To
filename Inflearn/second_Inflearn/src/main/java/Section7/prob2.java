package Section7;

import java.io.*;
import java.util.*;

public class prob2 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bf.readLine());
        DFS(input);

    }

    public static void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            DFS(n / 2);
            System.out.print(n % 2);
        }
    }
}
