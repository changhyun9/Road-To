package Section1;

import java.util.Scanner;

public class Q6 {
    /**
     * 내가 구현한 방법
     * 반복문을 돌면서 문자열에 현재 문자가
     * 포함되어 있는지를 판단해서 추가
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();

        String temp = "";
        char[] array = line.toCharArray();
        for (char ch : array) {
            if(!temp.contains(Character.toString(ch))){
                temp += ch;
            }
        }
        System.out.println(temp);
    }

    /**
     * indexOf() 를 사용해서 구현
     * 현재 위치와 현재 위치에 있는 문자가
     * 처음 나온 위치(indexOf)가 같으면 추가
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();

        String temp = "";
        for (int i = 0; i < line.length(); i++) {
            if (line.indexOf(line.charAt(i)) == i) {
                temp += line.charAt(i);
            }
        }
        System.out.println(temp);
    }*/
}
