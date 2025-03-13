package Section4;

import java.util.HashMap;
import java.util.Scanner;

public class Q1 {
    /**
     * 내가 구현한 방법
     * 문자열을 입력받고, 해당 문자열을 처음부터 하나씩 HashMap과 비교를 함
     * 만약 HashMap에 이미 포함이 되어있으면, 해당 value를 불러와서 증가시킨 후에
     * 변경된 값으로 다시 put한다. 그렇지 않고, HashMap에 해당 key 값이 없으면
     * 현재 문자열을 key로 1을 value로 해서 HashMap에 put한다.
     * 모든 문자열에 대해 연산을 마친 후, KeySet를 불러와 모든 key에 대해
     * max 값을 구한뒤, 가장 큰 값을 가진 key를 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            char c = str.charAt(i);
            if (hashMap.containsKey(c)) {
                Integer cnt = hashMap.get(c);
                hashMap.put(c, ++cnt);
            }
            else{
                hashMap.put(c, 1);
            }
        }
        int max = Integer.MIN_VALUE;
        char answer = ' ';
        for (Character c : hashMap.keySet()) {
            int temp = hashMap.get(c).intValue();
            if (temp > max) {
                answer = c;
                max = temp;
            }
        }
        System.out.println(answer);
    }
}
