package Section6;

import java.io.*;
import java.util.*;

public class prob6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] tmp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) {
                System.out.print(i+1 + " ");
            }
        }
    }
}
