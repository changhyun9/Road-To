package Section1;

import java.io.*;
import java.util.*;

public class prob10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String input = st.nextToken();
        char target = st.nextToken().charAt(0);

        int size = input.length();
        int[] dis = new int[size];

        int cnt = 999;
        for (int i = 0; i < size; i++) {
            if (input.charAt(i) == target) {
                cnt =0;
                dis[i] =cnt;
            } else {
                dis[i] = ++cnt;
            }
        }

        cnt = 999;
        for (int i = size - 1; i >= 0; i--) {
            if (input.charAt(i) == target) {
                cnt = 0;
            } else {
                dis[i] = Math.min(dis[i], ++cnt);
            }
        }

        for (int num : dis) {
            System.out.print(num + " ");
        }
    }
}
