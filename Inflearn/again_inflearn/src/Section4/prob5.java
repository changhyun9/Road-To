package Section4;

import java.io.*;
import java.util.*;

public class prob5 {
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

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int z = j + 1; z < n; z++) {
                    int sum = arr[i] + arr[j] + arr[z];
                    if(!list.contains(sum)) list.add(sum);
                }
            }
        }

        Collections.sort(list);
        Collections.reverse(list);

        if (list.size() < k) {
            System.out.println("-1");
        } else {
            System.out.println(list.get(k-1));
        }


    }
}
