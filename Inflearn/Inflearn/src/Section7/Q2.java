package Section7;

import java.util.Scanner;

public class Q2 {
    /**
     * 나의 구현방법
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        recursive(N);
    }

    public static void recursive(int num) {
        if (num == 0) {
            return;
        }
        else {
            recursive(num / 2);
            System.out.print(num % 2 + " ");
        }
    }
}
