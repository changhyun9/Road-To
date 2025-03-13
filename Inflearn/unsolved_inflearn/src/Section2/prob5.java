package Section2;

import java.io.*;
import java.util.*;

public class prob5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n + 1];
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                answer++;
                for(int j=i; j<=n; j=j+i) arr[j] = 1;
            }
        }

        System.out.println(answer);
    }
}
