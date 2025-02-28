package Section6;

import java.io.*;
import java.util.*;

public class prob10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long answer = 0;


        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        long lt = 1;
        long rt = list.get(list.size() - 1);

        // 강의 해설 possible 메서드의 반환값으로 해당 거리로 말이 몇마리 들어갔는지 말의 마리 수를 반환
        // 그래서 해당 반환값이 C보다 크거나 같으면으로 조건문 판단
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            if (possible(list, mid, c)) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean possible(List<Integer> list, long mid, long c) {
        long pos = list.get(0);
        c--;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - pos >= mid) {
                pos = list.get(i);
                c--;
            }
            if (c == 0) {
                return true;
            }
        }
        return false;
    }
}
