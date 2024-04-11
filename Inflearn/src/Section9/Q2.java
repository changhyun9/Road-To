package Section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q2 {
    /**
     * 나의 구현방법
     * 종료시간으로 정렬을 진행한다. 이때, 종료시간이 같은 경우에는 시작시간으로 정렬을 진행
     * 처음 종료시간을 저장하고, 다음 요소의 시작시간과 비교하여 해당 시작시간이 저장된 종료시간과
     * 같거나 큰경우, 즉 종료시간보다 시작시간이 늦는 경우에 해당 시작시간의 요소의 종료시간으로
     * 바꾸고, answer를 하나 증가시킨다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer =0;
        List<Time> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new Time(start, end));
        }

        Collections.sort(list);
        int end_time = 0;
        for (Time t : list) {
            if (end_time <= t.start) {
                answer++;
                end_time = t.end;
            }
        }
        System.out.println(answer);
    }
}

class Time implements Comparable<Time> {
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time t) {
        if (t.end == this.end) {
            return this.start - t.start;
        } else {
            return this.end - t.end;
        }
    }
}
