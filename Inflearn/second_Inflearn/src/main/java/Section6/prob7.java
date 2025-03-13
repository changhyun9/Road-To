package Section6;

import java.io.*;
import java.util.*;

public class prob7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<Coord> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            list.add(new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        for (Coord x : list) {
            System.out.println(x.x + " " + x.y);
        }
    }
}

class Coord implements Comparable<Coord>{
    int x;
    int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Coord obj) {
        if (this.x == obj.x) {
            return this.y - obj.y;
        }
        return this.x - obj.x;
    }
}