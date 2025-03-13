package Section1;

import java.util.Scanner;

public class Q7 {
    /**
     * 내가 구현한 방법
     * 이전에 구현한 reverse처럼 lt와 rt를 두고, 같으면 각각 증가, 감소
     * 다르면 flag 를 변경한 뒤, while를 빠져나옴
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String line = input.toLowerCase();
        int lt = 0;
        int rt = line.length() - 1;
        boolean flag = false;
        while (lt < rt) {
            if(line.charAt(lt) == line.charAt(rt)){
                lt++;
                rt--;
            }
            else{
                flag = true;
                break;
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
     * 전체의 반을 탐색하여 앞의 전반부와 뒤의 후반부를 비교하는 것
     * 이렇게 되면 탐색 길이가 반으로 줄어듬
     * 그리고 기본적으로 리턴값을 "YES"로 설정한다
     * 만약 비교해서 다른 값이면 "NO"를 직접 리턴하거나
     * 리턴 변수를 "NO"로 변경
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "YES";
        String input = sc.next();
        input = input.toUpperCase();
        int len = input.length();
        for (int i = 0; i < len / 2; i++) {
            if (input.charAt(i) != input.charAt(len - i - 1)) {
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);
    }*/

    /**
     * StringBuilder 의 reverse()를 사용
     * 값을 뒤집은 다음에 equalsIgnoreCase()를 통해 같은 지확인
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "NO";
        String input = sc.next();
        String temp = new StringBuilder(input).reverse().toString();
        if (temp.equalsIgnoreCase(input)) {
            answer = "YES";
        }
        System.out.println(answer);
    }*/
}
