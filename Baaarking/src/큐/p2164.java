package 큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class p2164 {
    /**
     * 나의 풀이 방법 : Deque를 이용해서 맨위 제거, 다시 맨위 제거하고 해당 데이터를 다시 마지막 부분에 삽입
     * 처음엔 최대 500,000이라 시간 초과가 날 줄 알았는데, 직접 해보니 N^2이 아니라 n으로 충분할 것 같다고 판단
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=1; i<=n; i++){
            deque.offer(i);
        }

        while (deque.size() != 1) {
            deque.poll();
            Integer poll = deque.poll();
            deque.offerLast(poll);
        }

        bw.write(deque.peek()+"\n");
        bw.flush();
        bw.close();
    }
}
