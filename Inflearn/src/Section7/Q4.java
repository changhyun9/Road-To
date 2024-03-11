package Section7;

import java.util.Scanner;

public class Q4 {
    /**
     * 나의 구현방법
     */

    static int[] memory;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        memory = new int[N + 1];

        /*
        for (int i = 1; i <= N; i++) {
            System.out.print(fibo_1(i) + " "); // N 항의 값을 구하는 메서드와 for문을 사용, 1~N까지 각 항마다 재귀를 돎
        }
        */

        /*
        fibo_2(N); // static 배열을 사용해서 한번 재귀를 돌면 배열에 1~N까지의 값을 구함
        for (int i = 1; i <= N; i++) {
            System.out.print(memory[i] + " ");
        }
        */

        fibo_3(N); // 이미 구했던 값에 대해 재귀를 돌지않고, 이미 구한 값이라면 저장된 값을 반환 (memorization)
        for (int i = 1; i <= N; i++) {
            System.out.print(memory[i] + " ");
        }


    }

    public static int fibo_1(int num) {
        if (num == 1) {
            return 1;
        } else if (num == 2) {
            return 1;
        } else{
            return fibo_1(num - 2) + fibo_1(num - 1);
        }
    }

    public static int fibo_2(int num) {
        if (num == 1) {
            return memory[num] = 1;
        } else if (num == 2) {
            return memory[num] = 1;
        } else{
            return memory[num] = fibo_2(num - 2) + fibo_2(num - 1);
        }
    }

    public static int fibo_3(int num) {
        if(memory[num] > 0) return memory[num];
        if (num == 1) {
            return memory[num] = 1;
        } else if (num == 2) {
            return memory[num] = 1;
        } else{
            return memory[num] = fibo_3(num - 2) + fibo_3(num - 1);
        }
    }
}
