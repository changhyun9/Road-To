package Section1;

import java.io.*;
import java.util.*;

public class prob10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String input = st.nextToken();
        int len = input.length();
        char t = st.nextToken().charAt(0);
        int[] dy = new int[len];


        int dis = 9999;
        for (int i = 0; i < len; i++) {
            if (input.charAt(i) == t) {
                dis = 0;
            } else {
                dis++;
                dy[i] = dis;
            }
        }

        dis = 9999;
        for (int i = len - 1; i >= 0; i--) {
            if (input.charAt(i) == t) {
                dis = 0;
            } else {
                dis++;
                dy[i] = Math.min(dy[i], dis);
            }
        }
        for (int i : dy) {
            System.out.print(i + " ");
        }

    }
}
