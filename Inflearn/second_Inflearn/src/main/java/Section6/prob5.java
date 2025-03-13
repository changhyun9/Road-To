package Section6;

import java.io.*;
import java.util.*;

public class prob5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String answer = "U";
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (list.contains(num)) {
                answer = "D";
                break;
            }
            list.add(num);
        }

        // 강의 해설은 배열을 받고, Arrays.sort 로 해서 이웃한 두 수 비교
        int[] arr = new int[n];
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                answer = "D";
                break;
            }
        }
        System.out.println(answer);
    }
}
