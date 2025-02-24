package Section3;

import java.io.*;
import java.util.*;

public class prob2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] a = new int[n];
        ArrayList<Integer> answer = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(bf.readLine());
        int[] b = new int[m];

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);
        int lt = 0, rt = 0;
        while (lt < n && rt < m) {
            if (a[lt] == b[rt]) {
                answer.add(a[lt]);
                lt++;
                rt++;
            } else if (a[lt] < b[rt]) {
                lt++;
            } else {
                rt++;
            }
        }

        for (Integer num : answer) {
            System.out.print(num + " ");
        }
    }
}
