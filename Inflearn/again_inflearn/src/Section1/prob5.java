package Section1;

import java.io.*;
import java.util.*;

public class prob5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        char[] arr = input.toCharArray();
        int lt=0, rt=arr.length-1;
        while (lt < rt) {
            if (Character.isAlphabetic(arr[lt])) {
                while (!Character.isAlphabetic(arr[rt])) {
                    rt--;
                }
                char ch = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = ch;
                rt--;
            }
            lt++;
        }
        for (char c : arr) {
            System.out.print(c);
        }
    }
}
