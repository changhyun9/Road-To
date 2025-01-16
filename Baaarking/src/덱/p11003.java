package 덱;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p11003 {
    /**
     * 나의 풀이 방법 : 슬라이딩 윈도우와 Point 객체를 만들어서 문제 푸는 로직까지는 떠올렸는데,
     * 최소값이 빠졌을때, 다음 최소값을 구하는 즉, 정렬하는 로직을 생각해내지 못함.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        LinkedList<Point> deque = new LinkedList<>();


        for(int i=0; i<N; i++){
            int d = Integer.parseInt(st.nextToken());
            while(!deque.isEmpty() && deque.getLast().value > d){
                deque.pollLast();
            }

            deque.offerLast(new Point(d, i));

            if (deque.getFirst().index <= i - L) {
                deque.pollFirst();
            }
            bw.write(deque.getFirst().value + " ");
        }

        bw.flush();
        bw.close();

    }

    static class Point {
        int value;
        int index;

        public Point(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
