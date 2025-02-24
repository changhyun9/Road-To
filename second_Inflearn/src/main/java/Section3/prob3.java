package Section3;

import java.io.*;
import java.util.*;

public class prob3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, rt = 0;
        int sum = 0;
        while (rt != n) {
            if (rt - lt == k) {
                max = Math.max(max, sum);
                sum -= arr[lt++];
            } else {
                sum += arr[rt++];
            }
        }

        // 강의 해설은 미리 K개를 sum에 초기화하고, i, i-k를 이용해서 인덱스 접근
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        max = sum;
        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            max = Math.max(max, sum);
        }

        System.out.println(max);


    }
}
