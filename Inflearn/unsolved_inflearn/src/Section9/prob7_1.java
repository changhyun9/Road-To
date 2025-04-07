package Section9;

import java.io.*;
import java.util.*;

public class prob7_1 {
    static int[] unf;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0;

        unf = new int[n + 1];
        for(int i=1; i<=n; i++) unf[i] = i;

        List<Road> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Road(v1, v2, cost));
        }

        Collections.sort(list);

        for (Road one : list) {
            int fa = find(one.v1);
            int fb = find(one.v2);
            if (fa != fb) {
                answer += one.cost;
                union(fa, fb);
            }
        }
        System.out.println(answer);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public static int find(int v){
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }
}

class Road implements Comparable<Road> {
    int v1;
    int v2;
    int cost;

    public Road(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    public int compareTo(Road ob) {
        return this.cost - ob.cost;
    }
}
