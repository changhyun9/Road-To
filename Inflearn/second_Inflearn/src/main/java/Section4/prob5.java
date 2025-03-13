package Section4;

import java.io.*;
import java.util.*;

public class prob5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int answer = -1;

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 강의 해설 TreeSet 을 이용해서 중복 제거 및 정렬까지 수행
        // Set은 중복제거만 하고, TreeSet 은 레드블랙 트리로 중복제거, 정렬까지 진행 (기본적으로 오름차순)
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int z = j + 1; z < n; z++) {
                    treeSet.add(arr[i] + arr[j] + arr[z]);
                }
            }
        }

        int cnt = 0;
        for (Integer num : treeSet) {
            cnt++;
            if (cnt == k) {
                answer = num;
            }
        }
        System.out.println(answer);

    }
}
