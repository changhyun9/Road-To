package Section1;

import java.util.Scanner;

public class Q8 {
    /**
     * 내가 구현한 방법
     * lt와 rt를 두고 알파벳을 찾아서 각각 증가, 감소를 시킴
     * 알파벳을 만난 경우 소문자로 변환을 하고, 같은지 비교를 함
     * 다르면 flag를 true로 바꿈
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] array = input.toCharArray();
        int lt  =0;
        int rt = array.length -1;
        boolean flag = false;
        while (lt < rt) {
            if(!Character.isAlphabetic(array[lt])){
                lt++;
            } else if (!Character.isAlphabetic(array[rt])) {
                rt--;
            }
            else {
                char lt1 = Character.toLowerCase(array[lt]);
                char rt1 = Character.toLowerCase(array[rt]);
                if(lt1 != rt1){
                    flag = true;
                }
                lt++;
                rt--;
            }
        }

        if(flag){
            System.out.println("NO");
        }
        else {
            System.out.println("YES");
        }
    }
    /**
     * 정규식이 사용가능한 replaceAll을 이용하여
     * 알파벳이 아닌 것들을 모두 빈칸으로 치환한다
     * 이후 StringBuilder의 reverse()를 사용하여 뒤집은 문자열을 만들고
     * equals 로 같음을 비교
     */
   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "NO";
        String input = sc.nextLine();
        input = input.replaceAll("[^a-zA-Z]", "").toUpperCase();
        String temp = new StringBuilder(input).reverse().toString();
        if (input.equals(temp)) {
            answer = "YES";
        }
        System.out.println(answer);
    }*/
}
