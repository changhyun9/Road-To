package Section10;

import java.io.*;
import java.util.*;

public class prob4 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        Block[] arr = new Block[n];
        int[] dy = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[i] = new Block(s, h, w);
        }

        Arrays.sort(arr);
        dy[0] = arr[0].h;
        int answer = dy[0];

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i].w < arr[j].w && max < dy[j]) {
                    max = dy[j];
                }
            }
            dy[i] = max + arr[i].h;
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }
}

class Block implements Comparable<Block>{
    int s;
    int h;
    int w;

    public Block(int size, int height, int weight) {
        this.s = size;
        this.h = height;
        this.w = weight;
    }

    public int compareTo(Block ob) {
        return ob.s - this.s;
    }
}