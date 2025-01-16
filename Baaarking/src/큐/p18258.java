package 큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class p18258 {
    /**
     * 나의 풀이 방법 : 처음에 n이 최대가 200만이었지만, p10845와 같은 코드로 제출하면 될 줄 알았다.
     * 시간초과가 발생했고, O(n)을 줄일 수 있는 방법이 없는 것같아서 검색해서 문제를 풀었고,
     * System.out.println()이 시간초과의 주범인 것을 알게 되었고, BufferedWrite를 도입하여 문제를 풀었다.
     * 근데 시간초과가 아닌 틀렸습니다.가 나와서 다시 검색해보니, BufferedWrite.write는 아스키코드 기반으로 출력하기
     * 때문에 String으로 변환과 개행문자를 직접 더해서 출력해줘야 한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split(" ");
            if(input[0].equals("push")){
                deque.offer(Integer.parseInt(input[1]));
            } else if (input[0].equals("pop")) {
                if (!deque.isEmpty()) {
                    bw.write(deque.poll()+ "\n");
                } else {
                    bw.write("-1\n");
                }

            } else if (input[0].equals("front")) {
                if (!deque.isEmpty()) {
                    bw.write(deque.getFirst()+ "\n");
                } else {
                    bw.write("-1\n");
                }

            } else if (input[0].equals("back")) {
                if (!deque.isEmpty()) {
                    bw.write(deque.getLast()+ "\n");
                } else {
                    bw.write("-1\n");
                }

            } else if (input[0].equals("size")) {
                bw.write(deque.size()+ "\n");

            } else{
                if (!deque.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write("1\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
