package Section2;

import java.io.*;
import java.util.*;

public class prob6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            boolean isPrime = true;
            StringBuilder sb = new StringBuilder(st.nextToken()).reverse();
            int num = Integer.parseInt(sb.toString());
            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && num != 1) {
                System.out.print(num+ " ");
            }
        }

        // 강의 해설 res = res * 10 + t 를 이용하여 직접 뒤집어주고, 소수 임을 판별
        for (int i = 0; i < n; i++) {
            int tmp =Integer.parseInt(st.nextToken());
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if (isPrime(res)) {
                System.out.print(res + " ");
            }
        }
    }

    public static boolean isPrime(int res) {
        if(res == 1) return false;
        else {
            for (int i = 2; i < res; i++) {
                if(res % i ==0) return false;
            }
        }
        return true;
    }
}
