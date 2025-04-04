package Section6;

import java.io.*;
import java.util.*;

public class prob10 {
    static int c,n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[n - 1];
        int answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (isPossible(mid)) {
                lt = mid+1;
                answer = mid;
            } else {
                rt = mid-1;
            }
        }

        System.out.println(answer);
    }

    public static boolean isPossible(int len) {
        int cnt = 1;
        int pos = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] - pos >= len) {
                pos = arr[i];
                cnt++;
            }
        }

        if(cnt >= c) return true;
        return false;
    }
}
