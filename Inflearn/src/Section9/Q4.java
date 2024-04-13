package Section9;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q4 {
    /**
     * 나의 구현방법 못품
     * 강의해설 시간을 기준으로 내림차순 정렬을 한다. 내림차순 정렬과 요소를 역으로 접근하는 방법을 통해
     * 해당 요일에만 할 수 있는 강의와 그날 최대로 수입을 올릴 수 있는 강의를 선정할 수 있다.
     * 또한 Priority Queue를 이용하여 해당 날짜에 가장 큰 수입을 올릴 수 있는 강의를 뽑아낼 수 있다.
     * 기본적으로 Priority Queue는 작은 값이 먼저 나오는데, Collections.reverseOrder를 인자로 넣으면
     * 반대로 큰 값이 우선순위를 갖게 된다.
     * 그리고 두개의 for문을 이용하여 특정 날짜에만 할 수 있는 강의를 선정한다. max부터 역순으로 요소를 접근하고
     * 해당 Date 보다 작으면 Priority Queue에 넣지 않는다.
     */
    static int n, max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int answer =0;
        List<Lecture> list = new ArrayList<>();
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            list.add(new Lecture(m, d));
            if(d>max) max = d;
        }
        Collections.sort(list);
        int j =0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if(list.get(j).date < i) break;
                pQ.offer(list.get(j).money);
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }
        System.out.println(answer);
    }
}

class Lecture implements Comparable<Lecture> {
    int money;
    int date;

    public Lecture(int money, int date) {
        this.money = money;
        this.date = date;
    }

    @Override
    public int compareTo(Lecture lecture) {
        return lecture.date - this.date;
    }
}
