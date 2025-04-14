package Section1;

import java.io.*;
import java.util.*;

public class prob11 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        char t = input.charAt(0);
        int cnt = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == t) {
                cnt++;
            } else {
                sb.append(t);
                if (cnt != 1) sb.append(cnt);
                t = input.charAt(i);
                cnt = 1;
            }
        }

        sb.append(t);
        if (cnt != 1) sb.append(cnt);

        System.out.println(sb.toString());
    }
}
