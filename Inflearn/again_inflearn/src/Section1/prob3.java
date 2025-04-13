package Section1;

import java.io.*;
import java.util.*;

public class prob3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String[] split = input.split(" ");

        int max = split[0].length();
        int idx = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() > max) {
                max = split[i].length();
                idx = i;
            }
        }

        System.out.println(split[idx]);
    }
}
