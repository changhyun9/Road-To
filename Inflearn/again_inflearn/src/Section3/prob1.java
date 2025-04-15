package Section3;

import java.io.*;
import java.util.*;

public class prob1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] first = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            first[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(bf.readLine());
        int[] second = new int[m];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < m; i++) {
            second[i] = Integer.parseInt(st.nextToken());
        }

        int size = n + m;
        int[] answer = new int[size];
        int lt = 0, rt = 0, idx=0;
        while (lt < n && rt < m) {
            if (first[lt] < second[rt]) {
                answer[idx] = first[lt];
                lt++;
            } else {
                answer[idx] = second[rt];
                rt++;
            }
            idx++;
        }

        if (lt == n) {
            while (idx < size) {
                answer[idx] = second[rt];
                idx++;
                rt++;
            }
        } else {
            while (idx < size) {
                answer[idx] = first[lt];
                idx++;
                lt++;
            }
        }

        for (int num : answer) {
            System.out.print(num + " ");
        }

    }
}
