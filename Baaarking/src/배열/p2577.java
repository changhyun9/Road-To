package 배열;

import java.util.Scanner;

public class p2577 {
    /**
     * 나의 풀이 방법
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int[] arr = new int[10];
        String output = Integer.toString(A * B * C);

        for (int i = 0; i < output.length(); i++) {
            arr[output.charAt(i)-'0']++;
        }

        for (int a : arr) {
            System.out.println(a);
        }
    }
}
