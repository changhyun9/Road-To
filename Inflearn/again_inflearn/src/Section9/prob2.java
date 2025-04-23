package Section9;

import java.io.*;
import java.util.*;

public class prob2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        Meeting[] arr = new Meeting[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);
        int answer = 1;
        int e = arr[0].e;
        for (int i = 1; i < n; i++) {
            if (arr[i].s >= e) {
                e = arr[i].e;
                answer++;
            }
        }

        System.out.println(answer);

    }

}

class Meeting implements Comparable<Meeting> {
    int s;
    int e;

    public Meeting(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.e == o.e) return this.s-o.s;
        return this.e - o.e;
    }
}