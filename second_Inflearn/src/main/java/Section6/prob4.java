package Section6;

import java.io.*;
import java.util.*;

public class prob4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] works = new int[n];
        int[] cache = new int[s];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            works[i] = Integer.parseInt(st.nextToken());
        }

        for (Integer num : works) {
            boolean flag = false;
            int idx = -1;
            for (int i = 0; i < s; i++) {
                if (cache[i] == num) {
                    idx = i;
                    flag = true;
                }
            }

            if (flag) {
                for (int i = idx; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
                cache[0] = num;
            } else {
                for (int i = s-1; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
                cache[0] = num;
            }
        }

        for (int i = 0; i < s; i++) {
            System.out.print(cache[i] + " ");
        }

    }

}
