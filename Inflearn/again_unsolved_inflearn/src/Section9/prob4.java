package Section9;

import java.io.*;
import java.util.*;

public class prob4 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        List<Lecture> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int maxDay = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new Lecture(m, d));
            maxDay = Math.max(maxDay, d);
        }

        Collections.sort(list);

        int answer = 0;

        int j=0;
        for (int i = maxDay; i >= 1; i--) {
            for (; j < n; j++) {
                if(i > list.get(j).d) break;
                pq.offer(list.get(j).m);
            }
            if(!pq.isEmpty()) answer += pq.poll();
        }

        System.out.println(answer);


    }
}

class Lecture implements Comparable<Lecture> {
    int m;
    int d;

    public Lecture(int m, int d) {
        this.m = m;
        this.d = d;
    }

    public int compareTo(Lecture o) {
        return o.d - this.d;
    }
}