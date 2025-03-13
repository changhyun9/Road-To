package Section3;

import java.io.*;
import java.util.*;

public class prob4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, rt = 0;
        long sum = 0, answer = 0;
        while (rt < n) {
            sum += arr[rt++]; // 더해주고, 값이 m 인지 확인
            if (sum == m) {
                answer++;
                sum -= arr[lt++];
            }
            while (sum > m) { // sum이 m보다 크면 더해도 계속 커지니까 lt 위치 값들을 작아질때까지 빼줌
                sum -= arr[lt++];
                if (sum == m) {
                    answer++;
                }
            }
        }


        System.out.println(answer);
    }
}
