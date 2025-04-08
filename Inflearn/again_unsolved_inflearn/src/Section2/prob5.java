package Section2;

import java.io.*;
import java.util.*;

public class prob5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int answer = 0;

        int[] arr = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if(arr[i] == 0) answer++;
            for (int j = i; j <= n; j += i) {
                if(arr[j] == 0) arr[j] =1;
            }
        }

        System.out.println(answer);
    }
}
