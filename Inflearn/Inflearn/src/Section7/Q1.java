package Section7;

import java.util.Scanner;

public class Q1 {
    /**
     * 나의 구현 방법
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        recursive(N);
    }

    public static void recursive(int num) {
        if (num == 0) {
            return;
        } else {
            recursive(num - 1);
            System.out.print(num + " ");
        }
    }
}
