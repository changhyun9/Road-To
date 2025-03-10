package Section9;

import java.io.*;
import java.util.*;

public class prob4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<Lecture> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int date = 0;
        int answer = 0;

        // 강의 해설 강연의 수입을 기한을 입력받고, 기한을 기준으로 내림차순 정렬
        // 이후, 기한의 역순으로 접근하면서 해당 날짜에 얻을 수 있는 수익들을 Priority Queue에 삽입
        // Priority Queue를 최대값이 우선 순위가 높게 설정하고, poll함.
        // 그럼 그날 할 수 있는 강의 중 최대 수익을 얻을 수 있음.
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            date = Math.max(date, b); // 가장 늦게하는 강의의 기한을 저장

            list.add(new Lecture(a, b));
        }

        Collections.sort(list); // 강의의 정보를 기한을 기준으로 내림차순 정렬. 즉, 가장 늦게 해도 되는 강의가 앞 순으로 옴.

        int j = 0;
        for (int i = date; i >= 1; i--) { // 가장 늦게하는 강의의 기한을 역순으로 접근
            for (; j < n; j++) { // 해당 날짜에 할 수 있는 강의를 우선 순위 큐에 삽입.
                if (list.get(j).date < i) {
                    break;
                }
                queue.offer(list.get(j).money);
            }
            if (!queue.isEmpty()) {
                answer += queue.poll(); // 해당 날짜에 할 수 있는 강의 중 최대 수익을 뽑아냄.
            }
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

    public int compareTo(Lecture ob) {
        return ob.date - this.date;
    }
}
