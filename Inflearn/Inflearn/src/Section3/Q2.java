package Section3;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
    /**
     * 내가 구현한 방법
     * 입력받은 두개의 배열을 오름차순으로 정렬을하고,
     * 두개의 포인터를 각각 두어, 가리키고 있는 값이 작은 경우에
     * 해당 포인터를 다음 요소를 가리키게 한다. 만약, 두개의 포인터가
     * 가리키고 있는 요소가 같다면, 공통 요소를 저장하는 배열에 삽입하고
     * 두개의 포인터 모두 다음 요소를 가리키도록 한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] first = new int[N];
        for (int i = 0; i < N; i++) {
            first[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] second = new int[M];
        for (int i = 0; i < M; i++) {
            second[i] = sc.nextInt();
        }

        int total = N + M;
        int[] result = new int[total];
        int size = 0;
        int p1 = 0, p2 = 0;

        Arrays.sort(first);
        Arrays.sort(second);

        while (p1 < N && p2 < M) {
            if(first[N-1] < second[0]) break;
            if(first[p1] < second[p2]){
                p1++;
            } else if (first[p1] > second[p2]) {
                p2++;
            } else{
                result[size] = first[p1];
                size++;
                p1++;
                p2++;
            }
        }
        for (int one : result) {
            if (one == 0) {
                break;
            }
            System.out.print(one + " ");
        }
    }
}
