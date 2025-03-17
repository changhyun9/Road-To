package Section4;

import java.io.*;
import java.util.*;

public class prob5 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        TreeSet<Integer> tree = new TreeSet<>();

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int z = j + 1; z < n; z++) {
                    tree.add(arr[i] + arr[j] + arr[z]);
                }
            }
        }

        int answer = 0;
        if (tree.size() < k) {
            answer = -1;
        } else {
            for (int i = 0; i < k; i++) {
                answer = tree.pollLast();
            }
        }
        System.out.println(answer);

    }
}
