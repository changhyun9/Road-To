package Section6;

import java.util.Arrays;
import java.util.Scanner;

public class Q8 {
    /**
     * 나의 구현방법
     * 정렬되지 않은 숫자들을 배열로 저장하고 Arrays.sort로
     * 간단하게 정렬하고, M을 탐색한다. 우선 사이즈를 반으로 나눈
     * 가운데 인덱스를 기준으로 작으면 왼쪽, 크면 오른쪽 탐색한다.
     * 왼쪽으로 탐색할 때에는 start 는 변하지 않고, end 값을 기존 mid
     * 값으로 설정하고, mid는 start와 end를 더한 값을 2로 나눈 값으로 설정
     * 오른쪽으로 탐색할 때에는 end는 변하지 않고, start 값을 기존 mid
     * 값으로 설정하고, mid는 start와 end를 더한 값을 2로 나눈 값으로 설정한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int start = 0;
        int end = N-1;
        int answer =0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == M) {
                answer = mid + 1;
                break;
            }
            if(arr[mid] > M){
                end = mid - 1;
            } else{
                start = mid+1;
            }
        }
        System.out.println(answer);
    }
}
