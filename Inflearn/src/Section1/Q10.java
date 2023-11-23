package Section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q10 {
    /**
     * 내가 구현한 방법
     * 입력받은 alphabet의 인덱스를 모두 구해서 List에 저장한다
     * 모든 인덱스를 돌면서 List에 저장된 인덱스와 거리를 구하여
     * 가장 작은 값을 배열에 저장한다
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String al = sc.next();

        int[] memory = new int[input.length()];
        List<Integer> point = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == al.charAt(0)) {
                point.add(i);
            }
        }
        for (int i = 0; i < input.length(); i++) {
            int min = Integer.MAX_VALUE / 16;
            for (Integer a : point) {
                if(min > Math.abs(i - a)){
                    min = Math.abs(i - a);
                }
            }
            memory[i] = min;
        }

        for (int i : memory) {
            System.out.print(i+ " ");
        }
    }

    /**
     * 0 -> 10, 정방향으로 진행하면서 왼쪽에 있는 타켓과의 거리를 저장
     * 10 -> 0, 역방향으로 진행하면서 오른쪽에 있는 타켓과의 거리를 구함
     * 이후, 기존에 왼쪽에 있는 타켓과의 거리와 비교하여 더 작은 값을 저장
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char tar = sc.next().charAt(0);
        int[] answer = new int[input.length()];

        int p = 1000;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == tar) {
                p =0;
                answer[i] = p;
            }
            else {
                p++;
                answer[i] = p;
            }
        }

        p = 1000;
        for (int i = input.length() - 1; i >= 0; i--) {
            if(input.charAt(i) == tar){
                p = 0;
            }
            else{
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        for (int i : answer) {
            System.out.print(i+ " ");
        }
    }*/
}
