package 배열;

import java.util.Scanner;

public class p10808 {
    /**
     * 나의 풀이 방법
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] alphabet = new int[26];

        String input = sc.nextLine();


        for (int i = 0; i < input.length(); i++) {
            alphabet[input.charAt(i)-'a']++;
        }

        for (int num : alphabet) {
            System.out.print(num +" ");
        }

    }
}
