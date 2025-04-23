package Section9;

import java.io.*;
import java.util.*;

public class prob7 {
    static int[] unf;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        unf = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            unf[i] = i;
        }

        List<City> list = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new City(start, end, cost));
        }

        Collections.sort(list);
        int answer = 0;
        for (City obj : list) {
            int fa = find(obj.s);
            int fb = find(obj.e);
            if (fa != fb) {
                answer += obj.c;
                union(obj.e, obj.s);
            }
        }
        System.out.println(answer);
    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }

    static int find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }
}

class City implements Comparable<City> {
    int s;
    int e;
    int c;

    public City(int s, int e, int c) {
        this.s = s;
        this.e = e;
        this.c = c;
    }

    @Override
    public int compareTo(City o) {
        return this.c - o.c;
    }
}