package Section6;

import java.io.*;
import java.util.*;

public class prob2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) { // 턴의 횟수, 1씩증가
            for (int j = 0; j < n - i - 1; j++) { // i가 1씩 증가함에 따라, j는 1씩 감소
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int num : arr) {
            System.out.print(num+ " ");
        }
    }
}
