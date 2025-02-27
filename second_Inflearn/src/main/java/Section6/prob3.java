package Section6;

import java.io.*;
import java.util.*;

public class prob3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 강의 해설 i부터 N-1까지 값을 하나씩 비교함. i번쨰 -1부터 0까지 인덱스랑.
        // 만약에 i번째 값보다 크면, 하나씩 뒤로 미룸.

        for (int i = 1; i < n; i++) { // 1번 ~ N-1 까지
            int temp = arr[i], j;
            for (j = i-1; j >= 0; j--) { // i번째 앞부터 차근차근 비교
                if (arr[j] > temp) { // i번째 값보다 크면, 뒤로 이동
                    arr[j + 1] = arr[j];
                } else break; // i번째 값보다 작으면, for문 정지
            }
            arr[j + 1] = temp; // 정지된 곳 뒤에 i번째 값 삽입
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
