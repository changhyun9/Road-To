package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class p1010 {
    /**
     * 순열을 곧바로 떠올렸다. 최대 범위도 30 이기 때문에 구현에 대한 문제는 없었다.
     * 그리고 int형으로 선언하여 구현했는데, 테스트케이스에서 오버플로우가 발생했다.
     * 그래서 더 큰 자료형인 long형으로 구현했는데 테스트케이스에서는 성공했지만,
     * 히든케이스에서 통과하지 못했다. 그래서 더 큰 자료형을 찾다가 Java에서 제공하는
     * BigInteger라는 클래스를 발견하였다. 해당 클래스를 적용하여 문제를 풀었다.
     * 단점으로는 일반적인 사칙연산으로는 안되고, 제공되는 메서드로 연산을 진행해야 한다는 것이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            per(n, m);
        }
    }

    public static void per (int r, int n) {
        int cnt =r;
        BigInteger sum1 = BigInteger.valueOf(1);
        BigInteger sum2 = BigInteger.valueOf(1);
        for(int i=0; i<cnt; i++){
            sum1 = sum1.multiply(BigInteger.valueOf(n--));
            sum2 = sum2.multiply(BigInteger.valueOf(r--));
        }
        System.out.println(sum1.divide(sum2));
    }
}
