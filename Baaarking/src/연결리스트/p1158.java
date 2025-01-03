package 연결리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p1158 {
    /**
     * 나의 풀이 방법 : 처음엔 LinkedList와 ListIterator를 이용해서 풀려고 했는데, ListIterator가 마지막 요소에
     * 도달했을때, 처음으로 돌아가는 방법이 1.새로운 객체를 생성하거나, 2.idx = (idx+1)%size를 이용해서 순환을 만드는 경우였는데
     * 1번의 경우에는 반복하는 횟수가 커지면 효율적이지 않을 것 같아. 2번을 채택. 그렇게 되면, LinkedList보다는 List가
     * 더 적합할 것이라고 생각해서, List로 구현.
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> answer = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }
        int idx = 0;

        while (numbers.size() != 0) {
            int size = numbers.size();
            for (int i = 1; i < K; i++) {
                idx = (idx +1) % size;
            }
            answer.add(numbers.get(idx));
            numbers.remove(idx);
        }

        System.out.println(answer.toString().replace("[", "<").replace("]",">"));
    }
}
