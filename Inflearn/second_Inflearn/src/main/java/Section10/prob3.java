package Section10;

import java.io.*;
import java.util.*;

public class prob3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] arr = new int[n];
        int[] dy = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = dy[0];
        dy[0] = 1;
        for (int i = 1; i < n; i++) { // 해당 인덱스를 마지막 요소로 하는 최대 증가 수열 찾기
            int max = 0;
            for (int j = i-1; j >= 0; j--) { // 역순으로 가면서, 본인 값보다 작은 것들 중 가장 긴 부분 증가 수열찾기.
                if(arr[j] < arr[i] && dy[j] > max){
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }


        System.out.println(answer);
    }
}
