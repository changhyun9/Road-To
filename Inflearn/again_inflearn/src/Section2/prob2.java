package Section2;

import java.io.*;
import java.util.*;

public class prob2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] people = new int[n];

        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int tmp = -1;

        for (int num : people) {
            if (tmp < num) {
                answer++;
                tmp = num;
            }
        }

        System.out.println(answer);
    }
}
