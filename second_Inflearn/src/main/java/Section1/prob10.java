package Section1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String str = st.nextToken();
        char ch = st.nextToken().charAt(0);

        int[] arr = new int[str.length()];
        Arrays.fill(arr, Integer.MAX_VALUE);
        int index = str.indexOf(ch); // 0번 인덱스부터 거리를 측정하려고 미리 ch 위치 저장

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                index = i;
                arr[i] = 0;
            } else {
                arr[i] = Math.min(arr[i], Math.abs(i - index));
            }
        }

        for (int i = str.length()-1; i >= 0; i--) {
            if (str.charAt(i) == ch) {
                index = i;
                arr[i] = 0;
            } else {
                arr[i] = Math.min(arr[i], Math.abs(index - i));
            }
        }

        int[] answer = new int[str.length()];

        // 강의 해설 그냥 p라는 변수로 ch와의 거리를 계속해서 저장하고 있다가 배열에 삽입
        int p =1000; // 크게 잡는 이유는 최소 비교를 하기 때문에
        for (int i = 0; i < str.length(); i++) { // 본인보다 왼쪽에 있는 문자와의 거리 비교
            if (str.charAt(i) == ch) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }
        p=1000;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ch) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }


    }
}
