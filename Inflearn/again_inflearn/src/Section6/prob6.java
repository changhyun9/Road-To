package Section6;

import java.io.*;
import java.util.*;

public class prob6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr1[i] = num;
            arr2[i] = num;
        }
        Arrays.sort(arr2);

        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.print(i +1 + " ");
            }
        }
    }
}
