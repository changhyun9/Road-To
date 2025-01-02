package 배열;

import java.util.Scanner;

public class p3273 {
    /**
     * 나의 풀이 방법 : 기존 강의에서 풀었던 연습 문제와 동일
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int answer =0;
        int[] num = new int[2000001];
        int[] list = new int[size];

        for (int i = 0; i < size; i++) {
            int input = sc.nextInt();
            list[i] = input;
        }

        int x = sc.nextInt();

        for (int temp : list) {
            if(x>temp && num[x-temp] == 1) answer++;
            num[temp]++;
        }
        System.out.println(answer);
    }
}
