package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class p10845 {
    /**
     * 나의 풀이 방법 : 처음엔 Queue를 이용하여 문제를 풀었음. 근데 rear 부분의 원소에 접근할 수 없다는 것을 알고
     * Array 기반의 Deque를 사용하여 문제를 해결함. Array 기반의 Deque를 사용하는 것이 보다 효율적이라고
     * 자바 공식문서에도 나와있음. LinkedList vs ArrayDeque -> ArrayDeque 사용하기.
     * Queue는 front, 즉 앞에서만 꺼낼 수 있음. Deque는 Stack + Queue이기 때문에 front, back 모두 접근가능함.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i=0; i<n; i++){
            String[] input = bf.readLine().split(" ");
            if(input[0].equals("push")){
                deque.offer(Integer.parseInt(input[1]));
            } else if (input[0].equals("pop")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.poll());
                } else {
                    System.out.println("-1");;
                }
                
            } else if (input[0].equals("front")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.getFirst());
                } else {
                    System.out.println("-1");;
                }
                
            } else if (input[0].equals("back")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.getLast());
                } else {
                    System.out.println("-1");;
                }
                
            } else if (input[0].equals("size")) {
                System.out.println(deque.size());
                
            } else{
                if (!deque.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println("1");;
                }

            }

        }
    }
}
