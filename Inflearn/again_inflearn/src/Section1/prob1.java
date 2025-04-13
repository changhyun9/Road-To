package Section1;

import java.io.*;
import java.util.*;

public class prob1 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        char target = bf.readLine().toLowerCase().charAt(0);
        int answer=0;

        input = input.toLowerCase();
        for (char ch : input.toCharArray()) {
            if(ch == target) answer++;
        }

        System.out.println(answer);

    }
}
