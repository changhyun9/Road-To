package Section10;

import java.io.*;
import java.util.*;

public class prob4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        List<Brick> list = new ArrayList<>();
        int[] dy = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int size = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.add(new Brick(size, height, weight));
        }

        Collections.sort(list);

        dy[0] = list.get(0).height;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j).weight > list.get(i).weight) {
                    if (max < dy[j]) {
                        max = dy[j];
                    }
                }
            }
            dy[i] = max + list.get(i).height;
        }

        int answer = 0;
        for (int num : dy) {
            answer = Math.max(answer, num);
        }

        System.out.println(answer);

    }
}

class Brick implements Comparable<Brick>{
    int size;
    int height;
    int weight;

    public Brick(int size, int height, int weight) {
        this.size = size;
        this.height = height;
        this.weight = weight;
    }

    public int compareTo(Brick o){
        return o.size - this.size;
    }
}