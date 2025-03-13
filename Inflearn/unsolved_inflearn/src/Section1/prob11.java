package Section1;

import java.io.*;
import java.util.*;

public class prob11 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        StringBuilder sb = new StringBuilder();

        char ch = input.charAt(0);
        int cnt = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == ch) {
                cnt++;
            } else {
                sb.append(ch);
                if(cnt != 1) sb.append(cnt);
                ch = input.charAt(i);
                cnt = 1;
            }
        }
        sb.append(ch);
        if(cnt != 1) sb.append(cnt);

        System.out.println(sb);
    }
}
