package Section6;

import java.util.Scanner;

public class Q2 {
    /**
     * 내가 구현한 방법
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int k = arr.length - 1; k > 0; k--) {
            for (int i = 0; i < k; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
