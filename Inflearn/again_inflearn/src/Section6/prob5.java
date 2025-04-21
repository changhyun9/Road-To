package Section6;

import java.io.*;
import java.util.*;

public class prob5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());

        List<String> list = new ArrayList<>();
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            String value = st.nextToken();
            if (list.contains(value)) {
                flag = true;
                break;
            }
            list.add(value);
        }
        if(flag) System.out.println("D");
        else System.out.println("U");
    }
}
