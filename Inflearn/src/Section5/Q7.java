package Section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7 {
    /**
     * 내가 구현한 방법
     * 입력받은 필수 과목을 Queue로 저장하고,
     * 입력받은 교육과정의 요소들을 하나씩 접근한다.
     * 접근한 요소가 Queue에 포함되어 있는지 확인하고
     * 포함되어 있으면 다른 Queue에 저장한다.
     * 이후 모든 요소에 대해 접근이 끝나면 두개의
     * Queue를 비교하여 결과값을 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        String input2 = sc.next();
        Queue<Character> queue1 = new LinkedList<>();
        Queue<Character> queue2 = new LinkedList<>();
        for (char x : input1.toCharArray()) {
            queue1.offer(x);
        }
        for (char x : input2.toCharArray()) {
            if (queue1.contains(x)) {
                queue2.offer(x);
            }
        }

        if (queue2.equals(queue1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    /**
     * 강의에서는 필수과목을 Queue로 만들고
     * 교육 과정을 하나씩 요소를 접근한다.
     * 요소가 Queue에 포함되어 있으면 Queue의 맨앞 요소와
     * 같은지를 비교함. 만약 값으면 poll하고, 같지 않으면 break
     * 모든 요소를 돌고, Queue의 사이즈가 0인지 확인
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        String input2 = sc.next();
        Queue<Character> queue = new LinkedList<>();
        for (char x : input1.toCharArray()) {
            queue.offer(x);
        }
        for (char x : input2.toCharArray()) {
            if (queue.contains(x)) {
                if (x == queue.peek()) {
                    queue.poll();
                } else {
                    break;
                }
            }
        }
        if (queue.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }*/
}
