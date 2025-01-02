package 배열;

import java.util.Scanner;

public class p1475 {
    /**
     * 나의 풀이 방법 : 입력 받을 때부터 6,9의 사용 수가 일치하게 if문을 사용했음
     * 타 풀이 방법 : 그냥 0~9 까지 입력을 받아서 하나씩 증가하고,
     * 마지막 max를 구하는 과정에서 6,9를 제외한 나머지에서 max를 구하고,
     * (6의 횟수 + 9의 횟수 + 1) / 2 를 한 값과 나머지에서 구한 max를 비교해서
     * 더 큰 값을 정답으로 사용.
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int[] num = new int[10];

        for (int i = 0; i < input.length(); i++) {
            int number = input.charAt(i) - '0';
            if (number == 6 || number == 9) {
                if(num[6] > num[9]) num[9]++;
                else num[6]++;
            }
            else num[number]++;
        }

        int max = Integer.MIN_VALUE;
        for (int a : num) {
            max = Math.max(max, a);
        }

        System.out.println(max);

    }
}
