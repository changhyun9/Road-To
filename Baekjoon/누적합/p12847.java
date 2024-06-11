package 누적합;

import java.util.Scanner;

public class p12847 {
    /**
     * 처음엔 m이 아닌 테스트케이스로 주어진 3으로 고정시켜놔서 다른 케이스에서
     * 틀렸다. 그래서 다시 간단하게 m으로 고치고 제출을 했는데도 틀렸다.
     * 반례를 찾아보고, 다른 케이스를 해보아도 문제가 되는 것이 없었다.
     * 근데 급여를 저장하는 max와 temp의 자료형을 long으로 바꾸면 된다는 것을
     * 보고, 바꿔서 제출했더니 성공했다. 자료형을 신경써서 풀어야겠다. 특히 정수를
     * 더해서 답을 구하는 경우. long형 사용할 것.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            arr[i] = k;
        }

        int lt =0, rt=m-1;
        long temp = 0;
        for (int i = lt; i <= rt; i++) {
            temp += arr[i];
        }
        long max = temp;

        while (rt < n-1) {
            temp -= arr[lt];
            rt++;
            temp += arr[rt];
            lt++;
            max = Math.max(max, temp);
        }

        System.out.println(max);

    }
}
