package Section9;

import java.io.*;
import java.util.*;

public class prob2 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int answer = 0;
        List<Meeting> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Meeting(a, b));
        }

        Collections.sort(list);

        int end = Integer.MIN_VALUE;
        for (Meeting ob : list) {
            if (end <= ob.s) {
                end = ob.e;
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

    public int compareTo(Meeting ob){
        if (ob.e == this.e) {
            return this.s - ob.s;
        } else {
            return this.e - ob.e;
        }
    }
}
