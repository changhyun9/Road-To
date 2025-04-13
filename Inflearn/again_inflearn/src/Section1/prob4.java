package Section1;

import java.io.*;
import java.util.*;

public class prob4 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            String input = bf.readLine();
            for (int j = input.length()-1; j >= 0; j--) {
                System.out.print(input.charAt(j));
            }
            System.out.println();
        }
    }
}
