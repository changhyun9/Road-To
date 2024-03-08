package Section6;

import java.util.Arrays;
import java.util.Scanner;

public class Q10 {
    /**
     * 나의 구현 방법 -> 못품
     * 강의 해설 -> 결정 알고리즘 (이분탐색)으로 구현
     * 결정 알고리즘은 lt와 rt 즉, 구간을 설정하는 것이 중요하다
     * 이후, 구간 내 존재하는 요소가 유효한지 확인하는 과정도 중요하다
     * 말이 존재하는 마구간의 최대 거리를 구하는 것이기 때문에
     * lt와 rt는 마구간 좌표 간의 좌표차이로 나타내고
     * 해당 요소가 유효한지는 입력받은 거리만큼에 말을 배치해보고
     * 설정한 요소값 보다 작은지, 큰지 확인하여 체크
     * 이후 해당 거리로 말을 배치했을 때 C보다 크면
     * 더 큰 범위를 탐색하고, 작으면 더 작은 범위를 탐색한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] arr = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[N - 1];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= C) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static int count(int[] arr, int dist) {
        int cnt =1;
        int ep = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] - ep >= dist){
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }
}
