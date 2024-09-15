package etc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p1931 {
    /**
     * 나의 구현방법
     * 회의의 종료시간으로 오름차순 정렬을 진행하고, 만약 회의의 종료시간이 같으면 시작 시간을
     * 기준으로 오름찻누 정렬한다. 이후 정렬된 회의 정보에 따라 반복문을 실행한다.
     * 이전 회의의 종료시간보다 현재 회의의 시작시간이 크거나 같다면 정답을 증가하고,
     * 종료 시간을 현재 회의의 종료시간으로 변경한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Meeting> list = new ArrayList<>();

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            list.add(new Meeting(start, end));
        }

        Collections.sort(list);

        int answer =0;
        int endTime = 0;
        for (Meeting meeting : list) {
            if (endTime <= meeting.start) {
                answer++;
                endTime = meeting.end;
            }
        }

        System.out.println(answer);

    }
}

class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    public int compareTo(Meeting o) {
        if (this.end == o.end) {
            return this.start - o.start;
        } else {
            return this.end - o.end;
        }
    }
}