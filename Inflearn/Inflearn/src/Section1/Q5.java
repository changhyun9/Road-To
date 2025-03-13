package Section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q5 {
    /**
     * 내가 구현한 방법
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<line.length(); i++){
            if(Character.isAlphabetic(line.charAt(i))){
                list.add(i);
            }
        }

        String temp = "";
        for (int i = 0; i < line.length(); i++) {
            if(Character.isAlphabetic(line.charAt(i))){
                temp += line.charAt(list.get(list.size() - 1));
                list.remove(list.size() - 1);
            }
            else{
                temp += line.charAt(i);
            }
        }

        System.out.println(temp);
    }

    /**
     * Section1_04. 문자 뒤집기에서 구현한 reverse를 활용한 문제
     * 두개의 포인터를 두고, 둘다 알파벳을 가리킬 때가지 이동하고,
     * 둘다 알파벳을 가리키면 swap 하고, 포인터를 각각 증가, 감소 시킴
     */

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();

        char[] array = line.toCharArray();
        int lt = 0;
        int rt = line.length() - 1;
        while(lt < rt){
            if(!Character.isAlphabetic(array[lt])){
                lt++;
            }
            else if (!Character.isAlphabetic(array[rt])) {
                rt--;
            }
            else {
                char temp = array[lt];
                array[lt] = array[rt];
                array[rt] = temp;
                lt++;
                rt--;
            }
        }

        System.out.println(String.valueOf(array));
    }*/
}
