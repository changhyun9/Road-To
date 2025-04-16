package Section4;

import java.io.*;
import java.util.*;

public class prob3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            if (rt - lt + 1 == k) {
                System.out.print(map.size() + " ");
                if (map.get(arr[lt]) == 1) {
                    map.remove(arr[lt]);
                } else {
                    map.put(arr[lt], map.get(arr[lt]) - 1);
                }
                lt++;
            }
        }
    }
}
