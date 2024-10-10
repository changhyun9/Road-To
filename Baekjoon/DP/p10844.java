package DP;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class p10844 {
    /**
     * 나의 구현방법
     * 처음에 N의 자리수로 dp를 접근했는데 각 단계별 숫자 개수 별로 영향을 미치는 것을 파악하고
     * 0~9 까지 배열을 만들어서 dp를 해결하였다. int로는 안될 것 같아 long으로 했지만
     * long으로도 부족하여 오버플로우가 발생하였다. 이를 해결하기 위해 Biginteger를 도입하였고
     * 해결을 할 수 있었다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        BigInteger answer = new BigInteger("0");

        BigInteger [] dp = new BigInteger[10];
        BigInteger [] arr = new BigInteger[10];

        dp[0] = new BigInteger("0");
        for (int i = 1; i < 10; i++) {
            dp[i] = new BigInteger("1");
        }


        for (int k = 1; k < N; k++) {
            arr = Arrays.copyOf(dp, dp.length);
            for (int i = 0; i < 10; i++) {
                if(i==9) dp[i] = arr[i-1];
                else if(i==0) dp[i] = arr[i+1];
                else dp[i] = arr[i-1].add(arr[i+1]);
            }
        }


        for (BigInteger cnt : dp) {
            answer = answer.add(cnt);
        }
        System.out.println(answer.remainder(new BigInteger("1000000000")));



    }
}
