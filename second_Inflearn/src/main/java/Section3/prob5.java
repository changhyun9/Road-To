package Section3;

import java.io.*;
import java.util.*;

public class prob5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int answer = 0;
        int sum = 0, lt = 1, rt = 1;

        // 강의에서는 for문으로 해결
        while (rt < n / 2 + 2) {
            sum += rt++;
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= lt++;
                if (sum == n) {
                    answer++;
                }
            }
        }

        // 강의 해설 수학적 방법으로 해결
        int cnt = 1; // 자리수 하나
        n--; // 자리수 하나에 값 할당
        while (n > 0) {
            cnt++; // 자리 수 증가
            n = n - cnt; // 자리 수 증가에 따른 값 할당
            if(n%cnt ==0) answer++; // 현재 n 값이 자리수에 따라 나눠지면 동등하게 배분 가능. 즉, 연속된 자연수
        }
        System.out.println(answer);
    }
}
