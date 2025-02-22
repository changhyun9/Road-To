package Section2;

import java.io.*;
import java.util.*;

public class prob4 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] pibo = new int[n];

        pibo[0] = 1;
        pibo[1] = 1;

        for (int i = 2; i < n; i++) {
            pibo[i] = pibo[i - 2] + pibo[i - 1];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(pibo[i] + " ");
        }

    }
}
