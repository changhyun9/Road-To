package Section6;

import java.io.*;
import java.util.*;

public class prob9 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        int lt =0, rt=0, answer =0;

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            rt += arr[i];
        }

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (DFS(mid) > m) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }

    public static int DFS(int size) {
        int cnt = 1;
        int sum = 0;
        for (int num : arr) {
            if (sum + num > size) {
                sum = num;
                cnt++;
            } else {
                sum += num;
            }
        }
        return cnt;
    }
}
