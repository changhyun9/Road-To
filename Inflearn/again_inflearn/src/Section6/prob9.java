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
        int max = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            max += num;
            arr[i] = num;
        }

        int lt =1,rt=max;
        int answer = Integer.MAX_VALUE;
        while (lt <= rt) {
            int mid = (lt+rt)/2;
            if (count(mid) <= m) {
                rt = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                lt = mid+1;
            }
        }

        System.out.println(answer);

    }

    static int count(int size) {
        int cnt = 1;
        int sum = 0;
        for (int num : arr) {
            if (sum + num > size) {
                cnt++;
                sum = num;
            } else {
                sum += num;
            }
        }
        return cnt;
    }
}
