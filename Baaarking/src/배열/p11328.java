package 배열;

import java.util.Scanner;

public class p11328 {
    /**
     * 나의 풀이 방법 : 문제 푸는 로직에는 잘못된 점이 없었음. 근데 매 횟수마다 배열을 초기화하고, flag를
     * 초기화해야 하는데 하지 않아서, 문제가 발생했고, 어디가 잘못 된지 몰랐음.
     * 사소한 부분을 신경쓰지 않는 버릇이 있음.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String count = sc.nextLine();


        for (int i = 0; i < Integer.parseInt(count); i++) {
            boolean flag = true;
            int[] arr = new int[26];
            String input = sc.nextLine();

            String[] split = input.split(" ");

            for (int j = 0; j < split[0].length(); j++) {
                arr[split[0].charAt(j)-'a']++;
            }
            for (int j = 0; j < split[1].length(); j++) {
                --arr[split[1].charAt(j)-'a'];
            }

            for (int value : arr) {
                if(value != 0) flag = false;
            }

            if (flag) System.out.println("Possible");
            else System.out.println("Impossible");

        }
    }
}
