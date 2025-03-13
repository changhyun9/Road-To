package Section7;

import java.util.Scanner;

public class Q3 {
    /**
     * 나의 구현방법
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = factorial(N);
        System.out.println(answer);
    }

    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
}
