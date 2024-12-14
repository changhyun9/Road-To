package 기초코드작성요령;

import java.util.Scanner;

public class p2480 {
    /**
     * 나의 풀이방법
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int max = Integer.MIN_VALUE;

        int[] dice = new int[7];
        for (int i = 0; i < 3; i++) {
            int idx = sc.nextInt();
            dice[idx]++;
        }

        for (int i = 1; i < 7; i++) {
            if (dice[i] == 3) {
                System.out.println(10000 + (i * 1000));
                flag = false;
            } else if (dice[i] == 2) {
                System.out.println(1000 + (i * 100));
                flag = false;
            }
            if(dice[i] == 1) max = Math.max(max, i);
        }

        if (flag) {
            System.out.println(max * 100);
        }
    }
}
