package Section7;

import java.io.*;
import java.util.*;

public class prob5 {
    static int n;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        tree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = i;
        }


        front(1);
        System.out.println();
        middle(1);
        System.out.println();
        back(1);
    }

    static void front(int l) {
        System.out.print(l + " ");
        if(l*2 <= n && tree[l*2] > 0) front(l*2);
        if(l*2 +1<= n &&tree[l*2+1] >0) front(l*2+1);
    }

    static void middle(int l) {
        if(l*2 <= n && tree[l*2] > 0) middle(l*2);
        System.out.print(l + " ");
        if(l*2 +1<= n &&tree[l*2+1] >0) middle(l*2+1);
    }

    static void back(int l) {
        if(l*2 <= n && tree[l*2] > 0) back(l*2);
        if(l*2 +1<= n &&tree[l*2+1] >0) back(l*2+1);
        System.out.print(l + " ");
    }

}
