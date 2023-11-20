package Section1;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int range = ch - 'A';

            if (0 <= range && range <= 25){
                char c = (char)(ch + 32);
                temp += c;
            }
            else {
                char c = (char)(ch - 32);
                temp += c;
            }
        }
        System.out.println(temp);
    }
}
