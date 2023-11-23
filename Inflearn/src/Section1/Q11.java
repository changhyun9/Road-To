package Section1;

import java.util.Scanner;

public class Q11 {
    /**
     * 내가 구현한 방법
     * 문자열을 하나씩 돌면서 같으면 count 증가
     * 다르면 count에 따라 문자열 연산 후,
     * 기준 문자열을 변경하고, count를 1로 초기화
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String temp = "";
        int count = 0;
        char ch = input.charAt(0);

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ch){
                count ++;
            }
            else {
                if(count == 1){
                    temp += ch;
                }
                else{
                    temp = temp + ch + count;
                }
                ch = input.charAt(i);
                count = 1;
            }
        }
        if(count == 1){
            temp += ch;
        }
        else{
            temp = temp + ch + count;
        }
        System.out.println(temp);
    }

    /**
     * 현재 인덱스와 현재 인덱스+1 을 비교한다
     * 바로 뒷자리를 비교하기 때문에 배열의 OutOfIndex 가 발생할 수 있다 .그래서 임의적으로
     * " ", 빈공백을 추가해서 판별을 진행한다.
     * 만약 현재인덱스와 바로 뒤의 인덱스의 값이 같으면, 누적 횟수만 증가시킨다
     * 다른 문자를 가지고 있을 경우에는 문자를 임의변수에 String으로 저장하고,
     * 누적횟수가 1 초과 인것만 같이 String으로 저장한다.
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        input += " ";
        String temp = "";
        int cnt =1;
        for (int i = 0; i < input.length() - 1; i++) {
            if(input.charAt(i) == input.charAt(i+1)){
                cnt++;
            }
            else{
                temp += input.charAt(i);
                if(cnt > 1){
                    temp += cnt;
                }
                cnt =1;
            }
        }
        System.out.println(temp);
    }*/
}
