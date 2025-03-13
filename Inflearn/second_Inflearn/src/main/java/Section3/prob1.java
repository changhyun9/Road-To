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

        /* 단순 합치고, 정렬 -> 비효율적
        int[] total = new int[n + m];
        System.arraycopy(first, 0, total, 0, first.length);
        System.arraycopy(second, 0, total, first.length, second.length);
        Arrays.sort(total);
         */

        ArrayList<Integer> answer = new ArrayList<>();
        int lt = 0, rt = 0;
        while (lt < n && rt < m) {
            if(first[lt] < second[rt]) answer.add(first[lt++]);
            else answer.add(second[rt++]);
        }

        while(lt<n) answer.add(first[lt++]);
        while(rt<m) answer.add(second[rt++]);



        for (int num : answer) {
            System.out.print(num + " ");
        }
    }
}
