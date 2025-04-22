package Section6;

import java.io.*;
import java.util.*;

public class prob10 {
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 1, rt = arr[n - 1];
        int answer = Integer.MIN_VALUE;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(mid) >= c) {
                lt = mid+1;
                answer = Math.max(answer, mid);
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(answer);
    }

    static int count(int dis) {
        int cnt = 1;
        int prior = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] - prior >= dis) {
                cnt++;
                prior = arr[i];
            }
        }
        return cnt;
    }
}
