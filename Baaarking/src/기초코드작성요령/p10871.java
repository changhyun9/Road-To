package 기초코드작성요령;

import java.util.Scanner;

public class p10871 {
    /**
     * 나의 풀이방법
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int X = sc.nextInt();

        int[] arr = new int[A];

        for (int i = 0; i < A; i++) {
            arr[i] = sc.nextInt();
        }

        for (int a : arr) {
            if (X > a) {
                System.out.print(a + " ");
            }
        }


    }
}
