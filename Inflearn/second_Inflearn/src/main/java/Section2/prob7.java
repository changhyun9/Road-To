package Section2;

import java.io.*;
import java.util.*;

public class prob7 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int answer = 0, cnt = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                cnt++;
                answer += cnt;
            }
            else {
                cnt = 0;
            }
        }

        System.out.println(answer);
    }
}
