package Section2;

import java.io.*;
import java.util.*;

public class prob6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(st.nextToken());
            int num = Integer.parseInt(sb.reverse().toString());
            boolean flag = false;
            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    flag= true;
                    break;
                }
            }
            if (!flag && num != 1) {
                System.out.print(num + " ");
            }

        }
    }
}
