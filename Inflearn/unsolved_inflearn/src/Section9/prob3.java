package Section9;

import java.io.*;
import java.util.*;

public class prob3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int answer =0;

        PriorityQueue<Time> queue = new PriorityQueue<>();


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int in = Integer.parseInt(st.nextToken());
            int out = Integer.parseInt(st.nextToken());

            queue.offer(new Time(in, 'i'));
            queue.offer(new Time(out, 'o'));
        }

        int cnt=0;

        while (!queue.isEmpty()) {
            Time poll = queue.poll();
            if (poll.t == 'o') {
                cnt--;
            } else {
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);

    }
}

class Time implements Comparable<Time>{
    int c;
    char t;

    public Time(int c, char t) {
        this.c = c;
        this.t = t;
    }

    public int compareTo(Time obj) {
        if(obj.c == this.c) return obj.t - this.t;
        return this.c - obj.c;
    }
}
