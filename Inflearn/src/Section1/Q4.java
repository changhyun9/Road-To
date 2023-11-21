package Section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4 {
    /**
     * 내가 구현한 방법
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] inputArray = new String[N];
        for(int i=0; i<N; i++){
            inputArray[i] = sc.next();
        }

        for(int i=0; i<N; i++){
            String temp = "";
            char[] chars = inputArray[i].toCharArray();
            for(int j =chars.length-1; j>=0; j--){
                temp += chars[j];
            }
            inputArray[i] = temp;
        }

        for (String str : inputArray) {
            System.out.println(str);
        }
    }

/**
 * StringBuilder 클래스를 이용하여 reverse() 사용 -> 단어의 전체를 뒤집어줌
 */

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] inputArray = new String[N];
        for(int i=0; i<N; i++){
            inputArray[i] = sc.next();
        }

        List<String> list = new ArrayList<>();
        for (String str : inputArray) {
            String temp = new StringBuilder(str).reverse().toString();
            list.add(temp);
        }

        for (String str : list) {
            System.out.println(str);
        }
    }*/

    /**
     * StringBuilder 의 reverse()를 직접 구현, 특정문자만 뒤집을 수 있음
     */

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] inputArray = new String[N];
        for(int i=0; i<N; i++){
            inputArray[i] = sc.next();
        }
        List<String> list = new ArrayList<>();

        for (String str : inputArray) {
            char[] array = str.toCharArray();
            int lt =0;
            int rt = str.length() - 1;
            while(lt < rt){
                char temp = array[lt];
                array[lt] = array[rt];
                array[rt] = temp;
                lt++;
                rt--;
            }
            String s = String.valueOf(array);
            list.add(s);
        }

        for (String str : list) {
            System.out.println(str);
        }
    }*/
}
