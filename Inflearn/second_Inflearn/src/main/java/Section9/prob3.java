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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Time(a, 's'));
            list.add(new Time(b, 'e'));
        }

        Collections.sort(list);

        int cnt = 0;
        int answer = 0;
        for (Time ob : list) {
            if (ob.type == 'e') {
                cnt--;
            } else {
                cnt++;
            }
                answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}

class Time implements Comparable<Time> {
    int t;
    char type;

    public Time(int t, char type) {
        this.t = t;
        this.type = type;
    }

    public int compareTo(Time ob) {
        if (ob.t == this.t) {
            return this.type - ob.type;
        } else {
            return this.t - ob.t;
        }
    }


}
