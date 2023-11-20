package Section1;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ch = sc.nextLine();
        int count =0;

        str = str.toLowerCase();
        ch = ch.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ch.charAt(0)){
                count++;
            }
        }
        System.out.println(count);
    }
}
