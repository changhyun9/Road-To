package Section2;

import java.util.Scanner;

public class Q6 {
    /**
     * 내가 구현한 방법
     * String 배열로 값으 받아서 하나씩 StringBuilder를 통해
     * 값을 뒤집고 Integer로 변환을 했다. 이런 방법을 택해 012 -> 12로 변환할수 있었다
     * 또한, 1~N까지 돌면서 약수가 2이상이면 통과시켰고, 2개면 출력해서 소수를 찾았다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        for (String str : arr) {
            String a = new StringBuilder(str).reverse().toString();
            int one = Integer.parseInt(a);
            int count = 0;
            for (int i = 1; i <= one; i++) {
                if(one % i == 0) count ++;
            }
            if (count == 2) {
                System.out.print(one+ " ");
            }
        }
    }


    /**
     * 정수를 res = res * 10 + t 식을 통해 뒤집고,
     * 소수 판별을 진행하고 리턴한다
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i =0; i<size; i++){
            int tmp = arr[i];
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

    static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for(int i=2; i<num; i++){
            if (num % i ==0) return false;
        }
        return true;
    }*/
}
