package Section6;

import java.io.*;
import java.util.*;

public class prob9 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int answer = 0;

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 강의 해설 이분탐색을 이용해서 최소 용량을 찾음.
        // 결정 알고리즘 (이분 탐색)은 정렬된 특정 범위 안에 무조건 정답이 있을 경우 사용

        int lt = Arrays.stream(arr).max().getAsInt(); // 직접 for문 돌리지말고, Stream 이용해서 값 추출, return 자료형 신경쓰기
        int rt = Arrays.stream(arr).sum(); // // 직접 for문 돌리지말고, Stream 이용해서 값 추출, return 자료형 신경쓰기

        while (lt <= rt) { // 이분 탐색을 통해 용량 검증
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= m) { // 해당 용량으로 DVD를 만들었을 때, 개수가 적거나 같으면
                answer = mid; // 일단 정답의 경우의 수로 저장해놓고
                rt = mid - 1; // 최소 값을 구하기 위해 mid보다 작은 범위 탐색
            } else {
                lt = mid + 1; // 해당 용량으로 했더니, DVD 개수가 많으면 mid보다 큰 범위 탐색으로 용량의 범위를 늘림.
            }
        }

        System.out.println(answer);
    }

    public static int count(int[] arr, int capacity) {
        int sum = 0, cnt = 1;
        for (int x : arr) { // 모든 노래 길이를 탐색
            if (sum + x > capacity) { // 임시로 더해서 용량 보다 크면, 새로운 DVD에 저장
                cnt++; // 새로운 DVD에 저장
                sum = x; // 새로우 DVD에 저장함으로 해당 노래부터 다시 더함.
            } else {
                sum += x; // DVD에 들어가면 (용량이 충분하면) 저장.
            }
        }
        return cnt; // 해당 용량으로 DVD를 생성한다 했을때 필요한 DVD 갯수 반환
    }
}
