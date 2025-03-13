package Section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q3 {
    /**
     * 나의 구현방법
     */
    /**public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] timeTable = new int[72];
        List<Time> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Time(s, e));
        }

        for (Time t : list) {
            for (int i = t.start; i < t.end; i++) {
                timeTable[i]++;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 72; i++) {
            if (max < timeTable[i]) {
                max = timeTable[i];
            }
        }
        System.out.println(max);
    }**/

    /**
     * 강의해설
     * 도착시간과 귀가시간을 받으면, 시간과 도착인지, 귀가인지 상태를 저장하는 클래스로 값을 저장한다.
     * 그래서 해당 값들을 모두 돌면서 도착시간이면 인원을 하나 증가시키고, 귀가시간이면 인원을 하나 감소시킨다.
     * 그리고 정렬시에 시간 순으로 정렬을 진행하는데, 같은 경우에는 귀가시간이 먼저 오도록 정렬을 진행한다.
     * 그렇지 않으면 도착이 먼저 값에 반영되기 때문에 귀가한 사람의 숫자가 누락될 수 있다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = Integer.MIN_VALUE;
        List<Wedding> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sT = sc.nextInt();
            int eT = sc.nextInt();
            list.add(new Wedding(sT, 's'));
            list.add(new Wedding(eT, 'e'));
        }

        Collections.sort(list);
        int cnt = 0;
        for (Wedding w : list) {
            if(w.state == 's') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}

class Wedding implements Comparable<Wedding>{
    int time;
    char state;

    public Wedding(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Wedding wedding) {
        if(wedding.time == this.time) return this.state - wedding.state;
        return this.time - wedding.time;
    }
}
