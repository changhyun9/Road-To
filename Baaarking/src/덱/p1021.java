package 덱;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1021 {
    /**
     * 나의 풀이 방법 : 처음에 ArrayDeque로 구현되어있는 Deque를 사용했는데, 도저히 양쪽에서 접근했을때
     * 최소값을 찾는 로직이 떠오르지 않아서 검색을 진행함. LinkedList를 이용하여 문제를 풀었고, LinkedList는
     * indexOf가 있기에 타겟의 인덱스와 중앙 인덱스의 위치를 비교하여 양쪽 어디서 접근해야 최소인지, 알 수 있었음.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();

        int[] num = new int[m];
        int answer = 0;

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < m; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        for (int i = 0; i < m; i++) {
            int targetIdx = deque.indexOf(num[i]);
            int midIdx;
            if (deque.size() % 2 == 0) {
                midIdx = deque.size() / 2-1;
            } else {
                midIdx = deque.size() / 2;
            }

            if (midIdx < targetIdx) {
                for(int j=0; j<deque.size() - targetIdx; j++){
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    answer++;
                }
            } else {
                for(int j=0; j<targetIdx; j++){
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    answer++;
                }
            }
            deque.pollFirst();
        }

        bw.write(answer+"\n");

        bw.flush();
        bw.close();

    }
}
