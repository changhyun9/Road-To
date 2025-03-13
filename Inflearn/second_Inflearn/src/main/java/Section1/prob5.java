package Section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        int lt = 0, rt = input.length() - 1;
        char[] array = input.toCharArray();
        while (lt < rt) {
            if (!Character.isAlphabetic(array[lt])) {
                lt++;
            }
            if (!Character.isAlphabetic(array[rt])) {
                rt--;
            }

            if (Character.isAlphabetic(array[lt]) && Character.isAlphabetic(array[rt])) {
                char ch = array[lt];
                array[lt] = array[rt];
                array[rt] = ch;
                lt++;
                rt--;
            }
        }

        System.out.println(String.valueOf(array));
    }
}
