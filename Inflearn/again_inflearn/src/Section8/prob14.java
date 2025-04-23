package Section8;

import java.io.*;
import java.util.*;

public class prob14 {
    static int n, m, answer = Integer.MAX_VALUE;
    static List<Pos> pizzas = new ArrayList<>();
    static List<Pos> homes = new ArrayList<>();
    static int[] ch,tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tmp = new int[m];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) homes.add(new Pos(i,j));
                if(num == 2) pizzas.add(new Pos(i,j));
            }
        }

        ch = new int[pizzas.size()];
        DFS(0, 0);

        System.out.println(answer);
    }

    static void DFS(int L, int idx) {
        if (L == m) {
            int sum = 0;
            for (Pos pos : homes) {
                int dis = Integer.MAX_VALUE;
                for (int num : tmp) {
                    Pos pizza = pizzas.get(num);
                    dis = Math.min(dis, Math.abs(pos.x - pizza.x) + Math.abs(pos.y - pizza.y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = idx; i < pizzas.size(); i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    tmp[L] = i;
                    DFS(L + 1, i);
                    ch[i] = 0;
                }
            }

        }
    }
}

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}