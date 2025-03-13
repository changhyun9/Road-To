package Section4;

import java.util.HashMap;
import java.util.Scanner;

public class Q3 {
    /**
     * 내가 구현한 방법
     * N, K를 입력받고, N개의 정수를 입력받는다.
     * 처음에 K개의 값을 미리 HahsMap에 삽입해놓는다.
     * 이떄, 중복되는 값이 있다면, HashMap에 value를 ++증가하여
     * 삽입한다. 삽입되는 값이 존재하지 않는다면, 해당 정수를 key로
     * value를 1로 하여 삽입한다. 그다음부터 i가 0부터 N-K까지 반복문을
     * 실행한다. 맨 처음 나오는 값을 삭제한다. 이때, 삭제되는 값이 이미 값이 존재하고,
     * value가 1 초과 인것들은 구간내에 처음 말고도 존재한다는 뜻이므르, value 값만
     * -- 감소하여 put한다. 또한, 1 초과가 아닌 경우에는 그냥 해당 값을 key로 갖는
     * 요소를 삭제한다. 그다음으로 맨 마지막의 다음 요소를 추가한다. 이때, 이미 값이 존재한다면
     * value 값을 ++ 증가하여 삽입하고, 그렇지 않다면, 해당 정수를 key 값으로 하고 , value를
     * 1로 하여 hashMap에 저장한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < K; i++) {
            if (hash.containsKey(arr[i])) {
                Integer cnt = hash.get(arr[i]);
                hash.put(arr[i], ++cnt);
            } else{
                hash.put(arr[i], 1);
            }
        }
        System.out.print(hash.size() + " ");
        for (int i = 0; i < N - K; i++) {
            if (hash.get(arr[i]) > 1) {
                Integer cnt = hash.get(arr[i]);
                hash.put(arr[i], --cnt);
            } else {
                hash.remove(arr[i]);
            }
            if (!hash.containsKey(arr[i + K])) {
                hash.put(arr[i + K], 1);
            } else {
                Integer cnt = hash.get(arr[i + K]);
                hash.put(arr[i + K], ++cnt);
            }
            System.out.print(hash.size()+ " ");
        }
    }
}
