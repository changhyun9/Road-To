package Section1;

import java.util.Scanner;

public class Q12 {
    /**
     * 내가 구현한 방법
     * 입력한 문자 수 만큼 배열을 만들어서, 7자리 마다 문자를 끊어서 저장한다
     * 배열에 저장한 문자열을 처음부터 끝까지 돌면서 1을 만나는 경우에는
     * Math.pow를 이용하여 값을 누적시킨후에 int형을 아스키 코드로 변환하여 String으로 저장
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String[] array = new String[count];
        String input = sc.next();
        String temp = "";
        String one = input.replaceAll("\\*", "0");
        String result = one.replaceAll("#", "1");

        for(int i=0; i<count; i++){
            String substring = result.substring(i * 7, i * 7 + 7);
            array[i] = substring;
        }

        for (String s : array) {
            int sum =0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '1'){
                    sum += Math.pow(2, 6 - i);
                }
            }
            temp += (char) sum;
        }
        System.out.println(temp);
    }

    /**
     * substring을 이용하여 7자리씩 끊어서 replace를 실행한다.
     * 그럼 7자리인 2진수 문자열이 만들어지는데 해당 문자열을 parseInt를 통해 10진수 정수로 변환한다
     * 해당 정수를 char로 형변환하여 저장하고, 사용된 7자리 이후로 문자열을 자르고 재설정한다
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String input = sc.next();
        String temp = "";
        for (int i = 0; i < count; i++) {
            String str = input.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(str, 2);
            temp += (char) num;
            input = input.substring(7);
        }

        System.out.println(temp);
    }*/
}
