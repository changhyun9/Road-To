package Section3;

import java.io.*;
import java.util.*;

public class prob6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 강의 해설 rt가 0을 만나면 무조건 1로 바꿈. 그리고 1로 바꾼 횟수가 k보다 크면
        // lt를 움직이면서 1로 바꾼 0을 다시 0으로 변환
        int lt = 0, max = Integer.MIN_VALUE;
        int cnt = 0;
        for (int rt = 0; rt < n; rt++) {
            if(arr[rt] == 0) cnt++;
            while (cnt > k) {
                if (arr[lt] == 0) {
                    cnt--;
                }
                lt++;
            }
            max = Math.max(max, (rt - lt + 1));
        }
        System.out.println(max);

    }
}
