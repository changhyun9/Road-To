package Section2;

import java.io.*;
import java.util.*;

public class prob5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 강의 해설 '에라토스테네스 체'를 이용해서 소수 인지 아닌지 판별
        /*
        로직) 1. 입력받은 N 만큼 배열을 생성
            2. 포문을 돌면서 0이면 answer 1 증가
            3. 이후, i의 배수는 배열값을 모두 1 증가 시킴
            4. i 이동
            5. 다시 로직 반복
         */
        // 즉, 이전에 나온 값들로 약수가 있는 값들은 소수가 아니라는 것을 알 수 있음.
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n + 1];
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                answer++;
                for (int j = i; j <= n; j += i) {
                    arr[j] = 1;
                }
            }
        }
        System.out.println(answer);
    }
}
