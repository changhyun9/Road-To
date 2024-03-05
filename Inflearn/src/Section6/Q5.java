package Section6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Q5 {
    /**
     * 나의 구현방법
     * 간단하게 숫자 배열을 받고, List로 변환한뒤, List를 Set으로 변환
     * Set은 중복을 허용하지 않기 때문에 중복을 제거하여 값을 저장.
     * 따라서 List와 Set의 size를 비교해보면 중복이 된 숫자가 존재하는지 확인 가능
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] numbers = new Integer[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        List<Integer> asList = Arrays.asList(numbers);
        Set<Integer> set = new HashSet<>(asList);

        if (asList.size() == set.size()) {
            System.out.println("U");
        } else {
            System.out.println("D");
        }
    }

    /**
     * 강의에서의 풀이법
     * HashMap으로 key-value로 put하면서 이미 있으면 종료하는 식으로 풀면 O(n) 시간복잡도로 끝낼수 있지만
     * 강의에서는 정렬을 사용하여 nlogn으로 풀이
     * Arrays의 sort메서드를 통해 정렬을 진행한 후, 이웃한 (앞,뒤) 수를 비교하여 같으면 D를 출력, 아니면 U를
     * 출력하여 문제를 해결
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String answer = "U";
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                answer = "D";
            }
        }
        System.out.println(answer);
    }*/
}
