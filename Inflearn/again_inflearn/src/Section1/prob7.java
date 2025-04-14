package Section1;

import java.io.*;
import java.util.*;

public class prob7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        input = input.toLowerCase();
        StringBuilder sb = new StringBuilder(input).reverse();

        if (input.equals(sb.toString())) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
