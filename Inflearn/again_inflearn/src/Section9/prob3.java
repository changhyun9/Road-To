package Section9;

import java.io.*;
import java.util.*;

public class prob3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        List<Time> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            list.add(new Time(Integer.parseInt(st.nextToken()), 's'));
            list.add(new Time(Integer.parseInt(st.nextToken()), 'e'));
        }

        Collections.sort(list);

        int answer = 0;
        int cnt = 0;
        for (Time time : list) {
            if (time.ch == 's') {
                cnt++;
            } else {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}

class Time implements Comparable<Time> {
    int t;
    char ch;

    public Time(int t, char ch) {
        this.t = t;
        this.ch = ch;
    }

    @Override
    public int compareTo(Time o) {
        if(this.t == o.t) return this.ch - o.ch;
        return this.t - o.t;
    }
}