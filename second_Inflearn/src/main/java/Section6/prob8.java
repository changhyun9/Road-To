package Section6;

import java.io.*;
import java.util.*;

public class prob8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int lt = 0, rt = n - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] < m) {
                lt = mid-1;
            } else if (arr[mid] > m) {
                rt = mid+1;
            } else {
                System.out.println(mid + 1);
                break;
            }
        }
    }
}
