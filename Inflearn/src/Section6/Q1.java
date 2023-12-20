package Section6;

import java.util.Scanner;

public class Q1 {
    /**
     * 내가 구현한 방법
     * 선택정렬
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < N-1; i++) {
            int index = i;
            for (int j = i+1; j < N; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
